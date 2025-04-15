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
public class SliverAnnouncement {
	private Long announce_id;
	private Long club_id;
	private String announce_title;
	private String announce_date;
	private String announce_time;
	private String announce_location;
	private String announce_desc;
	private Integer meeting_price;
	private Integer attend_count;
	private Integer announce_type;
	private Date upd_date;
}
