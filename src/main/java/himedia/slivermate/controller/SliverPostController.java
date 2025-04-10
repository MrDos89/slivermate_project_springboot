package himedia.slivermate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import himedia.slivermate.repository.vo.SliverPost;
import himedia.slivermate.service.SliverPostService;

@RestController
@RequestMapping("/api/post")
public class SliverPostController {
	@Autowired
	private SliverPostService sliverPostService;
	
	//	GET : /api/post
	@GetMapping
	public ResponseEntity<List<SliverPost>> selectAllPosts() {
		List<SliverPost> posts = sliverPostService.selectAllPosts();
		
		return ResponseEntity.ok(posts);
	}

	@GetMapping("/{post_id}")
	public ResponseEntity<SliverPost> selectPostById(@PathVariable Long id) {
		SliverPost post = sliverPostService.selectPostById(id);
		
		return ResponseEntity.ok(post);
	}
	
	@PostMapping
	public ResponseEntity<SliverPost> insertNewPost(@RequestBody SliverPost post) {
		SliverPost newPost = sliverPostService.insertNewPost(post);
		
		return ResponseEntity.ok(newPost);
	}
}
