package com.communitydropin.CommunityDropInBackend.controllers;

import java.time.LocalDate;

import org.json.JSONException;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.communitydropin.CommunityDropInBackend.entities.FoodOrder;
import com.communitydropin.CommunityDropInBackend.entities.HeadOfHousehold;
import com.communitydropin.CommunityDropInBackend.repositories.FoodOrderRepository;
import com.communitydropin.CommunityDropInBackend.repositories.HeadOfHouseholdRepository;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class FoodOrderController {

	@Autowired
	FoodOrderRepository foodOrderRepo;
	
	@Autowired
	HeadOfHouseholdRepository hohRepo;
	
	@GetMapping("/food-orders")
	public Iterable<FoodOrder> retrieveAllFoodOrders() {
		return foodOrderRepo.findAll(Sort.by(Sort.Direction.ASC,"date"));
	}
	
	@GetMapping("/food-orders/{id}")
	public FoodOrder retrieveSingleFoodOrder(@PathVariable Long id) {
		return foodOrderRepo.findById(id).get();
	}
	
	@PostMapping("/food-orders")
	public Iterable<HeadOfHousehold> postSingleFoodOrder(@RequestBody String orderDataString) throws JSONException {
		FoodOrder foodOrder = makeFoodOrderFromDataJson(orderDataString);
		foodOrderRepo.save(foodOrder);
		return hohRepo.findAll(Sort.by(Sort.Direction.ASC, "lastName"));
		
	}
	public void foo () {
		
	}

	private FoodOrder makeFoodOrderFromDataJson(String orderDataString) throws JSONException {
		FoodOrder foodOrder;
		Object orderDataObject = JSONParser.parseJSON(orderDataString);
		JSONObject orderDataJson = (JSONObject) orderDataObject;
		Long phoneNumber = orderDataJson.getLong("phoneNumber");
		HeadOfHousehold retrievedHoh = hohRepo.findByPhoneNumber(phoneNumber);
		String dateString = orderDataJson.getString("date");
		foodOrder = new FoodOrder(retrievedHoh, LocalDate.parse(dateString));
		return foodOrder;
	}
	
	
	
	
	
}
