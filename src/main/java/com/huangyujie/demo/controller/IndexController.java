package com.huangyujie.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.huangyujie.demo.entity.Article;
import com.huangyujie.demo.service.ArticleService;

@Controller
public class IndexController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/")
    public String index() {
    	return "redirect:index";
    }
    
    
    @GetMapping("/index")
    public String index(Model model,HttpSession session) {
        List<Article> articles = articleService.findAll();
        model.addAttribute("articles",articles);
        return "index";
    }
    
    @PostMapping("/search")
    public String search(String choose,String word,Model model) {
    	List<Article> articles =null ;
    	switch (choose) {
		case "headline":
			 articles=articleService.searchByheadline(word);
			break;
		case "title":
			articles=articleService.searchBytitle(word);
			break;
		case "userName":
			articles=articleService.searchByuserName(word);
			break;
		default:
			break;
		}
    	
    	model.addAttribute("articles",articles);
    	return "index";
    }
}
