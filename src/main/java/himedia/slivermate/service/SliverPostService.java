package himedia.slivermate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.slivermate.mappers.SliverPostMapper;
import himedia.slivermate.repository.vo.SliverPost;

@Service
public class SliverPostService {
	@Autowired
	private SliverPostMapper sliverPostMapper;
	
	
	public List<SliverPost> selectAllPosts() {
		List<SliverPost> posts = sliverPostMapper.selectAllPosts();
		
		return posts;
	}
}
