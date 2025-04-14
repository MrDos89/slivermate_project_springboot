package himedia.slivermate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import himedia.slivermate.repository.dto.SliverLoginData;
import himedia.slivermate.repository.vo.SliverUser;
import himedia.slivermate.service.SliverUserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user")
public class SliverUserController {
	@Autowired
	private SliverUserService sliverUserService;
	
//	GET : /api/user
	@GetMapping
	public ResponseEntity<List<SliverUser>> getAllUsers() {
		List<SliverUser> users = sliverUserService.selectAllUsers();
		
		return ResponseEntity.ok(users);
	}
	
//	POST : /api/user/login -> 로그인
	@PostMapping("/login")
	public ResponseEntity<SliverUser> loginUser(@RequestBody SliverLoginData loginData) {
		//@note - 유저가 친 아이디나 비번이 없을 경우
		if (loginData.getUser_id().length() == 0 || loginData.getPassword().length() == 0) {
			System.err.println("no user_id or password");
			
			return ResponseEntity.ofNullable(null);
		}
		
		SliverUser loginUser = sliverUserService.loginUser(loginData);
		
		return ResponseEntity.ok(loginUser);
	}
	
	//@note - 세선 정보 소멸
	@GetMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) {
	    HttpSession session = request.getSession(false);
	    if (session != null) {
	        session.invalidate();
	    }

	    // JSESSIONID 쿠키 삭제 (브라우저에게 명령)
	    ResponseCookie deleteCookie = ResponseCookie.from("JSESSIONID", "")
	        .path("/")
	        .maxAge(0)
	        .httpOnly(true)
	        .domain("43.201.50.194") // 👈 명시적으로 추가
	        .sameSite("Lax")
	        .secure(false) // HTTPS면 true
	        .build();

	    response.setHeader(HttpHeaders.SET_COOKIE, deleteCookie.toString());
	}
	
//	POST : /api/user -> 새로운 유저 항목 생성
	@PostMapping
	public ResponseEntity<SliverUser> createUser(@RequestBody SliverUser user) {
		SliverUser savedUser = sliverUserService.registerUser(user);
		return ResponseEntity.ok(savedUser);
		//	ResponseEntity.created로 하는 것이 의미상 더 나을 수도 있다.
	}
	
//	PUT : /api/user/{uid} -> 기존 유저 항목 수정
	@PutMapping("/{uid}")
	public ResponseEntity<SliverUser> updateUser(@RequestBody SliverUser user, @PathVariable Long uid) {
		user.setUid(uid);
		SliverUser updatedUser = sliverUserService.updateUser(user);
		return ResponseEntity.ok(updatedUser);
	}
	
//	DELETE : /api/user/{uid} -> 기존 유저 항목 삭제
	@DeleteMapping("/{uid}")
	//	Body에 실어 보낼 내용이 없음 -> Void
	public ResponseEntity<Void> deleteUser(@PathVariable Long uid) {
		sliverUserService.deleteUser(uid);
		return ResponseEntity.ok().<Void>build();
	}
	
//	Session : /api/user/session -> 로그인 상태 확인
	@GetMapping("/session")
	public ResponseEntity<SliverUser> getSessionUser(HttpSession session) {
		SliverUser loginUser = (SliverUser) session.getAttribute("loginUser");
		
		if (loginUser != null) {
			return ResponseEntity.ok(loginUser);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
	}
}
