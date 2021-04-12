package com.zensar.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

import com.zensar.demo.model.User;
import com.zensar.demo.model.UserRequest;
import com.zensar.demo.model.UserResponse;
@Component
public class UserInterfaceImpl implements UserInterface {

	private int count = 0; 

	@Override
	public UserResponse filterUserList(UserRequest userRequest) {
		UserResponse resp = new UserResponse();

		Map<Integer,User> updatedlist=new TreeMap<Integer, User>();
		userRequest.getUserList().stream().forEach(obj->{
			
			if(!updatedlist.containsKey(obj.getUserId())) {
				updatedlist.put(obj.getUserId(), obj);
				count++;
			}			
		});		
		
		for (Map.Entry entry : updatedlist.entrySet())
			if(entry.getKey().equals(4)) {
				User i = (User) entry.getValue();
				i.setBody("1800Flowers");
				i.setTitle("1800Flowers");
		}
		List<User> valueList= new ArrayList<User>(updatedlist.values());
	    resp.setCount(count);
		resp.setUniqueUserList(valueList);
		count = 0;
		return resp;
	}
	
	

}
