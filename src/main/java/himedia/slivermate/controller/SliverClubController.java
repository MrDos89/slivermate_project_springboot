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

import himedia.slivermate.repository.vo.SliverClub;
import himedia.slivermate.service.SliverClubService;

@RestController
@RequestMapping("/api/club")
public class SliverClubController {
	@Autowired
	private SliverClubService sliverClubService; 
	
//	GET : /api/club
	@GetMapping
	public ResponseEntity<List<SliverClub>> selectAllClubs() {
		List<SliverClub> clubs = sliverClubService.selectAllClubs();
		return ResponseEntity.ok(clubs);
	}

	// GET : /api/club/c/{category_id}
	@GetMapping("/c/{category_id}")
	public ResponseEntity<List<SliverClub>> selectClubsByCategoryId(@PathVariable Integer category_id) {
		List<SliverClub> clubs = sliverClubService.selectClubsByCategoryId(category_id);
		
		return ResponseEntity.ok(clubs);
	}

	// GET : /api/club/sc/{category_id}/{sub_category_id}
	@GetMapping("/sc/{category_id}/{sub_category_id}")
	public ResponseEntity<List<SliverClub>> selectClubsBySubCategoryId(@PathVariable Integer category_id, @PathVariable Integer sub_category_id) {
		List<SliverClub> clubs = sliverClubService.selectClubsBySubCategoryId(category_id, sub_category_id);
		
		return ResponseEntity.ok(clubs);
	}
	
//	GET : /api/club/{club_id}
	@GetMapping("/{club_id}")
	public ResponseEntity<SliverClub> selectClubById(@PathVariable Long club_id) {
		SliverClub club = sliverClubService.selectClubById(club_id);
		
		return ResponseEntity.ok(club);
	}
	
	@GetMapping("/{uid}/joined")
	public ResponseEntity<List<SliverClub>> selectJoinedClubsByUserId(@PathVariable Long uid) {
		List<SliverClub> clubs = sliverClubService.selectJoinedClubsByUserId(uid);
		
		return ResponseEntity.ok(clubs);
	}
	
	//GET : /api/club/{id}/related
	@GetMapping("/{club_id}/related")
	public ResponseEntity<List<SliverClub>> selectRelatedClubs(@PathVariable Long club_id) {
		SliverClub club = sliverClubService.selectClubById(club_id);
			
		List<SliverClub> relatedClubs = sliverClubService.selectRelatedClubs(club);
			
		return ResponseEntity.ok(relatedClubs);
	}

	//	POST : /api/club -> 새로운 클럽 항목 생성
	@PostMapping
	public ResponseEntity<SliverClub> insertClub(@RequestBody SliverClub club) {
		SliverClub savedClub = sliverClubService.insertClub(club);
		return ResponseEntity.ok(savedClub);	
		//	ResponseEntity.created로 하는 것이 의미상 더 나을 수도 있다.
	}
	
//	PUT : /api/club/{club_id} -> 기존 클럽 항목 전체 수정
	@PutMapping("/{club_id}")
	public ResponseEntity<SliverClub> updateClubPut(@RequestBody SliverClub club, @PathVariable Long club_id) {
		club.setClub_id(club_id);
		SliverClub updatedPost = sliverClubService.updateClub(club);
		return ResponseEntity.ok(updatedPost);
	}
	
//	PATCH : /api/club/{id} -> 기존 클럽 항목 일부 수정
	@PatchMapping("/{club_id}")
	public ResponseEntity<SliverClub> updateClubPatch(@RequestBody SliverClub club, @PathVariable Long club_id) {
		club.setClub_id(club_id);
		SliverClub updatedPost = sliverClubService.updateClub(club);
		return ResponseEntity.ok(updatedPost);
	}
	
	@PatchMapping("/{club_id}/reportCnt")
	public ResponseEntity<Void> updateClubReportCnt(@RequestBody SliverClub club, @PathVariable Long club_id) {
		club.setClub_id(club_id);
		
		sliverClubService.updateClubReportCnt(club);
		
		return ResponseEntity.ok().<Void>build();
	}
	
	@PatchMapping("/{club_id}/hide")
	//	Body에 실어 보낼 내용이 없음 -> Void
	public ResponseEntity<Void> hideClub(@PathVariable Long club_id) {
		sliverClubService.hideClub(club_id);
		return ResponseEntity.ok().<Void>build();
	}
	
	
//	DELETE : /api/club/{club_id} -> 기존 클럽 항목 삭제
	@DeleteMapping("/{club_id}")
	//	Body에 실어 보낼 내용이 없음 -> Void
	public ResponseEntity<Void> deleteClub(@PathVariable Long club_id) {
		sliverClubService.deleteClub(club_id);
		return ResponseEntity.ok().<Void>build();
	}
}
