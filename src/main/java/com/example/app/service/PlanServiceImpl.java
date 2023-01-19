package com.example.app.service;

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

}
