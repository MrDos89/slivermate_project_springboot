package himedia.slivermate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.slivermate.mappers.SliverUserMapper;
import himedia.slivermate.repository.dto.SliverLoginData;
import himedia.slivermate.repository.vo.SliverUser;

@Service
public class SliverUserService {
	@Autowired
	private SliverUserMapper sliverUserMapper;
	
	// 전체 유저 불러오기
	public List<SliverUser> selectAllUsers() {
		List<SliverUser> users = sliverUserMapper.selectAllUsers();
		
		return users;
	}
	
	public SliverUser loginUser(SliverLoginData loginData) {
		SliverUser user = sliverUserMapper.loginUser(loginData.getUser_id(), loginData.getPassword());
		
		return user;
	}
	
	// 회원가입
	public SliverUser registerUser(SliverUser user) {
		sliverUserMapper.registerUser(user);
		
		Long uid = user.getUid();
		
		return sliverUserMapper.selectByUid(uid);
	}
	
	// 유저 정보 수정
	public SliverUser updateUser(SliverUser user) {
		sliverUserMapper.updateUser(user);
		
		return user;
	}
	
	// 유저 삭제
	public int deleteUser(Long uid) {
		return sliverUserMapper.deleteUser(uid);
	}
}
