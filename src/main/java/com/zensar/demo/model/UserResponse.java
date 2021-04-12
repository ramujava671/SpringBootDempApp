package com.zensar.demo.model;

import java.util.List;

public class UserResponse {

	private int uniqueTotalCount;
	private List<User> uniqueUserList;

	
	public int getCount() {
		return uniqueTotalCount;
	}

	public void setCount(int count) {
		this.uniqueTotalCount = count;
	}

	public List<User> getUserList() {
		return uniqueUserList;
	}

	public void setUniqueUserList(List<User> userList) {
		this.uniqueUserList = userList;
	}

}
