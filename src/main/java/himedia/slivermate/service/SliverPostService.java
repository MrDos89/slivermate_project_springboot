package himedia.slivermate.service;

import java.util.Date;
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
	    // 🔥 서버에서 현재 시간 직접 세팅
	    post.setRegister_date(new Date());

	    sliverPostMapper.insertNewPost(post);

	    Long id = post.getPost_id();
	    SliverPost insertedPost = sliverPostMapper.selectPostById(id);

	    if (insertedPost == null) {
	        throw new IllegalStateException("게시글 insert 이후 데이터를 불러오지 못했습니다.");
	    }

	    insertedPost.setLiked_by_me(false);

	    return insertedPost;
	}

	
	public SliverPost updatePostLikeCount(Long post_id, int user_id, boolean isLiked) {
	    // 💡 user_id 기준으로 좋아요 누른 상태를 정확히 조회하도록 수정해야 함
	    Boolean currentLikedByMe = sliverPostMapper.checkIfUserLikedPost(post_id, user_id);

	    if (currentLikedByMe == null) currentLikedByMe = false;

	    // 👉 현재 상태와 바뀌는 상태가 다를 때만 count 조정
	    if (currentLikedByMe != isLiked) {
	        SliverPost post = sliverPostMapper.selectPostById(post_id);

	        if (post != null) {
	            int count = post.getPost_like_count();
	            post.setPost_like_count(isLiked ? count + 1 : count - 1);
	            sliverPostMapper.updatePostLikeCount(post_id, post.getPost_like_count());
	            post.setLiked_by_me(isLiked); // optional
	            return post;
	        }
	    }

	    return null; // 또는 throw exception 등
	}




	public List<SliverPost> selectAllPostsWithUserLike(int user_id) {
	    return sliverPostMapper.selectAllPostsWithUserLike(user_id);
	}


}
