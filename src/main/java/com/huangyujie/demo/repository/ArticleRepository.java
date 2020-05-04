package com.huangyujie.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huangyujie.demo.entity.Article;
import com.huangyujie.demo.entity.Title;
import com.huangyujie.demo.entity.User;
@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
	Article findByArticleID(int articleID);

	List<Article> findAllByTitle(Title findBytitleID);

	List<Article> findAllByUser(User user);

	
	

}
