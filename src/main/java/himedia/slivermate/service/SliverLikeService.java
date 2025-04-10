package himedia.slivermate.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.slivermate.repository.vo.SliverLike;

@Service
public class SliverLikeService {

	@Autowired
	private himedia.slivermate.mappers.SliverLikeMapper sliverLikeMapper;

//	// 좋아요 이미 한 건지 확인
	public boolean isLiked(int postId, int userId) {
		SliverLike like = new SliverLike();
		like.setPost_id(postId);
		like.setUser_id(userId);

		return sliverLikeMapper.isLiked(like) > 0;
	}

	public boolean toggleLike(int postId, int userId) {
		SliverLike like = new SliverLike();
		like.setPost_id(postId);
		like.setUser_id(userId);

		if (sliverLikeMapper.isLiked(like) > 0) {
			sliverLikeMapper.deleteLike(like);
			return false; // 좋아요 취소
		} else {
			sliverLikeMapper.insertLike(like);
			return true; // 좋아요 추가
		}
	}

	public List<Integer> getLikedPostIds(int userId) {
		return sliverLikeMapper.selectLikedPostIdsByUserId(userId);
	}

	public Map<String, Object> toggleLikeAndUpdateCount(int postId, int userId) {
		SliverLike like = new SliverLike();
		like.setPost_id(postId);
		like.setUser_id(userId);

		// 1. 좋아요 토글
		boolean liked;
		if (sliverLikeMapper.isLiked(like) > 0) {
			sliverLikeMapper.deleteLike(like);
			liked = false;
		} else {
			sliverLikeMapper.insertLike(like);
			liked = true;
		}

		// 2. 전체 좋아요 수 가져오기
		int likeCount = sliverLikeMapper.getLikeCount(postId);

		// 3. 게시글 테이블에 count 업데이트
		sliverLikeMapper.updatePostLikeCount(postId, likeCount);

		// 4. 결과 리턴
		Map<String, Object> result = new HashMap<>();
		result.put("liked", liked);
		result.put("totalLikes", likeCount);
		return result;
	}

}
