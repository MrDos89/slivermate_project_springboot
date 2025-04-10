package himedia.slivermate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.slivermate.mappers.SliverClubMapper;
import himedia.slivermate.repository.vo.SliverClub;

@Service
public class SliverClubService {
	@Autowired
	private SliverClubMapper sliverClubMapper;
	
	public List<SliverClub> selectAllClubs() {
		List<SliverClub> clubs = sliverClubMapper.selectAllClubs();
		
		return clubs;
	}
	
	public List<SliverClub> selectClubsByCategoryId(Integer category_id) {
		List<SliverClub> clubs = sliverClubMapper.selectClubsByCategoryId(category_id);
		
		return clubs;
	}

	public List<SliverClub> selectClubsBySubCategoryId(Integer category_id, Integer sub_category_id) {
		List<SliverClub> clubs = sliverClubMapper.selectClubsBySubCategoryId(category_id, sub_category_id);
		
		return clubs;
	}
	
	public SliverClub selectClubById(Long id) {
		SliverClub club = sliverClubMapper.selectClubById(id);
		
		return club;
	}
	
	public List<SliverClub> selectJoinedClubsByUserId(Long user_id) {
		List<SliverClub> clubs = sliverClubMapper.selectJoinedClubsByUserId(user_id);
		
		return clubs;
	}
	
	public List<SliverClub> selectRelatedClubs(SliverClub club) {
		List<SliverClub> clubs = sliverClubMapper.selectRelatedClubs(club);
		
		return clubs;
	}
	
	public SliverClub insertClub(SliverClub club) {
		sliverClubMapper.insertClub(club);
		
		Long id = club.getClub_id();
		
		return sliverClubMapper.selectClubById(id);
	}
	
	public SliverClub updateClub(SliverClub club) {
		sliverClubMapper.updateClub(club);
		
		return club;
	}
	
	public void updateClubReportCnt(SliverClub club) {
		sliverClubMapper.updateClubReportCnt(club);
	}
	
	public void hideClub(Long id) {
		sliverClubMapper.hideClub(id);
	}
	
	public void deleteClub(Long id) {
		sliverClubMapper.deleteClub(id);
	}
}
