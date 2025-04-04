package himedia.slivermate.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import himedia.slivermate.repository.vo.SliverUser;
import himedia.slivermate.repository.vo.SliverUserGroup;

@Mapper
public interface SliverUserGroupMapper {
//	<select id="selectAllUserGroups" resultType="SliverUserGroup">
	List<SliverUserGroup> selectAllUserGroups();
//	<update id="getUserGroupUsersById" parameterType="SliverUser">	
	List<SliverUser> getUserGroupUsersById(Long user_group_id);
//	<update id="loginByUserIdFromUserGroup" parameterType="SliverUser">	
	SliverUser loginByUserIdFromUserGroup(Long user_group_id, Long user_id);
//	<update id="insertUserGroup" parameterType="SliverUserGroup">
	SliverUserGroup insertUserGroup(SliverUserGroup userGroup);
//	<update id="updateUserGroup" parameterType="SliverUserGroup">	
	SliverUserGroup updateUserGroup(SliverUserGroup userGroup);
}