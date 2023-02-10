package com.example.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.User;

@Mapper
public interface UserDao {

	List<User>selectAll() throws Exception;
	
	void insert(User user) throws Exception;
}
