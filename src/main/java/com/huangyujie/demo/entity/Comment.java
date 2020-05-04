package com.huangyujie.demo.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Comment {

	@Id
	@GeneratedValue
	private int commentID;
	
	
	private String commentContent;
	
	private LocalDateTime commentDatetime = LocalDateTime.now();
	
	@ManyToOne
	private User user;
	@ManyToOne
	private Article article;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getCommentID() {
		return commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public LocalDateTime getCommentDatetime() {
		return commentDatetime;
	}

	public void setCommentDatetime(LocalDateTime commentDatetime) {
		this.commentDatetime = commentDatetime;
	}


	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

}
