package com.example.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dao.PlanDao;
import com.example.app.domain.Plan;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	PlanDao planDao;

	@Override
	public List<Plan> getPlanList() throws Exception {
		return planDao.selectAll();
	}

	@Override
	public Plan getPlanById(Integer id) throws Exception {
		return planDao.selectById(id);
	}
	
	@Override
	public List<Plan>getPlanType(String planType) throws Exception {
		return planDao.selectPlanTypeId(planType);
	}

	@Override
	public List<Plan> getPlanDate(Date eventAt,Integer courtTypeid) throws Exception {
		return planDao.selectPlanDate(eventAt,courtTypeid);
	}
}
