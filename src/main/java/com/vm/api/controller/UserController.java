package com.vm.api.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vm.api.model.User;
import com.vm.api.service.UserService;

@RestController
@RequestMapping(path = "/api")
public class UserController {

	private static final Logger log = LogManager.getLogger(UserController.class.getName());
	
	@Autowired
	UserService userService;
	
	@GetMapping("/user")
	public List<User> findAllUser(){
		log.info("findAllUser");
		List<User> list = userService.findAllUser();
		return list;
	}
	
	
	@GetMapping("/user/{user_id}")
	public User findOneUser(@PathVariable("user_id") Integer user_id){
		log.info("findOneUser");
		User user = userService.findOneUser(user_id);
		return user;
	}
}
