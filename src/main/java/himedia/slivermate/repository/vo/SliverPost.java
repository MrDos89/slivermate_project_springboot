package himedia.slivermate.repository.vo;

import java.util.Date;
import java.util.List;
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
	private Long club_id;
	private Integer region_id;
	private Long category_id;
	private Long sub_category_id;
	private String post_note;
	private Map<Long, String> post_images;
	private Integer post_like_count;
	private Integer post_comment_count;
	private Date register_date;
	private Date upd_date;

	private String userThumbnail;
	private String nickname;
	private List<SliverComment> comments;
}
