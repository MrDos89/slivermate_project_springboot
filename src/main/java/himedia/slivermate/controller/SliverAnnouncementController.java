package himedia.slivermate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
