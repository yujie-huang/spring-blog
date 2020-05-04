package com.huangyujie.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huangyujie.demo.entity.Article;
import com.huangyujie.demo.entity.Comment;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
	List<Comment> findByArticle(Article article);

}
