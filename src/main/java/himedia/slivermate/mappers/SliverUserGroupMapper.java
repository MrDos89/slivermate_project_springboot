package himedia.slivermate.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import himedia.slivermate.repository.vo.SliverUserGroup;

@Mapper
public interface SliverUserGroupMapper {
//	<select id="selectAllUserGroups" resultType="SliverUserGroup">
	List<SliverUserGroup> selectAllUserGroups();
}
