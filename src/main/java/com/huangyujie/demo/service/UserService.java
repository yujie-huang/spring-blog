package com.huangyujie.demo.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huangyujie.demo.PBKDF2Util;
import com.huangyujie.demo.entity.User;
import com.huangyujie.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PBKDF2Util pbk; ///PBKDF2加密
	
	//加密并添加或更新user
	public User addUser(User user) throws NoSuchAlgorithmException, InvalidKeySpecException {
		user.setPassword(pbk.getEncryptedPassword(user.getPassword(), user.getUserName()));
		
		return userRepository.save(user);
	}
	public List<User> findAll() {
		return userRepository.findAll();
		
	}
	
	
	public boolean login(String userName, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		User user =userRepository.findUserByUserName(userName);
		
		if(user!=null&&pbk.authenticate(password, user.getPassword(), userName)&&user.isStatus()){
			return true;
		}
		// TODO Auto-generated method stub
		else {
			return false;
		}
		
	}
	public boolean isExist(String userName) {
		// TODO Auto-generated method stub
		if(userRepository.findUserByUserName(userName)!=null)
			return true;
		else {
			return false;
		}
		
	}
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findUserByUserName(userName);
	}
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		System.out.println(user.getUserId());
		userRepository.save(user);
	}
	public void rePassword(User user, String newpassword) throws NoSuchAlgorithmException, InvalidKeySpecException {
		// TODO Auto-generated method stub
		user.setPassword(newpassword);
		addUser(user);
	}
	public boolean changeStatu(String userName) throws NoSuchAlgorithmException, InvalidKeySpecException {
		// TODO Auto-generated method stub
		User user = findByUserName(userName);
		if(user.isStatus()) {
			user.setStatus(false);
		}
		else {
			user.setStatus(true);
		}
		
		addUser(user);
		return true;
	}
	public boolean repwd(String userName, String newpassword) throws NoSuchAlgorithmException, InvalidKeySpecException {
		// TODO Auto-generated method stub
		User user = findByUserName(userName);
		user.setPassword(newpassword);
		addUser(user);
		return true;
	}
	public boolean addU(String userName, String newpassword) throws NoSuchAlgorithmException, InvalidKeySpecException {
		// TODO Auto-generated method stub
		if(isExist(userName))
			return false;
		else {
			User user = new User();
			user.setName("未知");
			user.setUserName(userName);
			user.setPassword(newpassword);
			addUser(user);
			return true;
		}
	}
	public User findByID(int iD) {
		// TODO Auto-generated method stub
		return userRepository.findByUserId(iD);
	}

}
