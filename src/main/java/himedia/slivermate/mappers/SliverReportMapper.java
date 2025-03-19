package himedia.slivermate.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import himedia.slivermate.repository.vo.SliverReport;

@Mapper
public interface SliverReportMapper {
//	<select id="selectAllReports" resultType="SliverReport">
	List<SliverReport> selectAllReports();
//	<insert id="insertReport" parameterType="SliverReport">
	int insertReport(SliverReport item);
//	<select id="selectById" parameterType="Long" resultType="SliverReport">
	SliverReport selectById(Long id);
//	<update id="updateReport" parameterType="SliverReport">
	int updateReport(SliverReport item);
//	<delete id="deleteReport" parameterType="Long">
	int deleteReport(Long id);
}
