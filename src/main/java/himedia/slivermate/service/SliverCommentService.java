package himedia.slivermate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.slivermate.mappers.SliverCommentMapper;
import himedia.slivermate.repository.vo.SliverComment;

@Service
public class SliverCommentService {
	@Autowired
	private SliverCommentMapper sliverCommentMapper;
	
	public List<SliverComment> selectAllComments() {
		List<SliverComment> comments = sliverCommentMapper.selectAllComments();
		
		return comments;
	}
	
	 public void insertComment(SliverComment comment) {
	        sliverCommentMapper.insertComment(comment);
	    }
	 
	 public List<SliverComment> selectCommentsByPostId(Long post_id) {
		    return sliverCommentMapper.selectCommentsByPostId(post_id);
		}
}
