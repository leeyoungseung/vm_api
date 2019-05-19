package com.vm.api.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vm.api.model.User;
import com.vm.api.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAllUser(){
		List<User> userList= userRepository.findAll();
		return userList;
	}
	
	
	public User findOneUser(Integer user_id) {
		User user = userRepository.getOne(user_id);
		return user;
	}
	
	
	public User createUser(User user) {
		User createdUser = userRepository.save(user);
		return createdUser;
	}
	
	
	public User updateUser(Integer user_id, User user) {
		userRepository.findById(user_id)
		.map(update_user -> {
			update_user.setUser_name(user.getUser_name());
			update_user.setUser_passwd(user.getUser_passwd());
			update_user.setUser_sort(user.getUser_sort());
			update_user.setUser_country(user.getUser_country());
			update_user.setUser_update_day(user.getUser_update_day());
			return userRepository.save(update_user);
		}).orElseGet(()->{
			user.setUser_id(user_id);
			return userRepository.save(user);
		});
		return null;
	}
	
	public boolean deleteUser(Integer user_id) {
		boolean res = false;
		userRepository.deleteById(user_id);
		try {
			userRepository.getOne(user_id);
		}catch (EntityNotFoundException e) {res = true;}
		return res;
	}
	

}
