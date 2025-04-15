package himedia.slivermate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

}
