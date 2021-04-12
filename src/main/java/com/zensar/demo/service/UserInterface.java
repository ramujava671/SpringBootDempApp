package com.zensar.demo.service;

import org.springframework.stereotype.Service;

import com.zensar.demo.model.UserRequest;
import com.zensar.demo.model.UserResponse;
@Service
public interface UserInterface {
	UserResponse filterUserList(UserRequest userRequest);
	

}
