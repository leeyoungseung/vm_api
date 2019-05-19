package com.vm.api.service;

import java.util.HashMap;
import java.util.List;

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


	/**
	 * 유저가 있는 지 여부 확인 
	 * 유저가 존재할 시 0; 유저가 없을시 1;
	 * @param user_mail
	 * @return
	 */
	public int checkUserMail(String user_mail) {
		List<User> list= userRepository.checkUserMail(user_mail);

		if(list.size() > 0) {
			return 0;
		}else {
			return 1;
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
