package himedia.slivermate.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import himedia.slivermate.repository.vo.SliverNotification;

@Mapper
public interface SliverNotificationMapper {
//	<select id="selectAllNotifications" resultType="SliverNotification">
	List<SliverNotification> selectAllNotifications();
//	<select id="selectAllNotifications" resultType="SliverNotification">
	List<SliverNotification> selectNotificationByUserId(Long user_id);
}
