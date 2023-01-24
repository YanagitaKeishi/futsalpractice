package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.service.PlanService;

@Controller
@RequestMapping("/plan")
public class PlanController {

	@Autowired
	PlanService service;
	
	@GetMapping("/list")
	public String list(Model model) throws Exception {
		model.addAttribute("planList", service.getPlanList());
		return "admin/plan-list";
	}
}
