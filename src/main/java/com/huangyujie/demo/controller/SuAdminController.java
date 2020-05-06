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
import com.huangyujie.demo.service.AdminService;

@Controller
public class SuAdminController {
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/adminmanage")
	public String adminManage(HttpSession session,Model model) {
		if(session.getAttribute("suadmin")!=null) {
			List<Admin> admins = adminService.findAll();
			
			model.addAttribute("admins",admins);
			return "admin/adminmanage";
		}
		else {
			return "redirect:login";  
		}
	}
	
	@PostMapping("/adminmanage")
	@ResponseBody
	public String adminManage(String func,String userName,String newpassword) throws NoSuchAlgorithmException, InvalidKeySpecException {
		String f="0";
		switch (func) {
		case "change":
			if(adminService.changeStatu(userName)) {
				f="1";
			}else {
				f="0";
			}
			break;
		case "repwd":
			if(adminService.repwd(userName,newpassword)) {
				f="1";
			}else {
				f="0";
			}
			break;
		case "add":
			if(adminService.addU(userName,newpassword)) {
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
}
