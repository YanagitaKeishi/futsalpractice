package com.example.app.service;

import java.util.List;

import com.example.app.domain.User;

public interface UserService {

	List<User>getUserList() throws Exception;
	
	void addReserv(User user) throws Exception;
}
