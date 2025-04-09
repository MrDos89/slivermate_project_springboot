package himedia.slivermate.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import himedia.slivermate.repository.vo.SliverLike;

@Mapper
public interface SliverLikeMapper {
	
//	<select id="insertLike" resultType="SliverLike">
	int insertLike(SliverLike like); 
	
//	<select id="deleteLike" resultType="SliverLike">
	int deleteLike(SliverLike like);
	
//	<select id="isLiked" resultType="SliverLike">
	int isLiked(SliverLike like);  
	
//	<select id="selectLikedPostIdsByUserId" resultType="SliverLike">
	List<Integer> selectLikedPostIdsByUserId(int userId);
}
