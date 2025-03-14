package himedia.slivermate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import himedia.slivermate.repository.vo.SliverLesson;
import himedia.slivermate.service.SliverLessonService;

@RestController
@RequestMapping("/api/lesson")
public class SliverLessonController {
	@Autowired
	private SliverLessonService sliverLessonService;
	
//	GET : /api/lesson
	@GetMapping
	public ResponseEntity<List<SliverLesson>> getAllLessons() {
		List<SliverLesson> lessons = sliverLessonService.selectAllLessons();
		return ResponseEntity.ok(lessons);
	}

	// GET : /api/lesson/c/{category_id}
	@GetMapping("/c/{category_id}")
	public ResponseEntity<List<SliverLesson>> selectLessonsByCategoryId(@PathVariable Integer category_id) {
		List<SliverLesson> lessons = sliverLessonService.selectLessonsByCategoryId(category_id);
		
		return ResponseEntity.ok(lessons);
	}

	// GET : /api/lesson/sc/{category_id}/{sub_category_id}
	@GetMapping("/sc/{category_id}/{sub_category_id}")
	public ResponseEntity<List<SliverLesson>> selectLessonsBySubCategoryId(@PathVariable Integer category_id, @PathVariable Integer sub_category_id) {
		List<SliverLesson> lessons = sliverLessonService.selectLessonsBySubCategoryId(category_id, sub_category_id);
		
		return ResponseEntity.ok(lessons);
	}
	
	// GET : /api/lesson/u/{uid}
	@GetMapping("/u/{uid}")
	public ResponseEntity<List<SliverLesson>> selectLessonsByUserId(@PathVariable Long uid) {
		List<SliverLesson> lessons = sliverLessonService.selectLessonsByUserId(uid);
		
		return ResponseEntity.ok(lessons);
	}
	
//	GET : /api/lesson/{id}
	@GetMapping("/{id}")
	public ResponseEntity<SliverLesson> selectLessonById(@PathVariable Long id) {
		SliverLesson post = sliverLessonService.selectLessonById(id);
		
		return ResponseEntity.ok(post);
	}
	
	//GET : /api/lesson/{id}/related
	@GetMapping("/{id}/related")
	public ResponseEntity<List<SliverLesson>> selectRelatedLessons(@PathVariable Long pid) {
		SliverLesson lesson = sliverLessonService.selectLessonById(pid);
			
		List<SliverLesson> relatedLessons = sliverLessonService.selectRelatedLessons(lesson);
			
		return ResponseEntity.ok(relatedLessons);
	}

	//	POST : /api/lesson -> 새로운 쇼핑 항목 생성
	@PostMapping
	public ResponseEntity<SliverLesson> insertLesson(@RequestBody SliverLesson lesson) {
		SliverLesson savedLesson = sliverLessonService.insertLesson(lesson);
		return ResponseEntity.ok(savedLesson);	
		//	ResponseEntity.created로 하는 것이 의미상 더 나을 수도 있다.
	}

//	PATCH : /api/lesson/{id} -> 기존 쇼핑 항목 수정
	@PatchMapping("/{id}")
	public ResponseEntity<SliverLesson> updateLesson(@RequestBody SliverLesson lesson, @PathVariable Long id) {
		lesson.setLesson_id(id);
		SliverLesson updatedPost = sliverLessonService.updateLesson(lesson);
		return ResponseEntity.ok(updatedPost);
	}
	
//	@PatchMapping("/{id}/reportCnt")
//	public ResponseEntity<Void> updateLessonReportCnt(@RequestBody SliverLesson lesson, @PathVariable Long id) {
//		lesson.setLesson_id(id);
//		
//		sliverLessonService.updateLessonReportCnt(lesson);
//		
//		return ResponseEntity.ok().<Void>build();
//	}
	
	@PatchMapping("/{id}/hide")
	//	Body에 실어 보낼 내용이 없음 -> Void
	public ResponseEntity<Void> hideLesson(@PathVariable Long id) {
		sliverLessonService.hideLesson(id);
		return ResponseEntity.ok().<Void>build();
	}
	
////	PUT : /api/lesson/{pid} -> 기존 쇼핑 항목 수정
//	@PutMapping("/{pid}")
//	public ResponseEntity<SliverLesson> updateLesson(@RequestBody SliverLesson post, @PathVariable Long pid) {
//		post.setPid(pid);
//		SliverLesson updatedPost = sliverLessonService.updateLesson(post);
//		return ResponseEntity.ok(updatedPost);
//	}
	
//	DELETE : /api/lesson/{pid} -> 기존 쇼핑 항목 삭제
	@DeleteMapping("/{id}")
	//	Body에 실어 보낼 내용이 없음 -> Void
	public ResponseEntity<Void> deleteLesson(@PathVariable Long id) {
		sliverLessonService.deleteLesson(id);
		return ResponseEntity.ok().<Void>build();
	}
}
