package himedia.slivermate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.slivermate.mappers.SliverLessonMapper;
import himedia.slivermate.repository.vo.SliverLesson;

@Service
public class SliverLessonService {
	@Autowired
	private SliverLessonMapper sliverLessonMapper;
	
	public List<SliverLesson> selectAllLessons() {
		List<SliverLesson> lessons = sliverLessonMapper.selectAllLessons();
		
		return lessons;
	}
	
	public List<SliverLesson> selectLessonsByCategoryId(Integer category_id) {
		List<SliverLesson> lessons = sliverLessonMapper.selectLessonsByCategoryId(category_id);
		
		return lessons;
	}
	
	public List<SliverLesson> selectLessonsByUserId(Long user_id) {
		List<SliverLesson> lessons = sliverLessonMapper.selectLessonByUserId(user_id);
		
		return lessons;
	}

	public SliverLesson selectLessonById(Long id) {
		SliverLesson lesson = sliverLessonMapper.selectLessonById(id);
		
		return lesson;
	}
	
	public List<SliverLesson> selectRelatedLessons(SliverLesson lesson) {
		List<SliverLesson> lessons = sliverLessonMapper.selectRelatedLessons(lesson);
		
		return lessons;
	}
	
	public SliverLesson insertLesson(SliverLesson lesson) {
		sliverLessonMapper.insertLesson(lesson);
		
		Long id = lesson.getLesson_id();
		
		return sliverLessonMapper.selectLessonById(id);
	}
	
	public SliverLesson updateLesson(SliverLesson lesson) {
		sliverLessonMapper.updateLesson(lesson);
		
		return lesson;
	}
	
	public void updateLessonReportCnt(SliverLesson lesson) {
		sliverLessonMapper.updateLessonReportCnt(lesson);
	}
	
	public void hideLesson(Long id) {
		sliverLessonMapper.hideLesson(id);
	}
	
	public void deleteLesson(Long id) {
		sliverLessonMapper.deleteLesson(id);
	}
}
