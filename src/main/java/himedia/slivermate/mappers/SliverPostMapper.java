package himedia.slivermate.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import himedia.slivermate.repository.vo.SliverLesson;
import himedia.slivermate.repository.vo.SliverPost;

@Mapper
public interface SliverPostMapper {
//	<select id="selectAllPosts" resultType="SliverPosts">
	List<SliverPost> selectAllPosts();
	
//	<insert id="insertNewPost" parameterType="SliverPost">
	int insertNewPost(SliverPost post);
}
