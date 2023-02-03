package com.example.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

	@Override
	public List<Map<String, Plan>> getMap(Date eventAt, Integer courtTypeId) throws Exception {
		//日付とコートで検索したプランリストを取得
		List<Plan> PlanList = planDao.selectPlanDate(eventAt, courtTypeId);
		//
		List<Map<String,Plan>>CourtTypePlanList = new ArrayList<>();
//		for(int i = 0;i<PlanList.size();i++) {
//			Plan p  = PlanList.get(i);{
//			Map<String,Object> plan = new HashMap<>();
//			plan.put("id", p.getId());
//			plan.put("eventAt", p.getEventAt());
//			plan.put("planType", p.getPlanType());
//			
//		}
		return CourtTypePlanList;
	}
}
