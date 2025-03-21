package himedia.slivermate.repository.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SliverNotification {
	private Long id;			// 알람 고유 번호
	private Long receive_uid;	// 알람 받는 유저번호
	private Long send_uid;		// 알람 보낸 유저 (신고, 구매 희망, 구매 확정 등)
	private Integer noti_id; 	// 알람 사유 (신고, 구매 희망, 구매 확정 등)
	private Boolean is_read;		// 알람 읽었는지 여부
	private Date upd_date;		// 알람 업데이트 시간
}
