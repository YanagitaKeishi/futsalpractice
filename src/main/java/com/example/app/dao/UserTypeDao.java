package com.example.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.UserType;

@Mapper
public interface UserTypeDao {

	List<UserType> selectAll() throws Exception;
}
