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
	private Long user_id;				// 강의 올린 사람 유저 아이디
	private String lesson_name;			// 강의 이름
	private String lesson_desc;			// 강의 설명
	private String lesson_cost_desc;	// 강의 설명 (유료용)
	private Integer lesson_category;		// 강의 대분류 카데고리 (실내:1, 야외:2)
	private Integer lesson_sub_category;	// 강의 세부 카데고리
	private String lesson_free_lecture;	// 무료 영상 (30초) 링크
	private String lesson_cost_lecture;	// 유료 영상 (20분) 링크
	private String lesson_thumbnail;	// 강의 썸네일
	private Integer lesson_price;		// 강의 가격
	private Date register_date;			// 강의 등록 시간
	private boolean is_hidden;			// 강의 숨김처리 여부
	private Date upd_date;				// 강의 업데이트 시간
	
	private String user_name;			// 강의 올린 사람 이름
	private String user_thumbnail;		// 강의 올린 사람 썸네일
}
