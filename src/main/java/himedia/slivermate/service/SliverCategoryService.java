package himedia.slivermate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.slivermate.mappers.SliverCategoryMapper;
import himedia.slivermate.repository.vo.SliverCategory;

@Service
public class SliverCategoryService {
	@Autowired
	private SliverCategoryMapper sliverCategoryMapper;
	
	public List<SliverCategory> selectAllCategories() {
		List<SliverCategory> categories = sliverCategoryMapper.selectAllCategories();
		
		return categories;
	}
}
