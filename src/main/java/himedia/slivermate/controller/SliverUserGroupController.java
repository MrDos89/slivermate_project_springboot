package himedia.slivermate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import himedia.slivermate.repository.vo.SliverUserGroup;
import himedia.slivermate.service.SliverUserGroupService;

@RestController
@RequestMapping("/api/usergroup")
public class SliverUserGroupController {
	@Autowired
	private SliverUserGroupService sliverUserGroupService;
	
//	GET : /api/user
	@GetMapping
	public ResponseEntity<List<SliverUserGroup>> getAllUsers() {
		List<SliverUserGroup> users = sliverUserGroupService.selectAllUsers();
		
		return ResponseEntity.ok(users);
	}
}
