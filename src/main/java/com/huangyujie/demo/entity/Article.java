package com.huangyujie.demo.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.SafeHtml;
@Entity
public class Article {

	@Id
	@GeneratedValue
	private int articleID;
	
	public int getArticleID() {
		return articleID;
	}

	@NotBlank(message = "标题不能为空")
	private String articleHeadline;
	
	 @Column(length = 50000)
	private String content;
	
	
	private LocalDateTime publisDatetime = LocalDateTime.now();
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Title title;
	
	@OneToMany
	private Set<Comment> comments = new HashSet<>();

	

	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public Title getTitle() {
		return title;
	}




	public void setTitle(Title title) {
		this.title = title;
	}




	public Set<Comment> getComments() {
		return comments;
	}




	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}




	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}




	public String getArticleHeadline() {
		return articleHeadline;
	}




	public void setArticleHeadline(String articleHeadline) {
		this.articleHeadline = articleHeadline;
	}




	public String getContent() {
		return content;
	}




	public void setContent(String content) {
		this.content = content;
	}




	public LocalDateTime getPublisDatetime() {
		return publisDatetime;
	}




	public void setPublisDatetime(LocalDateTime publisDatetime) {
		this.publisDatetime = publisDatetime;
	}




	
	
	
	public Article() {
		// TODO Auto-generated constructor stub
	}

}
