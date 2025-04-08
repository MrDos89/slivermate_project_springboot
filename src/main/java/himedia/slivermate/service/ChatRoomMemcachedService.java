package himedia.slivermate.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import himedia.slivermate.repository.dto.ChatMessageDto;
import lombok.RequiredArgsConstructor;
import net.spy.memcached.MemcachedClient;

@RequiredArgsConstructor
@Service
public class ChatRoomMemcachedService {

    private final MemcachedClient memcachedClient;
    private final ObjectMapper objectMapper;
    
    private final int EXPIRE_TIME = (int) TimeUnit.HOURS.toSeconds(6); // 6시간 TTL

 // ChatRoomMemcachedService.java 내부에서
    public void saveLastMessage(String roomId, ChatMessageDto dto) {
        try {
            String json = objectMapper.writeValueAsString(dto);
            memcachedClient.set("chat:lastMessage:" + roomId, EXPIRE_TIME, json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public ChatMessageDto getLastMessage(String roomId) {
        Object data = memcachedClient.get("chat:lastMessage:" + roomId);
        if (data == null) return null;

        try {
            return objectMapper.readValue(data.toString(), ChatMessageDto.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 사용자별 읽지 않은 메시지 수 저장
    public void saveUnreadCount(String roomId, String userId, int count) {
        String key = "chat:unread:" + roomId + ":" + userId;
        memcachedClient.set(key, EXPIRE_TIME, count);
    }

    // 사용자별 읽지 않은 메시지 수 조회
    public int getUnreadCount(String roomId, String userId) {
        String key = "chat:unread:" + roomId + ":" + userId;
        Object result = memcachedClient.get(key);
        return result != null ? Integer.parseInt(result.toString()) : 0;
    }
}