package himedia.slivermate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import himedia.slivermate.mappers.SliverNotificationMapper;
import himedia.slivermate.repository.vo.SliverNotification;

@RestController
@RequestMapping("/api/notification")
public class SliverNotificationController {
	@Autowired
	private SliverNotificationMapper sliverNotificationMapper;
	
	public List<SliverNotification> selectAllNoitifications() {
		List<SliverNotification> notifications = sliverNotificationMapper.selectAllNotifications();
		
		return notifications;
	}
	
	public List<SliverNotification> selectNotificationByUserId(Long user_id) {
		List<SliverNotification> notifications = sliverNotificationMapper.selectNotificationByUserId(user_id);
		
		return notifications;
	}
}
