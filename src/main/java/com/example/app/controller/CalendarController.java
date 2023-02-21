package com.example.app.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		MyCalendar mc = logic.createMyCalendar(year,month);
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
		
		Map<String,List<Plan>> planMap = createPlanMap(select,eventAt);
		
		model.addAttribute("planMap", planMap);
		model.addAttribute("eventDay", eventAt);
		model.addAttribute("timeZone", typeService.getTimeZone());
		model.addAttribute("courtTypes", typeService.getCourtType());
		return "parts/time-list";
	}
	
	@GetMapping("/user")
	public String calenderUser(
			@RequestParam (name="year",required=false)Integer year,
			@RequestParam (name="month",required=false)Integer month,
			Model model) {
		MyCalendarLogic logic = new MyCalendarLogic();
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
		MyCalendar mc = logic.createMyCalendar(year,month);
		model.addAttribute("mc", mc);
		return "user/userCalendar";
	}
	
	@GetMapping("/select/user")
	public String timeScheduleUser(
			@RequestParam String year,
			@RequestParam String month,
			@RequestParam String day,
			Model model) throws Exception {
		String select = year +"-"+ month +"-"+ day;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date eventAt = dateFormat.parse(select);
		
		Map<String,List<Plan>> planMap = createPlanMap(select,eventAt);
		
		model.addAttribute("planMap", planMap);
		model.addAttribute("eventDay", eventAt);
		model.addAttribute("timeZone", typeService.getTimeZone());
		model.addAttribute("courtTypes", typeService.getCourtType());
		return "user/user-time-list";
	}
	
	private Map<String,List<Plan>> createPlanMap(String select, Date eventAt) throws Exception{
		//select = リクエストパラメータの日付
		//idListはコート識別IDのリスト
		List<Integer>idList = typeService.getCourtId();
		//courtId(整数)のリストを整数の配列に変換
		int[] idArray = idList.stream().mapToInt(i->i).toArray();
		//plan(コート別)のリスト格納する親リストを作成
		List<List<Plan>>schedules = new ArrayList<>();
		//コートId別でコートリストを格納
		for(int id : idArray) {
			List<Plan> planList = planService.getPlanDate(eventAt, id);
			schedules.add(planList);
		}
		
		//schedulesの要素数（リスト内のリスト数）
		int count = schedules.size();
		
		Map<String,List<Plan>> planMap = new HashMap<>();
		
		for(int i = 0; i<count; i++) {
			if(!schedules.get(i).isEmpty()){
				String courtName = schedules.get(i).get(0).getCourtType().getName();
				List<Plan> lp = schedules.get(i);
				planMap.put(courtName, lp);
			}else {
				continue;
			}
		}
		//startTime_id,endTime_id-startTime_idの２つの値があればタイムスケジュールできそ
		System.out.println(planMap);
		return planMap;
	}
}
