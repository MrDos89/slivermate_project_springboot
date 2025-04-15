package himedia.slivermate.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import himedia.slivermate.repository.vo.SliverAnnouncement;

@Mapper
public interface SliverAnnouncementMapper {
	List<SliverAnnouncement> selectAllAnnouncements();
	
	int insertAnnouncement(SliverAnnouncement announcement);
	
	List<SliverAnnouncement> selectAnnouncementsByClubId(int club_id);
	
    int updateAttendCount(SliverAnnouncement announcement);

    SliverAnnouncement selectAnnouncementById(Long announceId);
    
    int updateMemberList(@Param("announceId") Long announceId, @Param("memberList") String memberList);
}
