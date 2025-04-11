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
		SliverPost insertedPost = sliverPostMapper.selectPostById(id);

		// 새로 작성된 글은 당연히 좋아요를 누른 상태가 아니므로 false로 설정
		insertedPost.setLiked_by_me(false);

		return insertedPost;
	}
	
	public SliverPost updatePostLikeCount(Long post_id, boolean isLiked) {
	    SliverPost post = sliverPostMapper.selectPostById(post_id);

	    if (post != null) {
	        if (post.isLiked_by_me() != isLiked) {
	            int count = post.getPost_like_count();
	            post.setPost_like_count(isLiked ? count + 1 : count - 1);
	            sliverPostMapper.updatePostLikeCount(post_id, post.getPost_like_count());
	        }

	        post.setLiked_by_me(isLiked);
	    }

	    return post;
	}



	public List<SliverPost> selectAllPostsWithUserLike(int user_id) {
	    return sliverPostMapper.selectAllPostsWithUserLike(user_id);
	}


}
