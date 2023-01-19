package com.example.app.dao;

import java.util.List;

import com.example.app.domain.User;

public interface UserDao {

	List<User>selectAll() throws Exception;
}
