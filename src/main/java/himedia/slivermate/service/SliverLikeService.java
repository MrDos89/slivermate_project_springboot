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
	
	// 좋아요 토글
	public boolean toggleLike(SliverLike vo) {
		int exists = sliverLikeMapper.exists(vo);
		
		if(exists == 0) {
			return sliverLikeMapper.insertLike(vo) > 0;
		} else {
			boolean isLiked = sliverLikeMapper.isLiked(vo) > 0;
			
			if(isLiked) {
				return sliverLikeMapper.deleteLike(vo) > 0;
			} else {
				return sliverLikeMapper.updateLike(vo) > 0;
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
