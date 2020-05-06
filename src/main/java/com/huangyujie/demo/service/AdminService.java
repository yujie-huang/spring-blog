package com.huangyujie.demo.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huangyujie.demo.PBKDF2Util;
import com.huangyujie.demo.entity.Admin;
import com.huangyujie.demo.entity.User;
import com.huangyujie.demo.repository.AdminRepository;


@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private PBKDF2Util pbk; ///PBKDF2加密
	
	public Admin addAdmin(Admin admin) throws NoSuchAlgorithmException, InvalidKeySpecException {
		admin.setPassword(pbk.getEncryptedPassword(admin.getPassword(), admin.getAdminName()));
		return adminRepository.save(admin);
	}
	public List<Admin> findAll() {
		return adminRepository.findAll();
		
	}
	public boolean loginCheck(String u, String p) throws NoSuchAlgorithmException, InvalidKeySpecException {
		// TODO Auto-generated method stub
		Admin admin = adminRepository.findByAdminName(u);
		
		if(admin!=null&&pbk.authenticate(p, admin.getPassword(),admin.getAdminName())&&admin.isStatus())
			return true;
		
		return false;
	}
	
	
	public boolean changeStatu(String userName) {
		// TODO Auto-generated method stub
		Admin admin = adminRepository.findByAdminName(userName);
		if(admin.isStatus()) {
			admin.setStatus(false);
		}
		else {
			admin.setStatus(true);
		}
		
		adminRepository.save(admin);
		return true;
	}
	public boolean repwd(String userName, String newpassword) throws NoSuchAlgorithmException, InvalidKeySpecException {
		// TODO Auto-generated method stub
		Admin admin = adminRepository.findByAdminName(userName);
		
		admin.setPassword(pbk.getEncryptedPassword((newpassword), admin.getAdminName()));
		adminRepository.save(admin);
		return true;
	}
	public boolean addU(String userName, String newpassword) throws NoSuchAlgorithmException, InvalidKeySpecException {
		// TODO Auto-generated method stub
		if(isExist(userName))
			return false;
		else {
			Admin admin = new Admin();
			admin.setAdminName(userName);
			
			admin.setPassword(pbk.getEncryptedPassword((newpassword), userName));
			System.out.println(newpassword+"ppppaaassss");
			adminRepository.save(admin);
			return true;
		}
	}
	private boolean isExist(String userName) {
		// TODO Auto-generated method stub
		if(adminRepository.findByAdminName(userName)!=null)
			return true;
		return false;
	}


}
