package com.communitydropin.CommunityDropInBackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.communitydropin.CommunityDropInBackend.entities.FoodOrder;
import com.communitydropin.CommunityDropInBackend.repositories.FoodOrderRepository;

@Controller
@RequestMapping("/queue")
public class QueuePageController {

	@Autowired
	FoodOrderRepository orderRepo;
	
	@RequestMapping("")
	public Iterable <FoodOrder> getOrders() {
		return orderRepo.findAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public Iterable<FoodOrder> deleteOrder(@PathVariable Long id) {
		orderRepo.deleteById(id);
		return orderRepo.findAll();
	}
}
