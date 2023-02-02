package com.example.app.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.app.domain.Plan;

@Mapper
public interface PlanDao {

	List<Plan>selectAll() throws Exception;
	
	Plan selectById(Integer id) throws Exception;
	
	List<Plan>selectPlanTypeId(String planType) throws Exception;
	
	List<Plan> selectPlanDate(@Param("eventAt") Date eventAt, 
							@Param("courtTypeId") Integer courtTypeId) throws Exception;
	
}
