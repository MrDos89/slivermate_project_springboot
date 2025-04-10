package himedia.slivermate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.slivermate.mappers.SliverPostMapper;
import himedia.slivermate.repository.vo.SliverPost;

@Service
public class SliverPostService {
	@Autowired
	private SliverPostMapper sliverPostMapper;
	
	
	public List<SliverPost> selectAllPosts() {
		List<SliverPost> posts = sliverPostMapper.selectAllPosts();
		
		return posts;
	}
	
	public SliverPost selectPostById(Long post_id) {
		SliverPost post = sliverPostMapper.selectPostById(post_id);
		
		return post;
	}
	
	public SliverPost insertNewPost(SliverPost post) {
		sliverPostMapper.insertNewPost(post);
		
		Long id = post.getPost_id();
		
		return sliverPostMapper.selectPostById(id);
	}
	
	public SliverPost updatePostLikeCount(Long post_id, boolean isLiked) {
	    // 게시글을 먼저 조회
	    SliverPost post = sliverPostMapper.selectPostById(post_id);

	    if (post != null) {
	        // 현재 좋아요 상태가 다르면
	        if (post.getLikedByMe() != isLiked) {
	            if (isLiked) {
	                // 좋아요를 추가하는 경우
	                post.setPost_like_count(post.getPost_like_count() + 1); // 좋아요 수 증가
	            } else {
	                // 좋아요를 취소하는 경우
	                post.setPost_like_count(post.getPost_like_count() - 1); // 좋아요 수 감소
	            }

	            // 데이터베이스에 업데이트된 좋아요 수 반영
	            sliverPostMapper.updatePostLikeCount(post_id, post.getPost_like_count());
	        }

	        // 좋아요 상태를 갱신 (isLikedByMe가 true/false로 변경)
	        post.setLikedByMe(isLiked);
	    }

	    return post;
	}
	
	public List<SliverPost> selectAllPostsWithUserLike(int user_id) {
	    return sliverPostMapper.selectAllPostsWithUserLike(user_id);
	}


}
