package himedia.slivermate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.slivermate.mappers.SliverCommentMapper;
import himedia.slivermate.mappers.SliverPostMapper;
import himedia.slivermate.repository.vo.SliverComment;

@Service
public class SliverCommentService {
	@Autowired
	private SliverCommentMapper sliverCommentMapper;

	@Autowired
	private SliverPostMapper sliverPostMapper; // 댓글 수 증가를 위해 추가

	public List<SliverComment> selectAllComments() {
		return sliverCommentMapper.selectAllComments();
	}
	
	public List<SliverComment> selectMyComments(Long uid) {
		return sliverCommentMapper.selectMyComments(uid);
	}

	public int insertComment(SliverComment comment) {
		int inserted = sliverCommentMapper.insertComment(comment);
		if (inserted > 0) {
			sliverPostMapper.incrementCommentCount(comment.getPost_id());
		}
		return inserted;
	}

	public List<SliverComment> selectCommentsByPostId(Long post_id) {
		return sliverCommentMapper.selectCommentsByPostId(post_id);
	}
}
