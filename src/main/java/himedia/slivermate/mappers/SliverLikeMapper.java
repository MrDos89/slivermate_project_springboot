package himedia.slivermate.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import himedia.slivermate.repository.vo.SliverLike;


@Mapper
public interface SliverLikeMapper {
	
//	<select id="getLikeCount" resultType="SliverLike">
	int getLikeCount(int post_id);
	
//	<select id="selectLikedPostIdsByUserId" resultType="SliverLike">
	List<Integer> selectLikedPostIdsByUserId(int user_id);
	
//	<select id="insertLike" resultType="SliverLike">
	int insertLike(SliverLike like); 
	
//	<select id="updateLike" resultType="SliverLike">
	int updateLike(SliverLike like);
	
//	<select id="deleteLike" resultType="SliverLike">
	int deleteLike(SliverLike like);
	
//	<select id="isLiked" resultType="SliverLike" resultType="int">
	int isLiked(SliverLike like);  
	
//	<select id="exists" resultType="SliverLike" resultType="int">
	int exists(SliverLike like);  

}
