package com.huangyujie.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huangyujie.demo.entity.Article;
import com.huangyujie.demo.entity.Comment;
import com.huangyujie.demo.entity.User;
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
	
	public List<Comment> fingAllByArticle(Article article) {
		return commentRepository.findAllByArticle(article);
	}

	public boolean addComment(User user, Article article, String content) {
		// TODO Auto-generated method stub
		Comment comment = new Comment();
		comment.setArticle(article);
		comment.setUser(user);
		comment.setCommentContent(content);
		addComment(comment);
		
		return true;
	}

	public boolean reComment(User user, Article article, String content, int coid) {
		// TODO Auto-generated method stub
		Comment oldComment = commentRepository.findByCommentID(coid);
		System.out.println(oldComment.getCommentContent()+"1111111111111");
		Comment comment = new Comment();
		comment.setUser(user);
		comment.setArticle(article);
		comment.setComment(oldComment);
		comment.setCommentContent(content);
		addComment(comment);
		return true;
	}
}
