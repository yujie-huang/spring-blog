package com.huangyujie.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.huangyujie.demo.entity.User;
import com.huangyujie.demo.service.UserService;

@Controller
public class AdminController {
	@Autowired
	private UserService userService;
	
	
	
	@GetMapping("/findAllUser")
	public List<User> findAllUser(Model model,HttpSession session) {
		return userService.findAll();
	}
	
}
