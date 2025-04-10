package himedia.slivermate.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import himedia.slivermate.repository.vo.SliverComment;

@Mapper
public interface SliverCommentMapper {
//	<select id="selectAllComments" resultType="SliverComment">
	public List<SliverComment> selectAllComments();

//	<select id="insertComment" resultType="SliverComment">
	int insertComment(SliverComment comment);

}
