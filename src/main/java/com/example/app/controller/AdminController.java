package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.service.PlanService;
import com.example.app.service.ReservService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ReservService reservService;
	
	@Autowired
	PlanService planService;
	
	@GetMapping("/home")
	public String home() {
		return "admin/home";
	}
	
	@GetMapping("/reserv")
	public String reservList (Model model) throws Exception{
			model.addAttribute("reservs", planService.getPlanList());
			return "admin/reservs-list";
	}
	
	@GetMapping("/reserv/detail/{id}")
	public String reservDetail(@PathVariable Integer id,Model model)
					throws Exception{
		model.addAttribute("plan",planService.getPlanById(id));
		return "admin/reserv-detail";
	}
}
