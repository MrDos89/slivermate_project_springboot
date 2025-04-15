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
//	<select id="selectPostByUid" resultType="SliverPost">		
	List<SliverPost> selectPostByUid(Long uid);
//	<insert id="insertNewPost" parameterType="SliverPost">
	int insertNewPost(SliverPost post);
	
//	<select id="updatePostLikeCount" resultType="SliverPost">
	int updatePostLikeCount(Long post_id, Integer post_like_count);
	
	List<SliverPost> selectAllPostsWithUserLike(@Param("user_id") int user_id);
	
	Boolean checkIfUserLikedPost(@Param("post_id") Long post_id, @Param("user_id") int user_id);
	
	int incrementLikeCount(@Param("post_id") Long post_id);
	
	int decrementLikeCount(@Param("post_id") Long post_id);
	
	int incrementCommentCount(@Param("post_id") Long postId);
}
