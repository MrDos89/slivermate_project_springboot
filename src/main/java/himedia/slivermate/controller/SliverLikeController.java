package himedia.slivermate.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
    public ResponseEntity<Map<String, Object>> getLikedPostIds(@RequestParam int userId) {
        List<Integer> likedPostIds = sliverLikeService.getLikedPostIds(userId);
        Map<String, Object> result = new HashMap<>();
        result.put("likedPostIds", likedPostIds);
        return ResponseEntity.ok(result);
    }
    
    @PostMapping
    public ResponseEntity<String> toggleLike(@RequestParam int postId, @RequestParam int userId) {
        boolean liked = sliverLikeService.toggleLike(postId, userId);
        return ResponseEntity.ok(liked ? "liked" : "unliked");
    }
    
    @PatchMapping("/updateCount")
    public ResponseEntity<Map<String, Object>> toggleLikeAndUpdateCount(
        @RequestParam int postId,
        @RequestParam int userId) {

        Map<String, Object> result = sliverLikeService.toggleLikeAndUpdateCount(postId, userId);
        return ResponseEntity.ok(result);
    }
}
