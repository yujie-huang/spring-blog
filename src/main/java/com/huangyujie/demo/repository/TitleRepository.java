package com.huangyujie.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huangyujie.demo.entity.Title;
import com.huangyujie.demo.entity.User;
@Repository
public interface TitleRepository extends JpaRepository<Title, Integer> {

	public List<Title> findAllByUser(User user);
	Title findByTitleID(int i);
	public List<Title> findAllByTitleNameContaining(String word);
	

}
