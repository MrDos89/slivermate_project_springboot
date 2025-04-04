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
}
