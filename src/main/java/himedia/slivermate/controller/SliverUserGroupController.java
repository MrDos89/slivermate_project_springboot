package himedia.slivermate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import himedia.slivermate.repository.vo.SliverUser;
import himedia.slivermate.repository.vo.SliverUserGroup;
import himedia.slivermate.service.SliverUserGroupService;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/usergroup")
public class SliverUserGroupController {
	@Autowired
	private SliverUserGroupService sliverUserGroupService;
	
//	GET : /api/usergroup
	@GetMapping
	public ResponseEntity<List<SliverUserGroup>> getAllUserGroups() {
		List<SliverUserGroup> userGroups = sliverUserGroupService.selectAllUserGroups();
		
		return ResponseEntity.ok(userGroups);
	}

//	GET : /api/usergroup/{user_group_id}
	@GetMapping("/{user_group_id}")
	public ResponseEntity<List<SliverUser>> getUserGroupUsersById(@PathVariable Long user_group_id) {
		List<SliverUser> selectedUserGroupUsers = sliverUserGroupService.getUserGroupUsersById(user_group_id);
		
		return ResponseEntity.ok(selectedUserGroupUsers);
	}

//	GET : /api/usergroup/login/{user_group_id}/{user_id}
	@GetMapping("/login/{user_group_id}/{user_id}")
	public ResponseEntity<SliverUser> loginByUserIdFromUserGroup(@PathVariable Long user_group_id, @PathVariable Long user_id, HttpSession session) {
		//@note - 세션 정보가 있다면
		if(session != null && session.getAttribute("loginUser") != null) {
			SliverUser loginUser = (SliverUser)session.getAttribute("loginUser");
			return ResponseEntity.ok(loginUser);
		}
		
		SliverUser loginUser = sliverUserGroupService.loginByUserIdFromUserGroup(user_group_id, user_id);
		
		//@note - 로그인 성공
		if (loginUser != null) {
			// @note - 비밀번호 정보 지움
			loginUser.setUser_password("");
			
			//@note -  로그인 시 세션정보 생성
			session.setAttribute("loginUser", loginUser);
			return ResponseEntity.ok(loginUser);
		} else {
			return ResponseEntity.ofNullable(null);
		}
	}

	
//	GET : /api/usergroup/login/{user_group_id}/{user_id}
	@PostMapping("/login/{user_group_id}/{user_id}")
	public ResponseEntity<SliverUser> loginByUserIdWithPinPassword(@RequestBody String pin_password, @PathVariable Long user_group_id, @PathVariable Long user_id, HttpSession session) {

		//@note - 세션 정보가 있다면
		if(session != null && session.getAttribute("loginUser") != null) {
			SliverUser loginUser = (SliverUser)session.getAttribute("loginUser");
			
			if(pin_password != loginUser.getPin_password()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
			}
			// @note - 비밀번호 정보 지움
			loginUser.setUser_password("");
			loginUser.setPin_password("");
			
			return ResponseEntity.ok(loginUser);
		}
		
		SliverUser loginUser = sliverUserGroupService.loginByUserIdFromUserGroup(user_group_id, user_id);
		
		//@note - 로그인 성공
		if (loginUser != null) {
			if(pin_password != loginUser.getPin_password()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
			}
			
			// @note - 비밀번호 정보 지움
			loginUser.setUser_password("");
			loginUser.setPin_password("");
			
			//@note -  로그인 시 세션정보 생성
			session.setAttribute("loginUser", loginUser);
			return ResponseEntity.ok(loginUser);
		} else {
			return ResponseEntity.ofNullable(null);
		}
	}
	
//	POST : /api/usergroup
	@PostMapping
	public ResponseEntity<SliverUserGroup> insertUserGroup(@RequestBody SliverUserGroup userGroup) {
		SliverUserGroup newUserGroup = sliverUserGroupService.insertUserGroup(userGroup);
		
		return ResponseEntity.ok(newUserGroup);
	}
	
//	PATCH : /api/usergroup/{user_group_id}
	@PatchMapping("/{user_group_id}")
	public ResponseEntity<SliverUserGroup> updateUserGroup(@RequestBody SliverUserGroup userGroup, @PathVariable Long user_group_id) {
		userGroup.setUser_group_id(user_group_id);
		SliverUserGroup newUserGroup = sliverUserGroupService.updateUserGroup(userGroup);
		
		return ResponseEntity.ok(newUserGroup);
	}
	
//	Session : /api/usergroup/session -> 로그인 상태 확인
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
