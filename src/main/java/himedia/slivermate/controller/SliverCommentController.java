package himedia.slivermate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import himedia.slivermate.repository.vo.SliverComment;
import himedia.slivermate.service.SliverCommentService;

@RestController
@RequestMapping("/api/comment")
public class SliverCommentController {
	@Autowired
	private SliverCommentService sliverCommentService;
	
	@GetMapping
	public ResponseEntity<List<SliverComment>> selectAllPosts() {
		List<SliverComment> comments = sliverCommentService.selectAllComments();
		
		return ResponseEntity.ok(comments);
	}
	
    @PostMapping("/newcomment")
    public ResponseEntity<String> insertComment(@RequestBody SliverComment comment) {
        sliverCommentService.insertComment(comment);
        return ResponseEntity.ok("success");
    }
    
    @GetMapping("/by-post")
    public ResponseEntity<List<SliverComment>> getCommentsByPost(@RequestParam Long post_id) {
        List<SliverComment> comments = sliverCommentService.selectCommentsByPostId(post_id);
        return ResponseEntity.ok(comments);
    }
}
