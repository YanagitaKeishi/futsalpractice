package com.example.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.PlanType;

@Mapper
public interface PlanTypeDao {

	List<PlanType> selectAll() throws Exception;
	
	PlanType addCourt(Integer id) throws Exception;
}
