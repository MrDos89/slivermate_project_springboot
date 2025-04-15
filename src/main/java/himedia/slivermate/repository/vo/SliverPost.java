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
	private Long post_user_id;
	private Long club_id;
	private Integer region_id;
	private Long post_category_id;
	private Long post_sub_category_id;
	private String post_note;
	private List<String> post_images; // MAP<LONG, STRING>
	private Integer post_like_count;
	private Integer post_comment_count;
	private List<SliverComment> post_comments;
	private boolean is_hidden;
	private Integer post_report_count;
	private Date register_date;
	private Date upd_date;

	// @note - JOIN sliver_user
	private String user_thumbnail;
	private String nickname;
	
	// 가상 컬럼
	private boolean liked_by_me;
	
	public boolean isLiked_by_me() {
	    return liked_by_me;
	}

	public void setLiked_by_me(boolean liked_by_me) {
	    this.liked_by_me = liked_by_me;
	}
}

