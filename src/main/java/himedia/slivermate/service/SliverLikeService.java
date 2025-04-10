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
	public boolean isLiked(int post_id, int user_id) {
		SliverLike like = new SliverLike();
		like.setPost_id(post_id);
		like.setUser_id(user_id);

		return sliverLikeMapper.isLiked(like) > 0;
	}

	public boolean toggleLike(int post_id, int user_id) {
		SliverLike like = new SliverLike();
		like.setPost_id(post_id);
		like.setUser_id(user_id);

		if (sliverLikeMapper.isLiked(like) > 0) {
			sliverLikeMapper.deleteLike(like);
			return false; // 좋아요 취소
		} else {
			sliverLikeMapper.insertLike(like);
			return true; // 좋아요 추가
		}
	}

	public List<Integer> getLikedPostIds(int user_id) {
		return sliverLikeMapper.selectLikedPostIdsByUserId(user_id);
	}

	public Map<String, Object> toggleLikeAndUpdateCount(int post_id, int user_id) {
		SliverLike like = new SliverLike();
		like.setPost_id(post_id);
		like.setUser_id(user_id);

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
		int post_like_count = sliverLikeMapper.getLikeCount(post_id);

		// 3. 결과 리턴
		Map<String, Object> result = new HashMap<>();
		result.put("liked", liked);
		return result;
	}

}
