package himedia.slivermate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.slivermate.mappers.SliverPostMapper;
import himedia.slivermate.repository.vo.SliverLike;

@Service
public class SliverLikeService {

	@Autowired
	private himedia.slivermate.mappers.SliverLikeMapper sliverLikeMapper;
	@Autowired
	private SliverPostMapper sliverPostMapper;
	@Autowired
    private SliverPostService sliverPostService;
    
	// 좋아요 토글
	public boolean toggleLike(SliverLike vo) {
	    int exists = sliverLikeMapper.exists(vo);

	    if (exists == 0) {
	        // 처음 누른 경우
	        boolean inserted = sliverLikeMapper.insertLike(vo) > 0;
	        if (inserted) {
	        	sliverPostMapper.incrementLikeCount((long) vo.getPost_id());
	        }
	        return inserted;

	    } else {
	        boolean isLiked = sliverLikeMapper.isLiked(vo) > 0;

	        if (isLiked) {
	            // 좋아요 취소
	            boolean deleted = sliverLikeMapper.deleteLike(vo) > 0;
	            if (deleted) {
	                sliverPostMapper.decrementLikeCount((long)vo.getPost_id());
	            }
	            return deleted;

	        } else {
	            // 다시 좋아요
	            boolean updated = sliverLikeMapper.updateLike(vo) > 0;
	            if (updated) {
	                sliverPostMapper.incrementLikeCount((long)vo.getPost_id());
	            }
	            return updated;
	        }
	    }
	}



	

	public List<Integer> getLikedPostIds(int user_id) {
		return sliverLikeMapper.selectLikedPostIdsByUserId(user_id);
	}
	
	
	public int getLikeCount(int post_id) {
		return sliverLikeMapper.getLikeCount(post_id);
	}
	
	public boolean isLiked(SliverLike vo) {
		Integer result = sliverLikeMapper.isLiked(vo);
		return result != null && result == 1;
	}

}
