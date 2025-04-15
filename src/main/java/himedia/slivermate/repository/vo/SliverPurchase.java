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
public class SliverPurchase {
	private Long id;					// 결제 고유 아이디
	private Long sku;					// 결제 sku 아이디
	private Long uid;					// 결제한 유저 아이디
	private Long lesson_id;				// 결제한 레슨 아이디
	private Integer model_type;			// 결제 수단
	private Long club_id;				// 결제한 유저 소속 동아리
	private String receipt_id;			// 결제 영수증
	private Integer price;				// 결제 가격
	private boolean is_monthly_paid;	// 구독 모델인지 여부
	private Date upd_date;				// 업데이트 날짜
	
	// @note - JOIN sliver_announce_id
	private Long announce_id;	
}
