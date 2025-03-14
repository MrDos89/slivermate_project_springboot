package himedia.slivermate.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import himedia.slivermate.repository.vo.SliverUser;

@Mapper
public interface SliverUserMapper {
//	<select id="selectAllUsers" resultType="SliverUser">
	List<SliverUser> selectAllUsers();
//	<insert id="registerUser" parameterType="SliverUser">
	int registerUser(SliverUser user);
//	<select id="loginUser" resultType="SliverUser">
	SliverUser loginUser(String user_id, String password);
//	<select id="selectByUid" parameterType="Long" resultType="SliverUser">
	SliverUser selectByUid(Long uid);
//	<update id="updateUser" parameterType="SliverUser">
	int updateUser(SliverUser user);
//	<delete id="deleteUser" parameterType="Long">
	int deleteUser(Long uid);
}
