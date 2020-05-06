package com.huangyujie.demo.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huangyujie.demo.entity.Title;
import com.huangyujie.demo.service.TitleService;
import com.huangyujie.demo.service.UserService;

@Controller
public class TitleController {
	
	@Autowired
	private TitleService titleService;
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/titleManage")
	public String titleManage(Model model ,HttpSession session) {
		String userName= (String) session.getAttribute("userName");
		List<Title> titles = titleService.findAllbyUser(userService.findByUserName(userName));
		model.addAttribute("titles",titles);
		return "title/titleManage";
	}
	
	@PostMapping("/titleupdate")
	@ResponseBody
	public String titleManage(HttpSession session,Title title,String func) {
		String f = "0";
		
		switch (func) {
		case "delete":
			if(titleService.isUseage(title.getTitleID())) {
				f="0";
			}
			else {
				titleService.deleteTitleByID(title.getTitleID());
				f="1";
			}
			break;
		case "update":
			if(titleService.update(title,(String)session.getAttribute("userName"))) {
				f="1";
			}
			else {
				f="0";
			}
			
			break;
		case "add":
			if(titleService.update(title,(String)session.getAttribute("userName"))) {
				f="1";
			}
			else {
				f="0";
			}
			
			break;
		case "change":
			if(titleService.changeStatu(title,(String)session.getAttribute("userName"))) {
				f="1";
			}
			else {
				f="0";
			}

		default:
			break;
		}
		
		
		return f;
		
	}
	

}
