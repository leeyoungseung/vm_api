package com.vm.api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vm.api.model.User;
import com.vm.api.repo.UserRepository;

@Service
public class UserService {
	
	private static final Logger log = LogManager.getLogger(UserService.class.getName());
	
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
	
	
	public User updateUser(User user) {
		
		Integer user_id = user.getUser_id();
		User ex = userRepository.getOne(user_id);
		String name = ex.getUser_name();
		String passwd = ex.getUser_passwd();
		Integer sort = ex.getUser_sort();
		String country = ex.getUser_country();
		
		/**
		 * 이 시점은 분명 값이 다름
		 */
		log.info("user.getUser_name() : " + user.getUser_name());
		log.info("res.getUser_name() : "+ ex.getUser_name());
		log.info("user.getUser_passwd() : " +user.getUser_passwd());
		log.info("res.getUser_passwd() : "+ex.getUser_passwd());
		log.info("user.getUser_sort() : "+ex.getUser_sort());
		log.info("res.getUser_sort(): "+ex.getUser_sort());
		log.info("user.getUser_country() : "+user.getUser_country());
		log.info("res.getUser_country() : " +ex.getUser_country());
		
		
		
		userRepository.findById(user_id)
		.map(update_user -> {
			log.info("update map (1)");
			update_user.setUser_name(user.getUser_name());
			update_user.setUser_passwd(user.getUser_passwd());
			update_user.setUser_sort(user.getUser_sort());
			update_user.setUser_country(user.getUser_country());
			update_user.setUser_update_day(user.getUser_update_day());
			return userRepository.save(update_user);
		});
		
		/**
		 * 의문점 
		 * 왜 이 시점에서 값이 같은가?
		 */
		log.info("user.getUser_name() : " + user.getUser_name());
		log.info("res.getUser_name() : "+ ex.getUser_name());
		log.info("user.getUser_passwd() : " +user.getUser_passwd());
		log.info("res.getUser_passwd() : "+ex.getUser_passwd());
		log.info("user.getUser_sort() : "+user.getUser_sort());
		log.info("res.getUser_sort(): "+ex.getUser_sort());
		log.info("user.getUser_country() : "+user.getUser_country());
		log.info("res.getUser_country() : " +ex.getUser_country());
		
//		if(!user.getUser_name().equals(res.getUser_name()) || 
//		!user.getUser_passwd().equals(res.getUser_passwd()) || 
//		user.getUser_sort()!=res.getUser_sort() ||	
//		!user.getUser_country().equals(res.getUser_country())) 
		
		if(!user.getUser_name().equals(name) || 
		!user.getUser_passwd().equals(passwd) || 
		user.getUser_sort()!=sort ||	
		!user.getUser_country().equals(country)) 
		{
			return userRepository.getOne(user_id);
		}else {
			log.info("Failed Update");
			return null;
		}
		
	}
	
	public boolean deleteUser(Integer user_id) {
		boolean res = true;
		userRepository.deleteById(user_id);
		try {
			userRepository.getOne(user_id);
		}catch (EntityNotFoundException e) {
			log.info("UserService Delete Fail");
			res = false;}
		return res;
	}


	/**
	 * 유저가 있는 지 여부 확인 
	 * 유저가 존재할 시 true; 유저가 없을시 false;
	 * @param user_mail
	 * @return
	 */
	public boolean isUser(String user_mail) {
		List<User> list= userRepository.checkUserMail(user_mail);

		if(list.size() > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 등록한 이메일에 해당하는 비번이 맞는지 확인
	 * @param user_mail
	 * @param user_passwd
	 * @return
	 */
	public HashMap checkUserPassword(String user_mail, String user_passwd) {
		List<User> list = userRepository.checkUserPassword(user_mail, user_passwd);
		HashMap res = new HashMap<>();
		
		if(list.size() > 0) {
			log.info("login success");
			res.put("msg", 0);
			res.put("data", list.get(0));
			
		}else if(list.size() == 0){
			log.info("login failed");
			res.put("msg", 1);
		}
		
		return res;
		
	}
	

}
