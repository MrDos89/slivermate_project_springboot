package himedia.slivermate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.slivermate.mappers.SliverAnnouncementMapper;
import himedia.slivermate.repository.vo.SliverAnnouncement;

@Service
public class SliverAnnouncementService {
	@Autowired
	private SliverAnnouncementMapper sliverAnnouncementMapper;
	
	public List<SliverAnnouncement> selectAllAnnouncements() {
		List<SliverAnnouncement> announcements = sliverAnnouncementMapper.selectAllAnnouncements();
		
		return announcements;
	}
	
	  public SliverAnnouncement insertAnnouncement(SliverAnnouncement announcement) {
		    int result = sliverAnnouncementMapper.insertAnnouncement(announcement);
		    if (result > 0) {
		      return announcement;
		    } else {
		      throw new RuntimeException("Announcement 삽입에 실패했습니다.");
		    }
		  }
	  
	  public List<SliverAnnouncement> getAnnouncementsByClubId(int club_id) {
		    return sliverAnnouncementMapper.selectAnnouncementsByClubId(club_id);
		}
}
