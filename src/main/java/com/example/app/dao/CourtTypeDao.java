package com.example.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.CourtType;

@Mapper
public interface CourtTypeDao {

	List<CourtType>selectAll() throws Exception;
	
	Integer selelctIdAll()throws Exception;
}
