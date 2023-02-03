package com.example.app.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.app.service.PlanService;
import com.example.app.service.TypeService;

public class TimeScheduleLogic {

	@Autowired
	PlanService planService;

	@Autowired
	TypeService typeService;

	

	public TimeSchedule showSchedule(String select) throws Exception {
		//タイムスケジュールのインスタンス生成
		TimeSchedule ts = new TimeSchedule();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date eventAt = dateFormat.parse(select);
		ts.setDate(eventAt);
		
		
		
		List<Integer>idList = typeService.getCourtId();
		//整数のリストを整数の配列に変換
		int[] idArray = idList.stream().mapToInt(i->i).toArray();
		
		List<List<Plan>>schedules = new ArrayList<>();
		for(int id : idArray) {
			List<Plan> planList = planService.getPlanDate(eventAt, id);
			schedules.add(planList);
		}
		System.out.println(schedules);
			

		
		return ts;
	}
	
	
	
	
//	String select = year +"-"+ month +"-"+ day;
//	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//	Date eventAt = dateFormat.parse(select);
//	model.addAttribute("eventDay", eventAt);
//	Integer courtId1 = 1;
//	Integer courtId2 = 2;
//	model.addAttribute("selectCourtA", planService.getPlanDate(eventAt,courtId1));
//	model.addAttribute("selectCourtB", planService.getPlanDate(eventAt,courtId2));
}
