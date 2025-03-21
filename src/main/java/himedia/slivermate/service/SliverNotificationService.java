package himedia.slivermate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.slivermate.mappers.SliverNotificationMapper;
import himedia.slivermate.repository.vo.SliverNotification;

@Service
public class SliverNotificationService {
	@Autowired
	private SliverNotificationMapper sliverNotificationMapper;
	
	public List<SliverNotification> selectAllNotifications() {
		List<SliverNotification> notifications = sliverNotificationMapper.selectAllNotifications();
		
		return notifications;
	}
	
	public List<SliverNotification> selectNotificationByUserId(Long user_id) {
		List<SliverNotification> notifications = sliverNotificationMapper.selectNotificationByUserId(user_id);
		
		return notifications;
	}
}
