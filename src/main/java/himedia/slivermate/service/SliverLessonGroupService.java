package himedia.slivermate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.slivermate.mappers.SliverLessonGroupMapper;
import himedia.slivermate.repository.vo.SliverLesson;
import himedia.slivermate.repository.vo.SliverLessonGroup;

@Service
public class SliverLessonGroupService {
	@Autowired
	private SliverLessonGroupMapper sliverLessonGroupMapper;
	
	public List<SliverLessonGroup> selectAllLessonGroups() {
		List<SliverLessonGroup> lessonGroups = sliverLessonGroupMapper.selectAllLessonGroups();
		
		return lessonGroups;
	}
	
	public List<SliverLessonGroup> selectLessonGroupsByCategoryId(Integer category_id) {
		List<SliverLessonGroup> lessonGroups = sliverLessonGroupMapper.selectLessonGroupsByCategoryId(category_id);
		
		return lessonGroups;
	}

	public List<SliverLessonGroup> selectLessonGroupsBySubCategoryId(Integer category_id, Integer sub_category_id) {
		List<SliverLessonGroup> lessonGroups = sliverLessonGroupMapper.selectLessonGroupsBySubCategoryId(category_id, sub_category_id);
		
		return lessonGroups;
	}
	
	public List<SliverLessonGroup> selectLessonGroupsByUserId(Long user_id) {
		List<SliverLessonGroup> lessonGroups = sliverLessonGroupMapper.selectLessonGroupsByUserId(user_id);
		
		return lessonGroups;
	}
	
	public SliverLessonGroup selectLessonGroupById(Long lesson_group_id) {
		SliverLessonGroup lessonGroup = sliverLessonGroupMapper.selectLessonGroupById(lesson_group_id);
		
		return lessonGroup;
	}
	
	public SliverLessonGroup insertLessonGroup(SliverLessonGroup lessonGroup) {
		SliverLessonGroup insertedLessonGroup = sliverLessonGroupMapper.insertLessonGroup(lessonGroup);
		
		return insertedLessonGroup;
	}
	
	public SliverLessonGroup updateLessonGroup(SliverLessonGroup lessonGroup) {
		SliverLessonGroup updatedLessonGroup = sliverLessonGroupMapper.updateLessonGroup(lessonGroup);
		
		return updatedLessonGroup;
	}
	
	public void hideLessonGroup(Long lesson_group_id) {
		sliverLessonGroupMapper.hideLessonGroup(lesson_group_id);
	}
	
	public void deleteLessonGroup(Long lesson_group_id) {
		sliverLessonGroupMapper.deleteLessonGroup(lesson_group_id);
	}
}
