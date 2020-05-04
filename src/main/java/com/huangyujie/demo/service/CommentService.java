package com.huangyujie.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huangyujie.demo.entity.Comment;
import com.huangyujie.demo.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	
	public Comment addComment(Comment comment) {
		return commentRepository.save(comment);
	}
	
	public List<Comment> findAll() {
		return commentRepository.findAll();
		
	}
}
