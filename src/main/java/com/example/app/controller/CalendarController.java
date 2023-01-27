package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.domain.MyCalendar;
import com.example.app.domain.MyCalendarLogic;

@Controller
@RequestMapping("/calendar")
public class CalendarController {

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
			mc = logic.createMyCalendar(year,month);
		}else {
			mc = logic.createMyCalendar(year,month);
		}
		model.addAttribute("mc", mc);
		return "parts/myCalendar";
	}
}
