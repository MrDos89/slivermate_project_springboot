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
		    // 매퍼에 insertAnnouncement()를 호출하여 DB에 데이터를 삽입
		    // 보통 insert 후 영향 받은 행의 개수를 리턴하므로, 성공 여부를 판단할 수 있습니다.
		    int result = sliverAnnouncementMapper.insertAnnouncement(announcement);
		    if (result > 0) {
		      // 성공적으로 삽입된 경우, announcement 객체 (혹은 필요한 경우 최신 데이터를 조회해서 반환) 반환
		      return announcement;
		    } else {
		      // 삽입에 실패한 경우 예외를 던지거나 null을 반환하도록 할 수 있습니다.
		      throw new RuntimeException("Announcement 삽입에 실패했습니다.");
		    }
		  }
}
