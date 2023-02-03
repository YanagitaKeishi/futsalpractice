package com.example.app.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.app.domain.Plan;

public interface PlanService {

	List<Plan>getPlanList() throws Exception;
	
	Plan getPlanById(Integer id) throws Exception;
	
	List<Plan>getPlanType(String planType) throws Exception;
	
	List<Plan> getPlanDate(Date eventAt, Integer courtTypeId) throws Exception;
	
	List<Map<String,Plan>> getMap(@Param("eventAt") Date eventAt, 
			@Param("courtTypeId") Integer courtTypeId) throws Exception;
}
