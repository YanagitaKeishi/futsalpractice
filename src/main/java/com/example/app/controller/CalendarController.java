package com.example.app.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.domain.MyCalendar;
import com.example.app.domain.MyCalendarLogic;
import com.example.app.domain.Plan;
import com.example.app.service.PlanService;
import com.example.app.service.TypeService;

@Controller
@RequestMapping("/calendar")
public class CalendarController {
	
	@Autowired
	PlanService planService;
	@Autowired
	TypeService typeService;
	
	@InitBinder
	public void initBinderForm(WebDataBinder binder) {
		//リクエストパラメータを日付に変換
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, "eventAt",
									new CustomDateEditor(dateFormat,true));
	}

	@GetMapping
	public String calender(
			@RequestParam (name="year",required=false)Integer year,
			@RequestParam (name="month",required=false)Integer month,
			Model model) {
		MyCalendarLogic logic = new MyCalendarLogic();
		MyCalendar mc = null;
		if(year != null && month != null) {
			if(month == 0) {
				month=12;
				year--;
			}
			if(month==13) {
				month=1;
				year++;
			}
		}
		mc = logic.createMyCalendar(year,month);
		model.addAttribute("mc", mc);
		return "parts/myCalendar";
	}
	
	@GetMapping("/select")
	public String timeSchedule(
			@RequestParam String year,
			@RequestParam String month,
			@RequestParam String day,
			Model model) throws Exception {
		String select = year +"-"+ month +"-"+ day;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date eventAt = dateFormat.parse(select);
		List<Integer>idList = typeService.getCourtId();
		//整数のリストを整数の配列に変換
		int[] idArray = idList.stream().mapToInt(i->i).toArray();
		//planのリスト格納する親リストを作成
		List<List<Plan>>schedules = new ArrayList<>();
		//コートId別でコートリストを格納
		for(int id : idArray) {
			List<Plan> planList = planService.getPlanDate(eventAt, id);
			schedules.add(planList);
		}
		System.out.println(schedules);
		
		int count = schedules.size();
		System.out.println(count);
		
//		List<Map<String,Object>> scheduleList = new ArrayList<>();
		
		
		model.addAttribute("schedules", schedules);
		//先生からの途中
		//タイムリーフ
		
		
		model.addAttribute("eventDay", eventAt);
		model.addAttribute("timeZone", typeService.getTimeZone());
		model.addAttribute("courtTypes", typeService.getCourtType());
		Integer courtId1 = 1;
		Integer courtId2 = 2;
		model.addAttribute("selectCourtA", planService.getPlanDate(eventAt,courtId1));
		model.addAttribute("selectCourtB", planService.getPlanDate(eventAt,courtId2));
		return "parts/time-list";
	}
}
