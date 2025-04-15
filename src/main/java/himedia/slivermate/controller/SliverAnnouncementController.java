package himedia.slivermate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import himedia.slivermate.repository.vo.SliverAnnouncement;
import himedia.slivermate.service.SliverAnnouncementService;

@RestController
@RequestMapping("/api/announcement")
public class SliverAnnouncementController {
	@Autowired
	private SliverAnnouncementService sliverAnnouncementService;

//	GET : /api/announcement
	@GetMapping
	public ResponseEntity<List<SliverAnnouncement>> selectAllCategories() {
		List<SliverAnnouncement> announcements = sliverAnnouncementService.selectAllAnnouncements();
		return ResponseEntity.ok(announcements);
	}

// POST : /api/announcement
	@PostMapping
	public ResponseEntity<SliverAnnouncement> insertAnnouncement(@RequestBody SliverAnnouncement announcement) {
		// Service 레이어를 통해 DB에 INSERT 작업 후, 저장된 데이터를 반환합니다.
		SliverAnnouncement savedAnnouncement = sliverAnnouncementService.insertAnnouncement(announcement);
		return ResponseEntity.ok(savedAnnouncement);
	}
	
//	GET : /api/announcement
	@GetMapping("/club/{club_id}")
	public List<SliverAnnouncement> getByClubId(@PathVariable int club_id) {
	    return sliverAnnouncementService.getAnnouncementsByClubId(club_id);
	}
	
	
//	@PostMapping("/{id}/attend")
//	public ResponseEntity<?> attendAnnouncement(@PathVariable Long id) {
//	    SliverAnnouncement announce = sliverAnnouncementService.user_id(id);
//
//	    if (announce == null) {
//	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("존재하지 않는 일정입니다.");
//	    }
//
//	    // 참석자 수 1 증가
//	    announce.setAttendCount(announce.getAttend_count() + 1);
//
//	    // 업데이트 (insert와 update를 통합한 save 로직이 insertAnnouncement에 구현되어 있다면 그걸 사용)
//	    sliverAnnouncementService.updateAttendCount(announce);
//
//	    return ResponseEntity.ok().build();
//	}


}
