package himedia.slivermate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import himedia.slivermate.repository.vo.SliverAnnouncement;
import himedia.slivermate.service.SliverAnnouncementService;

@RestController
@RequestMapping("/api/announcement")
public class SliverAnnouncementController {

    @Autowired
    private SliverAnnouncementService sliverAnnouncementService;

    // GET : /api/announcement
    @GetMapping
    public ResponseEntity<List<SliverAnnouncement>> selectAllAnnouncements() {
        List<SliverAnnouncement> announcements = sliverAnnouncementService.selectAllAnnouncements();
        return ResponseEntity.ok(announcements);
    }

    @GetMapping("/u/{uid}")
    public ResponseEntity<List<SliverAnnouncement>> selectMyAnnouncements(@PathVariable Long uid) {
        List<SliverAnnouncement> announcements = sliverAnnouncementService.selectMyAnnouncements(uid);
        
        return ResponseEntity.ok(announcements);
    }
    
    // POST : /api/announcement
    @PostMapping
    public ResponseEntity<SliverAnnouncement> insertAnnouncement(@RequestBody SliverAnnouncement announcement) {
        // Service layer inserts the announcement and returns the saved object.
        SliverAnnouncement savedAnnouncement = sliverAnnouncementService.insertAnnouncement(announcement);
        return ResponseEntity.ok(savedAnnouncement);
    }
    
    // GET : /api/announcement/club/{club_id}
    @GetMapping("/club/{club_id}")
    public List<SliverAnnouncement> getAnnouncementsByClubId(@PathVariable("club_id") int clubId) {
        return sliverAnnouncementService.getAnnouncementsByClubId(clubId);
    }
    
    // POST : /api/announcement/{announce_id}/attend
    @PostMapping("/{announce_id}/attend")
    public ResponseEntity<?> attendAnnouncement(@PathVariable("announce_id") Long announceId) {
        // Retrieve the announcement by its ID.
        SliverAnnouncement announce = sliverAnnouncementService.selectAnnouncementById(announceId);
        if (announce == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("존재하지 않는 일정입니다.");
        }
        
        // Increase the attendance count.
        announce.setAttend_count(announce.getAttend_count() + 1);
        
        // Update the announcement's attendance count in the database.
        sliverAnnouncementService.updateAttendCount(announce);
        
        return ResponseEntity.ok().build();
    }
}
