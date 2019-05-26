package com.vm.api.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.websocket.server.PathParam;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vm.api.RequestBean;
import com.vm.api.ResponseBean;
import com.vm.api.model.User;
import com.vm.api.service.UserService;

@RestController
@RequestMapping(path = "/api")
public class UserController {

	private static final Logger log = LogManager.getLogger(UserController.class.getName());
	
	@Autowired
	UserService userService;
	
	/**
	 * 유저 목록 가져오기
	 * @return
	 */
	@GetMapping("/user")
	public UserResponseBean findAllUser(){
		log.info("findAllUser");
		UserResponseBean response = new UserResponseBean();
		List<User> list = userService.findAllUser();
		
		if(list == null || list.size() == 0) {
			response.setMessage("Failed List Sentence");
			response.setRes(false);
		}else {
			response.setMessage("Success List Sentence");
			response.setData(list);
			response.setRes(true);
		}
		
		return response;
	}
	
	
	/**
	 * 유저의 정보 하나를 가져오기
	 * @param user_id
	 */
	@GetMapping("/user/{user_id}")
	public UserResponseBean findOneUser(@PathVariable("user_id") Integer user_id){
		log.info("findOneUser");
		UserResponseBean response = new UserResponseBean();
		User user = userService.findOneUser(user_id);
		List<User> list = new ArrayList<User>();
		
		if(user==null) {
			response.setMessage("Failed GetOne User Info");
			response.setRes(false);
		}else {
			response.setMessage("Success GetOne User Info");
			list.add(user);
			response.setData(list);
			response.setRes(true);
		}
		
		
		return response;
	}
	
	/**
	 * 유저 생성
	 */
	@PostMapping("/user")
	public UserResponseBean createUser(@RequestBody final UserRequestBean request) {
		log.info("createUser");
		UserResponseBean response = new UserResponseBean();
		User createdUser = userService.createUser(request.getData().get(0));
		List<User> list = new ArrayList<User>();
		
		if(createdUser==null) {
			response.setMessage("Failed Create User Info");
			response.setRes(false);
		}else {
			response.setMessage("Success Create User Info");
			list.add(createdUser);
			response.setData(list);
			response.setRes(true);
		}
		
		return response;
	}
	
	
	/**
	 * 유저 정보 생성
	 * @return
	 */
	@PutMapping("/user")
	public UserResponseBean updateUser(@RequestBody final UserRequestBean request) {
		UserResponseBean response = new UserResponseBean();
		log.info("updateUser");
		
		User updatedUser = userService.updateUser(request.getData().get(0));
		List<User> list = new ArrayList<User>();
		
		
		if(updatedUser==null) {
			response.setMessage("Failed Update User Info");
			list.add(userService.findOneUser(request.getData().get(0).getUser_id()));
			response.setData(list);
			response.setRes(false);
		}else {
			response.setMessage("Success Update User Info");
			list.add(updatedUser);
			response.setData(list);
			response.setRes(true);
		}
		
		return response;
	}
	
	/**
	 * 유저 정보 삭제
	 * @return
	 */
	@DeleteMapping("/user/{user_id}")
	public UserResponseBean deleteUser(@PathVariable("user_id") Integer user_id) {

		log.info("deleteUser");
		UserResponseBean response = new UserResponseBean();
		
		boolean res = userService.deleteUser(user_id);
		if(!res) {
			response.setMessage("Failed Delete User Info");
			response.setRes(false);
		}else {
			response.setMessage("Success Delete User Info");
			response.setRes(true);
		}
		return response;
	}
	
	
	/**
	 * 유저가 존재하는지 확인
	 * @return
	 */
	@PostMapping("/user/check")
	public UserResponseBean checkUserMail(@RequestBody final UserRequestBean request) {
		log.info("checkUserMail");
		UserResponseBean response = new UserResponseBean();
		
		String user_mail = request.getData().get(0).getUser_mail();
		
		boolean res = userService.isUser(user_mail);
		
		if(res) {
			response.setMessage("Already Exist User");
			response.setRes(false);
		} else {
			response.setMessage("Not Found User");
			response.setRes(true);
		}
		
		return response;
	}
	
	
	/**
	 * id, pw로 로그인하기
	 * @return
	 */
	@PostMapping("/user/login")
	public UserResponseBean userLogin(
			@RequestBody final UserRequestBean request ) {
		log.info("userLogin");
		
		User user = request.getData().get(0);
		String user_mail = user.getUser_mail();
		String user_passwd = user.getUser_passwd();
		
		HashMap res = userService.checkUserPassword(user_mail, user_passwd);
		UserResponseBean response = new UserResponseBean();
		List<User> list = new ArrayList<User>();
		
		
		if((int)res.get("msg") == 0) {
			response.setMessage("Login Success");
			list.add((User)res.get("data"));
			response.setData(list);
			response.setRes(true);
		}else {
			response.setMessage("Login Failed");
			response.setRes(false);
		}
		
		return response;
	}
	
	
}


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
class UserRequestBean extends RequestBean implements Serializable{

	private static final long serialVersionUID = 7341489062124526682L;
	
	private List<User> data;
	
	public List<User> getData() {
		return data;
	}
	public void setData(List<User> data) {
		this.data = data;
	}
	
}


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
class UserResponseBean extends ResponseBean implements Serializable{

	private static final long serialVersionUID = 2462960532603595150L;
	
	private List<User> data;
	
	public List<User> getData() {
		return data;
	}
	public void setData(List<User> data) {
		this.data = data;
	}
	
}
