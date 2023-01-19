package com.example.app.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.User;

@Mapper
public interface UserService {

	List<User>getUserList() throws Exception;
}
