package himedia.slivermate.controller;

import org.springframework.web.bind.annotation.*;

import himedia.slivermate.repository.dto.ChatMessageDto;
import himedia.slivermate.service.ChatRoomMemcachedService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/chatroom")
@RequiredArgsConstructor
public class ChatRoomController {

    private final ChatRoomMemcachedService memcachedService;

    // 채팅방 마지막 메시지 저장
    @PostMapping("/{roomId}/last-message")
    public void saveLastMessage(
            @PathVariable String roomId,
            @RequestBody ChatMessageDto messageDto
    ) {
        memcachedService.saveLastMessage(roomId, messageDto);
    }

    // 채팅방 마지막 메시지 조회
    @GetMapping("/{roomId}/last-message")
    public ChatMessageDto getLastMessage(@PathVariable String roomId) {
        return memcachedService.getLastMessage(roomId);
    }

    // 읽지 않은 메시지 수 저장
    @PostMapping("/{roomId}/unread/{userId}")
    public void saveUnreadCount(
            @PathVariable String roomId,
            @PathVariable String userId,
            @RequestParam int count
    ) {
        memcachedService.saveUnreadCount(roomId, userId, count);
    }

    // 읽지 않은 메시지 수 조회
    @GetMapping("/{roomId}/unread/{userId}")
    public int getUnreadCount(
            @PathVariable String roomId,
            @PathVariable String userId
    ) {
        return memcachedService.getUnreadCount(roomId, userId);
    }
}
