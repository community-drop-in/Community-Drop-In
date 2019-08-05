package com.communitydropin.CommunityDropInBackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.communitydropin.CommunityDropInBackend.entities.FoodOrder;
import com.communitydropin.CommunityDropInBackend.repositories.FoodOrderRepository;
import com.communitydropin.CommunityDropInBackend.repositories.HeadOfHouseholdRepository;


@RestController
@RequestMapping("/api")
public class FoodOrderController {

	@Autowired
	FoodOrderRepository foodOrderRepo;
	
	@Autowired
	HeadOfHouseholdRepository hohRepo;
	
	@GetMapping("/food-orders")
	public Iterable<FoodOrder> retrieveAllFoodOrders() {
		return foodOrderRepo.findAll();
	}
}
