package himedia.slivermate.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import himedia.slivermate.service.SliverLikeService;

@RestController
@RequestMapping("/api/like")
public class SliverLikeController {

    @Autowired
    private SliverLikeService sliverLikeService;

    @GetMapping("/checkAll")
    public ResponseEntity<Map<String, Object>> getLikedPostIds(@RequestParam int user_id) {
        List<Integer> likedPostIds = sliverLikeService.getLikedPostIds(user_id);
        Map<String, Object> result = new HashMap<>();
        result.put("likedPostIds", likedPostIds);
        return ResponseEntity.ok(result);
    }
    
    @PostMapping
    public ResponseEntity<String> toggleLike(@RequestParam int post_id, @RequestParam int user_id) {
        boolean liked = sliverLikeService.toggleLike(post_id, user_id);
        return ResponseEntity.ok(liked ? "liked" : "unliked");
    }
    
    @PostMapping("/toggle")
    public ResponseEntity<Map<String, Object>> toggleLikeAndCount(
        @RequestParam int post_id,
        @RequestParam int user_id
    ) {
        Map<String, Object> result = sliverLikeService.toggleLikeAndUpdateCount(post_id, user_id);
        return ResponseEntity.ok(result);
    }

    
}
