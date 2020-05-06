package com.huangyujie.demo.controller;



import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.huangyujie.demo.entity.Article;
import com.huangyujie.demo.entity.User;
import com.huangyujie.demo.service.ArticleService;
import com.huangyujie.demo.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ArticleService articleService;
	
	
	@GetMapping("/login")
	public String login() {
		return "loginRegister/login";
	}
	
	@PostMapping("/login")
	public String login(String userName,String password,Model model,HttpSession session) throws NoSuchAlgorithmException, InvalidKeySpecException {
		if(userService.login(userName,password)) {
			session.setAttribute("userName", userName);
			return "redirect:index";
		}
		else {
			model.addAttribute("err","登录失败！请检查账户或密码");
			model.addAttribute("userName",userName);
			return "loginRegister/login";
		}
	}
	
//	@GetMapping
//	public String logout(HttpSession session) {
//		session.removeAttribute("userName");
//		return "redirect:index";
//		
//	}
	
	
	@GetMapping("/register")
	public String register(User user) {
		return "loginRegister/register";
	}
	
	@PostMapping("/register")
	public String register(@Valid User user, BindingResult bindingResult,Model model) throws NoSuchAlgorithmException, InvalidKeySpecException {
		if(bindingResult.hasErrors()||userService.isExist(user.getUserName())) {
			if(userService.isExist(user.getUserName())) 
				model.addAttribute("errUserName","账号已存在");
			model.addAttribute("user",user);
			return "loginRegister/register";
		}
	
		userService.addUser(user);
		return "redirect:login";
	}
	
	@GetMapping("/userinfo")
	public String userInfo(HttpSession session,Model model) {
		String userName=(String)session.getAttribute("userName");
		if(userName!=null) {
			model.addAttribute("user",userService.findByUserName(userName));
			return "user/userinfo";
		}
		else {
			return "redirect:login";
		}
	}
	
	@GetMapping("/infomodify")
	public String infoModify(HttpSession session,Model model) {
		String userName=(String)session.getAttribute("userName");
		if(userName!=null) {
			model.addAttribute("user",userService.findByUserName(userName));
			return "user/infomodify";
		}
		else {
			return "redirect:login";
		}
	}
	
	@PostMapping("/infomodify")
	public String infoModify(HttpSession session,Model model,@Valid User user,BindingResult bindingResult) {
		String userName=(String)session.getAttribute("userName");
		if(userName!=null) {
			int userId = userService.findByUserName(userName).getUserId();
			user.setUserId(userId);
			user.setPassword(userService.findByUserName(userName).getPassword());
			model.addAttribute("user",user);
			if(bindingResult.hasErrors()) {
				return "user/infomodify";
			}
			else {
				userService.updateUser(user);
				return "redirect:userinfo";
			}
			
		}
		else {
			return "redirect:login";
		}
	}
	
	
	@GetMapping("/repassword")
	public String rePassword(HttpSession session) {
		String userName=(String)session.getAttribute("userName");
		if(userName!=null) {
			return "user/Repassword";
		}
		else {
			return "redirect:login";
		}
	}
	
	@PostMapping("/repassword")
	public String rePassword(HttpSession session,String password,String newpassword,String renewpassword,Model model) throws NoSuchAlgorithmException, InvalidKeySpecException {
		String userName=(String)session.getAttribute("userName");
		if(userName!=null) {
			User user = userService.findByUserName(userName);
			if (userService.login(userName, password)) {
				if(newpassword.equals(renewpassword)) {
					userService.rePassword(user,newpassword);
				}else {
					model.addAttribute("error","两次密码不一致");
					return "user/Repassword";
				}	
			}else {
				model.addAttribute("error","密码错误！！！");
				return "user/Repassword";
			}
			
		}
			session.invalidate();
			return "redirect:login";
		
	}
	
	@GetMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:index";
	}
	
	@GetMapping("/getuserbyid")
	public String getUserArticleByID(int ID,Model model) {
		User user = userService.findByID(ID);
		List<Article> articles = articleService.findAllByUser(user);
		model.addAttribute("user",user);
		model.addAttribute("articles",articles);
		return "user/user";
	}
	
	
}
