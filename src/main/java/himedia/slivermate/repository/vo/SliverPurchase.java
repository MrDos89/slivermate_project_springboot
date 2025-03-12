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
	private Long id;
	private Long sku;
	private Long uid;
	private Long club_id;
	private String receipt_id;
	private Integer price;
	private boolean is_monthly_paid;
	private Date upd_date;
	
}
