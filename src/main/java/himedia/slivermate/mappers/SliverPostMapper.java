package himedia.slivermate.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import himedia.slivermate.repository.vo.SliverLesson;
import himedia.slivermate.repository.vo.SliverPost;

@Mapper
public interface SliverPostMapper {
//	<select id="selectAllPosts" resultType="SliverPosts">
	List<SliverPost> selectAllPosts();
//	<select id="selectPostById" resultType="SliverPost">	
	SliverPost selectPostById(Long post_id);
//	<insert id="insertNewPost" parameterType="SliverPost">
	int insertNewPost(SliverPost post);
}
