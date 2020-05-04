package com.huangyujie.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huangyujie.demo.entity.Article;
import com.huangyujie.demo.entity.User;
import com.huangyujie.demo.repository.ArticleRepository;

@Service
public class ArticleService {
	@Autowired
	private ArticleRepository articleRepository;
	
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
	
}
