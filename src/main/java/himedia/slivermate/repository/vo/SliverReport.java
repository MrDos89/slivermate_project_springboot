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
public class SliverReport {
	private Long id;				// 신고글 번호
	private Long user_id;			// 신고한 유저번호
	private Long lesson_id;			// 신고당한 게시글 번호
	private Integer report_id;		// 신고 사유
	private String report_content;  // 신고 내용
	private Boolean is_confirmed;	// 신고처리 완료 여부
	private Date upd_date;			// 신고 일시
}
