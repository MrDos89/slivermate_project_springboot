package himedia.slivermate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import himedia.slivermate.repository.vo.SliverPost;
import himedia.slivermate.service.SliverPostService;

@RestController
@RequestMapping("/api/post")
public class SliverPostController {
	@Autowired
	private SliverPostService sliverPostService;
	
	public ResponseEntity<List<SliverPost>> selectAllPosts() {
		List<SliverPost> posts = sliverPostService.selectAllPosts();
		
		return ResponseEntity.ok(posts);
	}
}
