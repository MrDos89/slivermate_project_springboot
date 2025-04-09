package himedia.slivermate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.slivermate.repository.vo.SliverLike;

@Service
public class SliverLikeService {

	@Autowired
	private himedia.slivermate.mappers.SliverLikeMapper sliverLikeMapper;

	// 좋아요 이미 한 건지 확인
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
	
}
