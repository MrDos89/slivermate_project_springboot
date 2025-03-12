package himedia.slivermate.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import himedia.slivermate.repository.vo.SliverLesson;

@Mapper
public interface SliverLessonMapper {
//	<select id="selectAllLessons" resultType="SliverLesson">
	List<SliverLesson> selectAllLessons();
//	<select id="selectLessonsByCategoryId" resultType="SliverLesson">
	List<SliverLesson> selectLessonsByCategoryId(Integer category_id);
// 	<select id="selectLessonsBySubCategoryId" resultType="SliverLesson">
	List<SliverLesson> selectLessonsBySubCategoryId(Integer sub_category_id);
//	<select id="selectLessonByUserId" resultType="SliverLesson">	
	List<SliverLesson> selectLessonsByUserId(Long user_id);
//	<select id="selectRelatedLessons" resultType="SliverLesson">
	List<SliverLesson> selectRelatedLessons(SliverLesson lesson);
//	<select id="selectLessonById" resultType="SliverLesson">
	SliverLesson selectLessonById(Long id);
//	<insert id="insertLesson" parameterType="SliverLesson">
	int insertLesson(SliverLesson lesson);
//	<update id="updateLesson" parameterType="SliverLesson">
	int updateLesson(SliverLesson lesson);
////	<update id="updateLessonReportCnt" parameterType="SliverLesson">	
//	void updateLessonReportCnt(SliverLesson lesson);
//	<update id="hideLesson" parameterType="Long">
	void hideLesson(Long id);
//	<delete id="deleteLesson" parameterType="Long">
	void deleteLesson(Long id);
}
