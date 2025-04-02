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
