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
public class SliverComment {
	private Long comment_id;
	private Long post_id;
	private Long user_id;
	private Long club_id;
	private String comment_text;
	private Date upd_date;
	
	private String user_thumbnail;
	private String user_nickname;
}
