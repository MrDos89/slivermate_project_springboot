package himedia.slivermate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.slivermate.mappers.SliverUserGroupMapper;
import himedia.slivermate.repository.vo.SliverUserGroup;

@Service
public class SliverUserGroupService {
	@Autowired
	private SliverUserGroupMapper sliverUserGroupMapper;
	
	// 전체 유저 불러오기
	public List<SliverUserGroup> selectAllUserGroups() {
		List<SliverUserGroup> userGroups = sliverUserGroupMapper.selectAllUserGroups();
		
		return userGroups;
	}
	
	public SliverUserGroup insertUserGroup(SliverUserGroup userGroup) {
		sliverUserGroupMapper.insertUserGroup(userGroup);
		
		return userGroup;
	}
	
	public SliverUserGroup updateUserGroup(SliverUserGroup userGroup) {
		sliverUserGroupMapper.updateUserGroup(userGroup);
		
		return userGroup;
	}
}
