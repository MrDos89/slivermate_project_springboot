package himedia.slivermate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
//	GET : /api/usergroup/login/{user_id}
	@GetMapping("/login/{user_id}")
	public ResponseEntity<SliverUser> loginByUserIdFromUserGroup(@PathVariable Long user_id) {
		SliverUser loginUser = sliverUserGroupService.loginByUserIdFromUserGroup(user_id);
		
		return ResponseEntity.ok(loginUser);
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
}
