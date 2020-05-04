
package com.huangyujie.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;




@Entity
public class User {
	@Id
	@GeneratedValue
	private int userId;
	
	@Column(nullable = false, unique = true )
	private String userName;
	
	private String name;
	
	
	private String password;
	
	private String sex;
	
	
	private String birth ;
	
	
	private String phone ;
	
	@Email(message = "邮箱名不符合格式")
	private String email ;
	private String wechat ;
	private String information ;
	
	private LocalDateTime regis_date= LocalDateTime.now();
	private boolean status = true;
	
	@OneToMany
	private Set<Article> articles = new HashSet<>();
	@OneToMany
	private Set<Title> titles = new HashSet<>();
	@OneToMany
	private Set<Comment> comments = new HashSet<>();
	
	
	public Set<Article> getArticles() {
		return articles;
	}
	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}
	public Set<Title> getTitles() {
		return titles;
	}
	public void setTitles(Set<Title> titles) {
		this.titles = titles;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public LocalDateTime getRegis_date() {
		return regis_date;
	}
	public void setRegis_date(LocalDateTime regis_date) {
		this.regis_date = regis_date;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName( String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	

}
