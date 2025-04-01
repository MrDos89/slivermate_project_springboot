package himedia.slivermate.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import himedia.slivermate.repository.vo.SliverLesson;
import himedia.slivermate.repository.vo.SliverLessonGroup;

@Mapper
public interface SliverLessonGroupMapper {
//	<select id="selectAllLessonGroups" resultType="SliverLessonGroup">
	public List<SliverLessonGroup> selectAllLessonGroups();
//	<select id="selectLessonsByCategoryId" resultType="SliverLessonGroup">
	public List<SliverLessonGroup> selectLessonGroupsByCategoryId(Integer category_id);
//	<select id="selectLessonsBySubCategoryId" resultType="SliverLessonGroup">
	public List<SliverLessonGroup> selectLessonGroupsBySubCategoryId(Integer category_id, Integer sub_category_id);
//	<select id="selectLessonGroupsByUserId" resultType="SliverLessonGroup">
	public List<SliverLessonGroup> selectLessonGroupsByUserId(Long user_id);
//	<select id="selectLessonGroupById" resultType="SliverLessonGroup">
	public SliverLessonGroup selectLessonGroupById(Long lesson_group_id);
//	<insert id="insertLessonGroup" parameterType="SliverLessonGroup">
	SliverLessonGroup insertLessonGroup(SliverLessonGroup lessonGroup);
//	<update id="updateLessonGroup" parameterType="SliverLessonGroup">
	SliverLessonGroup updateLessonGroup(SliverLessonGroup lessonGroup);
//	<select id="hideLessonGroup" parameterType="lesson_group_id">
	public void hideLessonGroup(Long lesson_group_id);
//	<select id="deleteLessonGroup" parameterType="lesson_group_id">
	public void deleteLessonGroup(Long lesson_group_id);
}
