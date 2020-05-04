package com.huangyujie.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huangyujie.demo.entity.User;
import com.huangyujie.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User user) {
		return userRepository.save(user);
	}
	public List<User> findAll() {
		return userRepository.findAll();
		
	}
	
	
	public boolean login(String userName, String password) {
		User user =userRepository.findUserByUserName(userName);
		
		if(user!=null&&user.getPassword().equals(password)){
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
	public void rePassword(User user, String newpassword) {
		// TODO Auto-generated method stub
		user.setPassword(newpassword);
		userRepository.save(user);
	}

}
