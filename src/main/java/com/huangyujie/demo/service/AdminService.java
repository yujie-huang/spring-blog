package com.huangyujie.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huangyujie.demo.entity.Admin;
import com.huangyujie.demo.repository.AdminRepository;


@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;
	
	public Admin addAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	public List<Admin> findAll() {
		return adminRepository.findAll();
		
	}
}
