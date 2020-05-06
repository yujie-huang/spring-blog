package com.huangyujie.demo.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huangyujie.demo.entity.Admin;
import com.huangyujie.demo.entity.User;
import com.huangyujie.demo.service.AdminService;
import com.huangyujie.demo.service.SuAdminService;
import com.huangyujie.demo.service.UserService;

@Controller
public class AdminController {
	@Autowired
	private UserService userService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private SuAdminService suAdminService;
	
	
	

	
	@GetMapping("/admin")
	public String admin(HttpSession session) {
		if(session.getAttribute("admin")==null&&session.getAttribute("suadmin")==null)
			return "redirect:adminlogin";
		return "admin/admin";
	}
	
	@GetMapping("/adminlogin")
	public String adminLogin() {
		return "admin/adminlogin";
	}
	
	@PostMapping("/adminlogin")
	public String adminLogin(HttpSession session,String u,String p,Model model,String role) throws NoSuchAlgorithmException, InvalidKeySpecException {
		if(role.equals("normal")) {
			if(adminService.loginCheck(u,p)) {
//				session.removeAttribute("userName");
				session.setAttribute("admin", u);
				return "redirect:admin";
			}
			else {
				model.addAttribute("u",u);
				return "admin/adminlogin";
			}
			
		}else{
			if(suAdminService.loginCheck(u,p)) {
//				session.removeAttribute("userName");
				session.setAttribute("suadmin", u);
				return "redirect:admin";
			}
			else {
				model.addAttribute("u",u);
				return "admin/adminlogin";
			}
		}
		
	}
	
	@GetMapping("/usermanage")
	public String userManage(HttpSession session,Model model) {
		if(session.getAttribute("admin")!=null||session.getAttribute("suadmin")!=null) {
			List<User> users = userService.findAll();
			System.out.println(users.size());
			model.addAttribute("users",users);
			return "admin/usermanage";
		}
		else {
			return "redirect:login";  
		}
	}
	
	@PostMapping("/usermanage")
	@ResponseBody
	public String userManage(String func,String userName,String newpassword) throws NoSuchAlgorithmException, InvalidKeySpecException {
		String f="0";
		switch (func) {
		case "change":
			if(userService.changeStatu(userName)) {
				f="1";
			}else {
				f="0";
			}
			break;
		case "repwd":
			if(userService.repwd(userName,newpassword)) {
				f="1";
			}else {
				f="0";
			}
			break;
		case "add":
			if(userService.addU(userName,newpassword)) {
				f="1";
			}else {
				f="0";
			}
			break;

		default:
			break;
		
		}
		return f;
	}
	
	
	
	@GetMapping("/adminLogout")
	public String adminLogout(HttpSession session) {
		if(session.getAttribute("admin")!=null||session.getAttribute("suadmin")!=null) {
			session.invalidate();
		}
		return "redirect:adminlogin";
	}
	
	
}
