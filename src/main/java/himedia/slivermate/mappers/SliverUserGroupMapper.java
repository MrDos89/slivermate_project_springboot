package himedia.slivermate.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import himedia.slivermate.repository.vo.SliverUserGroup;

@Mapper
public interface SliverUserGroupMapper {
//	<select id="selectAllUserGroups" resultType="SliverUserGroup">
	List<SliverUserGroup> selectAllUserGroups();
//	<update id="insertUserGroup" parameterType="SliverUserGroup">
	SliverUserGroup insertUserGroup(SliverUserGroup userGroup);
//	<update id="updateUserGroup" parameterType="SliverUserGroup">	
	SliverUserGroup updateUserGroup(SliverUserGroup userGroup);
}
