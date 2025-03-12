package himedia.slivermate.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import himedia.slivermate.repository.vo.SliverPurchase;

@Mapper
public interface SliverPurchaseMapper {
//	<select id="selectAllUsers" resultType="SliverPurchase">
	List<SliverPurchase> selectAllPurchases();
//	<insert id="registerUser" parameterType="SliverPurchase">
	int insertPurchase(SliverPurchase purchase);
//	<select id="loginUser" parameterType="Long" resultType="SliverPurchase">
	SliverPurchase selectById(Long id);
//	<select id="selectByUid" parameterType="Long" resultType="SliverPurchase">
	List<SliverPurchase> selectByUid(Long uid);
//	<update id="updateUser" parameterType="SliverPurchase">
	int updatePurchase(SliverPurchase purchase);
//	<delete id="deleteUser" parameterType="Long">
	int deletePurchase(Long uid);
}
