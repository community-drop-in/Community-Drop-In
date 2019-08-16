package com.communitydropin.CommunityDropInBackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.communitydropin.CommunityDropInBackend.repositories.FoodOrderRepository;

@Controller
@RequestMapping("/queue")
public class QueuePageController {

	@Autowired
	FoodOrderRepository orderRepo;
	
	@RequestMapping("")
	public String getOrders(Model model) {
		model.addAttribute("orders", orderRepo.findAll());
		return "queueView";
	}
	
	@DeleteMapping("/reject")
	public String deleteOrder(Model model) {
		
		return "queueView";
	}
}
