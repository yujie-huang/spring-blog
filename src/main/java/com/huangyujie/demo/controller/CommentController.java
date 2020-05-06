package com.huangyujie.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huangyujie.demo.service.ArticleService;
import com.huangyujie.demo.service.CommentService;
import com.huangyujie.demo.service.UserService;

@Controller
public class CommentController {
	@Autowired
	CommentService commentService;
	@Autowired
	ArticleService articleService;
	@Autowired
	UserService userService;
	
	@PostMapping("/addcomment")
	@ResponseBody
	public String addcomment(HttpSession session,int articleID,String content) {
		if(commentService.addComment(userService.findByUserName((String)session.getAttribute("userName")),articleService.findByArticleID(articleID),content)){
			return "1";
		}else {
			return "0";
		}
	}
	
	@PostMapping("/recomment")
	@ResponseBody
	public String recomment(HttpSession session,int articleID,String content,int coid) {
		if(commentService.reComment(userService.findByUserName((String)session.getAttribute("userName")),articleService.findByArticleID(articleID),content,coid)){
			return "1";
		}else {
			return "0";
		}
	}
}
