package himedia.slivermate.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import himedia.slivermate.repository.vo.SliverCategory;

@Mapper
public interface SliverCategoryMapper {
//	<select id="selectAllCategories" resultType="SliverCategory">
	List<SliverCategory> selectAllCategories();
}
