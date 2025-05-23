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
public class SliverLesson {
	private Long lesson_id;				// 강의 고유 아이디
	private Long lesson_group_id;		// 강의 재생목록 아이
	private Long user_id;				// 강의 올린 사람 유저 아이디
	private String lesson_name;			// 강의 이름
	private String lesson_desc;			// 강의 상세 설명
	private Integer lesson_category;	// 강의 대분류 카데고리 (실내:1, 야외:2)
	private Integer lesson_sub_category;// 강의 세부 카데고리
	private String lesson_lecture;		// 강의 영상 링크
	private Integer like_count;			// 좋아요 카운트
	private Integer view_count;			// 시청 카운트
	private Date register_date;			// 강의 등록 시간
	private boolean is_hidden;			// 강의 숨김처리 여부
	private Date upd_date;				// 강의 업데이트 시간
	
	private String user_name;			// 강의 올린 사람 이름
	private String user_thumbnail;		// 강의 올린 사람 썸네일
}
