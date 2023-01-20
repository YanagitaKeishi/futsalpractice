package com.example.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Plan;

@Mapper
public interface PlanDao {

	List<Plan>selectAll() throws Exception;
	
	Plan selectById(Integer id) throws Exception;
}
