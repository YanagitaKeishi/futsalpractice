package com.example.app.service;

import java.util.Date;
import java.util.List;

import com.example.app.domain.Plan;

public interface PlanService {

	List<Plan>getPlanList() throws Exception;
	
	Plan getPlanById(Integer id) throws Exception;
	
	List<Plan>getPlanType(String planType) throws Exception;
	
	List<Plan> getPlanDate(Date eventAt, Integer id) throws Exception;
}
