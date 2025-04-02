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
public class SliverUserGroup {
	private Long user_group_id;	// 유저 그룹 아이디
	private Long user_1_id;		// 유저 1 고유 번호
	private Long user_2_id;		// 유저 2 고유 번호
	private Long user_3_id;		// 유저 3 고유 번호
	private Long user_4_id;		// 유저 4 고유 번호
	private Date upd_date;		// 업데이트 날짜
}
