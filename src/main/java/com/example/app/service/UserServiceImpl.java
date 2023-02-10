package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dao.UserDao;
import com.example.app.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao ;
	
	@Override
	public List<User> getUserList() throws Exception {
		return userDao.selectAll();
	}

	@Override
	public void addReserv(User user) throws Exception {
		userDao.insert(user);;
		
	}

}
