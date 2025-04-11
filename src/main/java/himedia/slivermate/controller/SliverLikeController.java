package himedia.slivermate.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import himedia.slivermate.repository.vo.SliverLike;
import himedia.slivermate.service.SliverLikeService;

@RestController
@RequestMapping("/api/like")
public class SliverLikeController {

	@Autowired
	private SliverLikeService sliverLikeService;

	@PostMapping("/toggle")
	public ResponseEntity<String> toggleLike(@RequestBody SliverLike vo) {
		boolean result = sliverLikeService.toggleLike(vo);
		
		return result ? ResponseEntity.ok("좋아요 완료")
				: ResponseEntity.status(HttpStatus.BAD_REQUEST).body("토글 실패");
	}

	@GetMapping("/checkAll")
	public ResponseEntity<Map<String, Object>> getLikedPostIds(@RequestParam int user_id) {
		List<Integer> likedPostIds = sliverLikeService.getLikedPostIds(user_id);
		Map<String, Object> result = new HashMap<>();
		result.put("likedPostIds", likedPostIds);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/count")
	public ResponseEntity<Integer> getLikeCount(@RequestParam("post_id") int post_id) {
		int count = sliverLikeService.getLikeCount(post_id);
		return ResponseEntity.ok(count);
	}

	// 사용자가 해당 리뷰에 좋아요 눌렀는지 확인
		@GetMapping("/is-liked")
		public ResponseEntity<Boolean> isLiked(@RequestParam("user_id") int user_id,
				@RequestParam("post_id") int post_id) {
			SliverLike vo = new SliverLike();
			vo.setUser_id(user_id);
			vo.setPost_id(post_id);
			Boolean isLiked = sliverLikeService.isLiked(vo);
			return ResponseEntity.ok(isLiked != null && isLiked);
		}
		
}
