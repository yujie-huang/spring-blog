package com.huangyujie.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Title {

	@Id
	@GeneratedValue
	private int titleID;
	
	public int getTitleID() {
		return titleID;
	}

	private String titleName;
	
	private LocalDateTime titleDate;
	
	@ManyToOne
	private User user;
	
	@OneToMany
	private Set<Article> articles =  new HashSet<>();
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Set<Article> getArticles() {
		return articles;
	}


	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}


	public void setTitleID(int titleID) {
		this.titleID = titleID;
	}


	public String getTitleName() {
		return titleName;
	}


	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}


	public LocalDateTime getTitleDate() {
		return titleDate;
	}


	public void setTitleDate(LocalDateTime titleDate) {
		this.titleDate = titleDate;
	}



	
	
	public Title() {
		// TODO Auto-generated constructor stub
	}

}
