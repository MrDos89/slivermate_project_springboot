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
public class SliverClub {
	private Long club_id;				// 모임 고유 번호
	private String club_name;			// 모임 이름 
	private Long club_user_id;			// 모임장 아이디
	private Long club_category_id;		// 모임 카데고리 고유 번호
	private Long club_sub_category_id;	// 모임 세부 카데고리 고유 번호 
	private String club_thumbnail;		// 모임 썸네일
	private String club_movie;			// 모임 홍보 영상
	private String club_desc;			// 모임 설명
	private Integer club_member_number;	// 모임 현재 인원 수
	private Integer club_member_max;	// 모임 전체 인원 수
	private Integer club_report_cnt;	// 모임 신고 당한 횟수
	private Date club_register_date;	// 모임 개설 날짜
	private boolean is_deleted;			// 모임 삭제 여부 (숨김 여부)
	private Date upd_date;				// 업데이트 일시
	private String user_name;  			// 모임장 닉네임
}
