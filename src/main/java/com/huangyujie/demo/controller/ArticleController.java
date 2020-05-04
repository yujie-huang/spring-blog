package com.huangyujie.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huangyujie.demo.entity.Article;
import com.huangyujie.demo.entity.Title;
import com.huangyujie.demo.service.ArticleService;
import com.huangyujie.demo.service.TitleService;
import com.huangyujie.demo.service.UserService;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private UserService userService;
	@Autowired
	private TitleService titleService;
	
	@GetMapping("/showArticle")
	public String showArticle(Model model,HttpSession session,int articleID) {
		Article article = articleService.findByArticleID(articleID);
		model.addAttribute("article",article);
		return "/article/article";
		
	}
	
	@GetMapping("/articleAdd")
	public String addArticle(Model model,HttpSession session) {
		String userName =(String) session.getAttribute("userName");
		if(userName!=null) {
			List<Title> titles = titleService.findAllbyUser(userService.findByUserName(userName));
			model.addAttribute("titles",titles);
			return "article/articleadd";
		}
		else {
			return "redirect:login";
		}
	}
	
	@PostMapping("/articleAdd")
	public String addArticle(Model model ,HttpSession session ,Article article,int titleID) {
		article.setUser(userService.findByUserName((String)session.getAttribute("userName")));
		article.setPublisDatetime( LocalDateTime.now());
		article.setTitle(titleService.findBytitleID(titleID));
		int articleID = articleService.addArticle(article).getArticleID();
		return "redirect:showArticle?articleID="+articleID;
	}
	
	@GetMapping("/articleUpdate")
	public String updateArticle(Model model ,HttpSession session,int articleID) {
		String userName =(String) session.getAttribute("userName");
		if(userName!=null) {
			List<Title> titles = titleService.findAllbyUser(userService.findByUserName(userName));
			model.addAttribute("titles",titles);
			Article article =articleService.findByArticleID(articleID);
			model.addAttribute("article",article);
			return "article/artupdate";
		}
		else {
			return "redirect:login";
		}
	}
	
	@PostMapping("/articleUpdate")
	public String updateArticle(Model model ,HttpSession session ,Article article,int titleID) {
			article.setUser(userService.findByUserName((String)session.getAttribute("userName")));
		 
			article.setTitle(titleService.findBytitleID(titleID));
		
			if(articleService.uppdateArticle(article)){
				return "redirect:showArticle?articleID="+article.getArticleID();
			}
			else {
				model.addAttribute("article",article);
				model.addAttribute("updateError","修改失败");
				return "article/artupdate";
			}
		
	}
	
	@GetMapping("/personalArticleManage")
	public String personalArticleManage(HttpSession session,Model model) {
		String userName =(String) session.getAttribute("userName");
		if(userName!=null) {
			List<Article> articles = articleService.findAllByUser(userService.findByUserName(userName));
			model.addAttribute("articles",articles);
			return "article/personalArticleManage";
		}
		else {
			return "redirect:login";
		}
	}
	
	@PostMapping("/artupdate")
	@ResponseBody
	public String personArtDel(HttpSession session,int articleID,String func) {
		if(func.equals("delete")) {
			articleService.deleteById(articleID);
			return "1";
		}
		return "0";
	}

}
