package himedia.slivermate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import himedia.slivermate.repository.vo.SliverCategory;
import himedia.slivermate.service.SliverCategoryService;

@RestController
@RequestMapping("/api/category")
public class SliverCategoryController {
	@Autowired
	private SliverCategoryService sliverCategoryService;
	
//	GET : /api/category
	@GetMapping
	public ResponseEntity<List<SliverCategory>> selectAllCategories() {
		List<SliverCategory> categories = sliverCategoryService.selectAllCategories();
		return ResponseEntity.ok(categories);
	}
}
