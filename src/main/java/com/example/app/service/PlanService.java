package com.example.app.service;

import java.util.List;

import com.example.app.domain.Plan;

public interface PlanService {

	List<Plan>getPlanList() throws Exception;
	
	Plan getPlanById(Integer id) throws Exception;
	
	List<Plan>getPlanType(String planType) throws Exception;
}
