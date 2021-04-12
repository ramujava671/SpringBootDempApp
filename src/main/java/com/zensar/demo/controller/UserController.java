package com.zensar.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.demo.model.UserRequest;
import com.zensar.demo.model.UserResponse;
import com.zensar.demo.service.UserInterface;

@Configuration
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@RestController("/user")
public class UserController {
	
	@Autowired
    private UserInterface userService;
	
	@GetMapping()  
	public String getUseres()
	{ 
	 	
			return "Hi Ram";
	}
	
	@PostMapping(produces = {"application/JSON"},
			consumes = {"application/JSON"})
	public UserResponse fetchmodifiedUseres(@RequestBody UserRequest userRequeast)
	{
		return userService.filterUserList(userRequeast);
	}
}
