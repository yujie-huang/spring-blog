package com.huangyujie.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huangyujie.demo.entity.Article;
import com.huangyujie.demo.entity.Title;
import com.huangyujie.demo.entity.User;
import com.huangyujie.demo.repository.ArticleRepository;
import com.huangyujie.demo.repository.TitleRepository;
import com.huangyujie.demo.repository.UserRepository;

@Service
public class ArticleService {
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private TitleRepository titleRepository;
	@Autowired
	private UserRepository userRepository;
	
	public Article addArticle(Article article) {
		return articleRepository.save(article);
	}
	
	public List<Article> findAll() {
		return articleRepository.findAll();
		
	}

	public Article findByArticleID(int articleID) {
		// TODO Auto-generated method stub
		return articleRepository.findByArticleID(articleID);
	}

	public boolean uppdateArticle(Article article) {
		// TODO Auto-generated method stub
		
		articleRepository.save(article);
		return true;
	}

	public List<Article> findAllByUser(User user) {
		// TODO Auto-generated method stub
		return articleRepository.findAllByUser(user);
	}

	public void deleteById(int articleID) {
		// TODO Auto-generated method stub
		articleRepository.deleteById(articleID);
	}

	public List<Article> findAllByUserandTitle(User user, Title title) {
		// TODO Auto-generated method stub
		return articleRepository.findAllByUserAndTitle(user,title);
	}

	public List<Article> searchByheadline(String word) {
		// TODO Auto-generated method stub
		
		
		return articleRepository.findAllByArticleHeadlineContaining(word);
	}


	public List<Article> searchBytitle(String word) {
		// TODO Auto-generated method stub
		List<Title> titles = titleRepository.findAllByTitleNameContaining(word);
		List<Article> articles = new ArrayList<>() ;
		for(int i=0;titles.size()!=0&&i<titles.size();i++) {
			articles.addAll(findAllByTitle(titles.get(i)));
		}
		
		return articles;
	}

	public List<Article> findAllByTitle(Title title) {
		// TODO Auto-generated method stub
		return articleRepository.findAllByTitle(title);
	}


	public List<Article> searchByuserName(String word) {
		// TODO Auto-generated method stub
		List<User> users = userRepository.findAllByNameContaining(word);
		List<Article> articles = new ArrayList<>();
		for(int i=0;i<users.size();i++) {
			articles.addAll(findAllByUser(users.get(i)));
		}
		
		return articles;
	}
	
}
