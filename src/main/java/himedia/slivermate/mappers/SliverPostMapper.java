package himedia.slivermate.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import himedia.slivermate.repository.vo.SliverPost;

@Mapper
public interface SliverPostMapper {
//	<select id="selectAllPosts" resultType="SliverPosts">
	List<SliverPost> selectAllPosts();
//	<select id="selectPostById" resultType="SliverPost">	
	SliverPost selectPostById(Long post_id);
//	<insert id="insertNewPost" parameterType="SliverPost">
	int insertNewPost(SliverPost post);
	
//	<select id="updatePostLikeCount" resultType="SliverPost">
	void updatePostLikeCount(Long post_id, Integer post_like_count);
	
	List<SliverPost> selectAllPostsWithUserLike(@Param("user_id") int user_id);
	
	Boolean checkIfUserLikedPost(@Param("post_id") Long post_id, @Param("user_id") int user_id);
	
	void incrementLikeCount(@Param("post_id") Long post_id);
	void decrementLikeCount(@Param("post_id") Long post_id);
	
	void incrementCommentCount(@Param("post_id") Long postId);
}
