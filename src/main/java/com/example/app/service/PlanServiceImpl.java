package com.example.app.service;

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
	public List<Plan>getByPlanType(String planType) throws Exception {
		return planDao.selectPlanTypeId(planType);
	}

	@Override
	public List<Plan> getPlanDate(Date eventAt,Integer courtTypeid) throws Exception {
		return planDao.selectPlanDate(eventAt,courtTypeid);
	}

	@Override
	public List<Map<String, Plan>> getMap(Date eventAt, Integer courtTypeId) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void addPlan(Plan plan) throws Exception {
		planDao.insert(plan);
	}

	@Override
	public void editPlan(Plan plan) throws Exception {
		planDao.update(plan);
	}

	@Override
	public void deletePlan(Integer id) throws Exception {
		planDao.delete(id);
	}

	@Override
	public String message(String status) throws Exception {
		String message = null;
		
		if(status == null) {
			return message;
		}
		switch(status) {
		case "add":
			message = "イベントを作成しました。";
			break;
		case "edit":
			message = "イベント情報を更新しました。";
			break;
		case "delete":
			message = "イベント情報を削除しました。";
			break;
		}
		return message;
	}
}
