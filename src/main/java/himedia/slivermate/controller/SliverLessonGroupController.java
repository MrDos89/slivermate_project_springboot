package himedia.slivermate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import himedia.slivermate.repository.vo.SliverLessonGroup;
import himedia.slivermate.service.SliverLessonGroupService;

@RestController
@RequestMapping("/api/lessonGroup")
public class SliverLessonGroupController {
	@Autowired
	private SliverLessonGroupService sliverLessonGroupService;
	
//	GET : /api/lesson
	@GetMapping
	public ResponseEntity<List<SliverLessonGroup>> getAllLessonGroups() {
		List<SliverLessonGroup> lessons = sliverLessonGroupService.selectAllLessonGroups();
		return ResponseEntity.ok(lessons);
	}

	// GET : /api/lesson/c/{category_id}
	@GetMapping("/c/{category_id}")
	public ResponseEntity<List<SliverLessonGroup>> selectLessonGroupsByCategoryId(@PathVariable Integer category_id) {
		List<SliverLessonGroup> lessons = sliverLessonGroupService.selectLessonGroupsByCategoryId(category_id);
		
		return ResponseEntity.ok(lessons);
	}

	// GET : /api/lesson/sc/{category_id}/{sub_category_id}
	@GetMapping("/sc/{category_id}/{sub_category_id}")
	public ResponseEntity<List<SliverLessonGroup>> selectLessonGroupsBySubCategoryId(@PathVariable Integer category_id, @PathVariable Integer sub_category_id) {
		List<SliverLessonGroup> lessons = sliverLessonGroupService.selectLessonGroupsBySubCategoryId(category_id, sub_category_id);
		
		return ResponseEntity.ok(lessons);
	}
	
	// GET : /api/lesson/u/{uid}
	@GetMapping("/u/{uid}")
	public ResponseEntity<List<SliverLessonGroup>> selectLessonGroupsByUserId(@PathVariable Long uid) {
		List<SliverLessonGroup> lessons = sliverLessonGroupService.selectLessonGroupsByUserId(uid);
		
		return ResponseEntity.ok(lessons);
	}
	
//	GET : /api/lesson/{id}
	@GetMapping("/{id}")
	public ResponseEntity<SliverLessonGroup> selectLessonGroupById(@PathVariable Long id) {
		SliverLessonGroup post = sliverLessonGroupService.selectLessonGroupById(id);
		
		return ResponseEntity.ok(post);
	}

	//	POST : /api/lesson -> 새로운 쇼핑 항목 생성
	@PostMapping
	public ResponseEntity<SliverLessonGroup> insertLessonGroup(@RequestBody SliverLessonGroup lesson) {
		SliverLessonGroup savedLessonGroup = sliverLessonGroupService.insertLessonGroup(lesson);
		return ResponseEntity.ok(savedLessonGroup);	
		//	ResponseEntity.created로 하는 것이 의미상 더 나을 수도 있다.
	}

//	PATCH : /api/lesson/{id} -> 기존 쇼핑 항목 수정
	@PatchMapping("/{id}")
	public ResponseEntity<SliverLessonGroup> updateLessonGroup(@RequestBody SliverLessonGroup lesson, @PathVariable Long id) {
		lesson.setLesson_group_id(id);
		SliverLessonGroup updatedLessonGroup = sliverLessonGroupService.updateLessonGroup(lesson);
		return ResponseEntity.ok(updatedLessonGroup);
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
	public ResponseEntity<Void> hideLessonGroup(@PathVariable Long lesson_group_id) {
		sliverLessonGroupService.hideLessonGroup(lesson_group_id);
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
	public ResponseEntity<Void> deleteLessonGroup(@PathVariable Long lesson_group_id) {
		sliverLessonGroupService.deleteLessonGroup(lesson_group_id);
		return ResponseEntity.ok().<Void>build();
	}
}
