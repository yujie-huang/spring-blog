package com.huangyujie.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huangyujie.demo.entity.SuAdmin;
import com.huangyujie.demo.repository.SuAdminRepository;

@Service
public class SuAdminService {
	@Autowired
	private SuAdminRepository suAdminRepository;
	
	public SuAdmin addSuAdmin(SuAdmin suAdmin) {
		return suAdminRepository.save(suAdmin);
	}
	
	public List<SuAdmin> findAll() {
		return suAdminRepository.findAll();
		
	}
}
