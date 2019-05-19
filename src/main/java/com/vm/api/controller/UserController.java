package com.vm.api.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
	
	
	@PostMapping("/user")
	public String createUser(@RequestBody final User user) {
		log.info("createUser");
		User createdUser = userService.createUser(user);
		if(createdUser != null) {
			return "Success SignUp";
		}
		return "Failed SignUp Try Again";
	}
	
	
	@PutMapping("/user/{user_id}")
	public UserResponseBean updateUser(
			@PathVariable("user_id") Integer user_id, 
			@RequestBody final User user) {
		UserResponseBean response = new UserResponseBean();
		User updatedUser = userService.updateUser(user_id, user);
		
		if(updatedUser==null) {
			response.setMessage("Failed Update User Info");
			response.setData(userService.findOneUser(user_id));
		}else {
			response.setMessage("Success Update User Info");
			response.setData(updatedUser);
		}
		
		return response;
	}
	
	
	@DeleteMapping("/user/{user_id}")
	public UserResponseBean deleteUser(@PathVariable("user_id") Integer user_id) {
		UserResponseBean response = new UserResponseBean();
		
		boolean res = userService.deleteUser(user_id);
		if(!res) {
			response.setMessage("Failed Delete User Info");
		}else {
			response.setMessage("Success Delete User Info");
		}
		return response;
	}
	
	
	@PostMapping("/user/check")
	public int checkUserMail(@RequestBody final String user_mail) {
		log.info("checkUserMail");
		int res = userService.checkUserMail(user_mail);
		return res;
	}
	
	@PostMapping("/user/login")
	public UserResponseBean userLogin(
//			@RequestBody(required=false) final String user_mail, 
//			@RequestBody(required=false) final String user_passwd
			@RequestBody(required=false) final User user
			) {
		log.info("userLogin");
		
		String user_mail = user.getUser_mail();
		String user_passwd = user.getUser_passwd();
		
		HashMap res = userService.checkUserPassword(user_mail, user_passwd);
		
		UserResponseBean response = new UserResponseBean();
		
		if((int)res.get("msg") == 0) {
			response.setMessage("Login Success");
			response.setData((User)res.get("data"));
		}else {
			response.setMessage("Login Failed");
		}
		
		return response;
	}
	
	
	
	
}

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
class UserResponseBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2462960532603595150L;
	
	private String message;
	private User data;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getData() {
		return data;
	}
	public void setData(User data) {
		this.data = data;
	}
	
}
