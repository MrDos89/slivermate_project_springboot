package himedia.slivermate.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import himedia.slivermate.repository.vo.SliverComment;

@Mapper
public interface SliverCommentMapper {
//	<select id="selectAllComments" resultType="SliverComment">
	public List<SliverComment> selectAllComments();
	
	public List<SliverComment> selectMyComments(Long uid);

//	<select id="insertComment" resultType="SliverComment">
	int insertComment(SliverComment comment);

//	<select id="selectCommentsByPostId" resultType="SliverComment">
	List<SliverComment> selectCommentsByPostId(Long post_id);
}
