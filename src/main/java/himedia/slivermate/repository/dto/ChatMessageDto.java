package himedia.slivermate.repository.dto;

import himedia.slivermate.enums.ChatMessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageDto {

    private ChatMessageType type;   // 메시지 타입 (ENTER, TALK, QUIT, NEGO_REQ, NEGO_ALLOW, NEGO_DENIED, DELETE)
    private String roomId;      // 방 번호
    private Long userId;        // 사용자 id
    private String message;     // 메시지
    private String time;        // 전송 시간
    private long userCount;     // 채팅방 인원 수
}