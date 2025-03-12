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
	private Long lesson_id;
	private String lesson_name;
	private String lesson_desc;
	private Integer lesson_category;
	private String lesson_free_lecture;
	private String lesson_cost_lecture;
	private String lesson_thumbnail;
	private Integer lesson_price;
	private Date register_date;
	private Date upd_date;
}
