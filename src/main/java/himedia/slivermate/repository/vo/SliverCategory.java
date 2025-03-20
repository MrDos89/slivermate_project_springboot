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
public class SliverCategory {
	private Long id;
	private Long category_id;
	private String category_name;
	private Long sub_category_id;
	private String sub_category_name;
	private String image;
	private Date upd_date;
}
