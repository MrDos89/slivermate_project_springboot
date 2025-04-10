package himedia.slivermate.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.slivermate.repository.vo.SliverLike;
import himedia.slivermate.mappers.SliverPostMapper;

@Service
public class SliverLikeService {

	@Autowired
	private himedia.slivermate.mappers.SliverLikeMapper sliverLikeMapper;
	@Autowired
	private SliverPostMapper sliverPostMapper;
	
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

	    boolean liked;

	    // 1. 토글 처리
	    if (sliverLikeMapper.isLiked(like) > 0) {
	        sliverLikeMapper.deleteLike(like);
	        liked = false;
	    } else {
	        sliverLikeMapper.insertLike(like);
	        liked = true;
	    }

	    // 2. 전체 좋아요 수 가져오기
	    int post_like_count = sliverLikeMapper.getLikeCount(post_id);

	    // 3. 게시글 테이블에도 반영 (PostMapper 호출)
	    sliverPostMapper.updatePostLikeCount((long) post_id, post_like_count);

	    // 4. 결과 반환
	    Map<String, Object> result = new HashMap<>();
	    result.put("liked", liked);
	    result.put("post_like_count", post_like_count); // count도 넘김
	    return result;
	}


}
