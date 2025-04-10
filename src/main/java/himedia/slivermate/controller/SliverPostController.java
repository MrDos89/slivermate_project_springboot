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
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PatchMapping("/updateCount")
	public ResponseEntity<SliverPost> updatePostLikeCount(
	    @RequestParam Long post_id,
	    @RequestParam boolean likedByMe) {
	    
	    SliverPost updatedPost = sliverPostService.updatePostLikeCount(post_id, likedByMe);
	    return ResponseEntity.ok(updatedPost);
	}

	 
	    @GetMapping("/with-like")
	    public ResponseEntity<List<SliverPost>> selectAllPostsWithUserLike(@RequestParam int user_id) {
	        // 사용자가 좋아요를 눌렀는지 여부와 좋아요 수를 포함한 게시글 반환
	        List<SliverPost> posts = sliverPostService.selectAllPostsWithUserLike(user_id);
	        return ResponseEntity.ok(posts);  // 결과를 JSON 형식으로 반환
	    }
}
