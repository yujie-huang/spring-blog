package com.huangyujie.demo.service;

import java.util.List;
import java.util.Optional;

import org.aspectj.apache.bcel.generic.IINC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huangyujie.demo.entity.Article;
import com.huangyujie.demo.entity.Title;
import com.huangyujie.demo.entity.User;
import com.huangyujie.demo.repository.ArticleRepository;
import com.huangyujie.demo.repository.TitleRepository;
import com.huangyujie.demo.repository.UserRepository;

@Service
public class TitleService {
	@Autowired
	private TitleRepository titleRepository;
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private UserRepository userRepository;
	
	public Title addTitle(Title title) {
		return titleRepository.save(title);
		
	}
	public List<Title> findAll() {
		return titleRepository.findAll();
	}
	public void deleteTitleByID(int i) {
		titleRepository.deleteById((i));
		// TODO Auto-generated method stub
		
	}
	
	public List<Title> findAllbyUser(User user) {
		return titleRepository.findAllByUser(user);
	}
	public Title findBytitleID(int i) {
		// TODO Auto-generated method stub
		return titleRepository.findByTitleID(i);
	}
	public boolean isUseage(int i) {
		// TODO Auto-generated method stub
		List<Article> articles = articleRepository.findAllByTitle(findBytitleID(i));
		System.out.println(articles.size()+"wqwqwqwqwqwqwqw");
		return articles.size()<1?false:true;
		
	}
//	public boolean update(Title title) {
//		// TODO Auto-generated method stub
//		
//		
//		titleRepository.save(title);
//		
//	}
	
	public boolean update(Title title, String userName) {
		// TODO Auto-generated method stub
		User user=userRepository.findUserByUserName(userName);
		title.setUser(user);
		List<Title> titles = titleRepository.findAllByUser(user);
		
		//判断是否已存在
		for(int i=0;i<titles.size();i++) {
			if(titles.get(i).getTitleName().equals(title.getTitleName())) {
				return false;
			}
		}
		titleRepository.save(title);
		return true;
	}
	
	
	public boolean changeStatu(Title title, String userName) {
		// TODO Auto-generated method stub
		User user=userRepository.findUserByUserName(userName);
		title = findBytitleID(title.getTitleID());
		
		
		if(title.isStatu()) {
				title.setStatu(false) ;
		}else {
				title.setStatu(true);
		}
		titleRepository.save(title);
		
		return true;
	}
}

