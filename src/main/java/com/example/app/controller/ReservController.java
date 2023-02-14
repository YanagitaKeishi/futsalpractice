package com.example.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.domain.Plan;
import com.example.app.domain.User;
import com.example.app.service.PlanService;
import com.example.app.service.TypeService;
import com.example.app.service.UserService;

@Controller
@RequestMapping("/reserv")
public class ReservController {
	
	@Autowired
	PlanService planService;
	@Autowired
	TypeService typeService;
	@Autowired
	UserService userService;

	@GetMapping
	public String reservList(@RequestParam Integer id,
					Model model) throws Exception {
		List<Plan> plans = planService.getByPlanType(id);
		String name = plans.get(0).getPlanType().getName();
		model.addAttribute("plans", plans);
		model.addAttribute("name", name);
		return "user/plan-type";
	}
	
	@GetMapping("/detail")
	public String reservDetail(@RequestParam Integer id,
					Model model) throws Exception{
		model.addAttribute("plan", planService.getPlanById(id));
		return "user/plan-detail";
	}
	
	@GetMapping("/add")
	public String getReserv(@RequestParam Integer id,
					Model model) throws Exception {
		model.addAttribute("user", new User());
		model.addAttribute("userTypes", typeService.getUserType());
		model.addAttribute("plan", planService.getPlanById(id));
		return "user/reserv-form";
	}
	
	@PostMapping("/add")
	public String postReserv(@ModelAttribute User user,
					@RequestParam Integer id) throws Exception{
		user.setPlanId(id);
		userService.addReserv(user);
		return "user/reservDone";
		
	}
	
}
