package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.service.PlanService;

@Controller
@RequestMapping("/admin")//管理者ページ
public class AdminController {

	@Autowired
	PlanService planService;
	
	@GetMapping("/home")//管理者ホーム
	public String home() {
		return "admin/home";
	}
	
	@GetMapping("/calendar")
	public String calendar() {
		return "parts/calendar";
	}
	
	@GetMapping("/time")
	public String time() {
		return "parts/time-list";
	}
	
	@GetMapping("/reserv")//予約状況一覧
	public String reservList (Model model) throws Exception{
			model.addAttribute("reservs", planService.getPlanList());
			return "admin/reserv-list";
	}
	
	@GetMapping("/reserv/detail/{id}")//予約状況詳細
	public String reservDetail(@PathVariable Integer id,Model model)
					throws Exception{
		model.addAttribute("plan", planService.getPlanById(id));
		return "admin/reserv-detail";
	}
	
}
