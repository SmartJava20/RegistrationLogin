package com.smartjava.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartjava.demo.model.User;
import com.smartjava.demo.response.ResultResponse;
import com.smartjava.demo.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	public ResultResponse saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@PostMapping("/login")
	public ResultResponse userLogin(@RequestBody User user) {
		String userName=user.getUserName();
		String password=user.getPassword();
		return userService.loginUser(userName,password);
	}

}
