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
	private Long club_id;				// 동아리 고유 아이디
	private String club_name;			// 동아리 이름
	private Integer club_category_id;	// 동아리 카데고리 아이디
	private String club_thumbnail;		// 동아리 썸네일
	private String club_movie;			// 동아리 홍보영상 링크
	private String club_desc;			// 동아리 설명 
	private Integer club_member_num;	// 동아리 현재 인원 수
	private Integer club_member_max;	// 동아리 최대 인원 수
	private String club_member_list;	// 동아리 멤버 리스트
	private Integer club_report_cnt;	// 동아리 신고 횟수
	private Boolean is_deleted;			// 삭제 여부
	private Date upd_date;				// 업데이트 날짜
}
