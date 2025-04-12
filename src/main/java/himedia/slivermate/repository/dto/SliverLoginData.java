package himedia.slivermate.repository.dto;

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
public class SliverLoginData {
	private String user_id;		// 유저 아이디
	private String password;	// 비밀번호
}
