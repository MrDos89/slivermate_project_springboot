package himedia.slivermate.repository.vo;

import java.util.Date;
import java.util.Map;

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
public class SliverPost {
	private Long post_id;
	private String userThumbnail;
	private String nickname;
	private Integer region_id;
	private Long category_id;
	private Long sub_category_id;
	private String post_note;
	private Integer like_count;
	private Integer comment_count;
	private Map<Long, String> image_list;
	private Date register_date;
	private Long club_id;
	private Map<Long, String> comment_list;
	private Date upd_date;
}
