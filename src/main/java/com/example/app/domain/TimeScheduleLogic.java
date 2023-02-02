package com.example.app.domain;

import java.text.SimpleDateFormat;
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
	
	private Date eventAt;
	
	public TimeSchedule showSchedule(String select) throws Exception {
		//タイムスケジュールのインスタンス生成
		TimeSchedule ts = new TimeSchedule();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date eventAt = dateFormat.parse(select);
		this.eventAt = eventAt;
		
		List<Plan> schedules = planService.getPlanDate(eventAt, 1);
		
		Integer courtId = 0 ;
		while(courtId == -1) {
			courtId = typeService.getCourtId();
			//courtIdの取得の続き、複数の値はList？
		}
		
		
		
		
		
		
		//SELECT DISTINCT court_type_id  FROM plans..DISTINCTで重複回避
		

		
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
