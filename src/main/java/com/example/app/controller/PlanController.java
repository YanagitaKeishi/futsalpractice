package com.example.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.domain.Plan;
import com.example.app.service.PlanService;
import com.example.app.service.TypeService;

@Controller
@RequestMapping("/plan")
public class PlanController {

	@Autowired
	PlanService service;
	@Autowired
	TypeService typeService;
	
	@InitBinder
	public void initBinderForm(WebDataBinder binder) {
		// <input type="date">の変換
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, "eventAt",
		new CustomDateEditor(dateFormat, true));
	}
	
	@GetMapping("/list")
	public String list(
			@RequestParam(name = "status" ,required = false) String status
			,Model model) throws Exception{
		model.addAttribute("planList", service.getPlanList());
		model.addAttribute("message", service.message(status));
		return "admin/plan-list";
	}
	
//	@GetMapping("/{planId}")
//	public String type(@PathVariable String planType,
//					Model model) throws Exception{
//		model.addAttribute("planTypes", service.getByPlanType(planType));
//		return "user/plan-type";
//	}
	
	@GetMapping("/add")
	public String getAdd(Model model) throws Exception {
		model.addAttribute("plan", new Plan());
		model.addAttribute("planTypes", typeService.getPlanType());
		model.addAttribute("courtTypes", typeService.getCourtType());
		model.addAttribute("timeZones", typeService.getTimeZone());
		return "admin/add-plan";
	}
	
	@PostMapping("/add")
	public String postAdd(@ModelAttribute Plan plan) throws Exception {
		service.addPlan(plan);
		return "redirect:/plan/list?status=add";
	}
	
	@GetMapping("/delete")
	public String getDelete(@RequestParam Integer id, Model model) throws Exception{
		service.deletePlan(id);
		return "redirect:/plan/list?status=delete";
	}
	
	@GetMapping("/edit")
	public String getEdit(@RequestParam Integer id
						,Model model) throws Exception{
		model.addAttribute("plan", service.getPlanById(id));
		Plan plan = service.getPlanById(id);
		System.out.println(plan);
		model.addAttribute("planTypes", typeService.getPlanType());
		model.addAttribute("courtTypes", typeService.getCourtType());
		model.addAttribute("timeZones", typeService.getTimeZone());
		return "admin/edit-plan";
	}
	
	@PostMapping("/edit")
	public String postEdit(@RequestParam Integer id,
				@ModelAttribute Plan plan, Model model) throws Exception{
//		if(errors.hasErrors()) {
//			model.addAttribute("planTypes", typeService.getPlanType());
//			model.addAttribute("courtTypes", typeService.getCourtType());
//			model.addAttribute("timeZones", typeService.getTimeZone());
//			return "admin/edit-plan";
//		}
		
		plan.setId(id);
		service.editPlan(plan);
		return "redirect:/plan/list?status=edit";
	}
	
}
