package himedia.slivermate.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import himedia.slivermate.repository.vo.SliverClub;

@Mapper
public interface SliverClubMapper {
//	<select id="selectAllClubs" resultType="SliverClub">
	List<SliverClub> selectAllClubs();
//	<select id="selectClubsByCategoryId" resultType="SliverClub">
	List<SliverClub> selectClubsByCategoryId(Integer category_id);
// 	<select id="selectClubsBySubCategoryId" resultType="SliverClub">
	List<SliverClub> selectClubsBySubCategoryId(Integer category_id, Integer sub_category_id);
//	<select id="selectRelatedClubs" resultType="SliverClub">
	List<SliverClub> selectRelatedClubs(SliverClub club);
//	<select id="selectClubsByClubId" resultType="SliverClub">
	SliverClub selectClubById(Long id);
//	<insert id="insertClub" parameterType="SliverClub">
	int insertClub(SliverClub club);
//	<update id="updateClub" parameterType="SliverClub">
	int updateClub(SliverClub club);
////	<update id="updateClubReportCnt" parameterType="SliverClub">	
	void updateClubReportCnt(SliverClub club);
//	<update id="hideClub" parameterType="Long">
	void hideClub(Long id);
//	<delete id="deleteClub" parameterType="Long">
	void deleteClub(Long id);
}
