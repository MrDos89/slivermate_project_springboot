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
public class SliverUser {
	private Long uid;			// 유저 회원번호
	private String user_name;		// 이름
	private String nickname;	// 닉네임
	private String user_id;		// 유저 아이디
	private String user_password;	// 비밀번호
	private String tel_number;	// 전화번호
	private String email;		// 이메일
	private String thumbnail;	// 썸네일 주소
	private Long gu_id;			// 구 정보
	private Long recommend_uid;	// 추천인 회원번호
	private Date register_date; 	// 가입일자
	private Boolean is_deleted;	// 유저정보(탈퇴) 삭제 여부
	private Boolean is_admin;	// 관리자 계정 여부
	private Date upd_date;		// 갱신시간
}
