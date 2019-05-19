package com.vm.api.repo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.vm.api.service.UserService;
import com.vm.api.model.User;


public class DatabaseTest {
	
	@Test
	public void test() {
		UserService userService = new UserService();
		
		List<User> list = userService.findAllUser();
		User user = userService.findOneUser(list.get(0).getUser_id());
		
		assertTrue("Don't have User Data", user.getUser_name().equals("admin"));
	}

}
