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
            System.out.println("[Memcached] saving last message to key: chat:lastMessage:" + roomId);
            memcachedClient.set("chat:lastMessage:" + roomId, EXPIRE_TIME, json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public ChatMessageDto getLastMessage(String roomId) {
        String key = "chat:lastMessage:" + roomId;
        System.out.println("🔍 Memcached 조회 시도: " + key);

        Object data = memcachedClient.get(key);
        if (data == null) {
            System.out.println("❌ Memcached에서 데이터 없음: " + key);
            return null;
        }

        System.out.println("✅ Memcached에서 데이터 가져옴: " + data.toString());

        try {
            ChatMessageDto result = objectMapper.readValue(data.toString(), ChatMessageDto.class);
            System.out.println("✅ JSON 디코딩 성공: " + result);
            return result;
        } catch (JsonProcessingException e) {
            System.out.println("🔥 JSON 디코딩 실패");
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