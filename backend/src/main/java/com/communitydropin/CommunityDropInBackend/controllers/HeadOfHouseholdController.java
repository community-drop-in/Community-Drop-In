package com.communitydropin.CommunityDropInBackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.communitydropin.CommunityDropInBackend.HeadOfHousehold;
import com.communitydropin.CommunityDropInBackend.HeadOfHouseholdRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class HeadOfHouseholdController {

	@Autowired
	HeadOfHouseholdRepository hohRepo;
	
	@GetMapping("/receipients")
	public Iterable<HeadOfHousehold> retrieveAllRecipients(){
		return hohRepo.findAll();
	}

	public HeadOfHousehold retrieveSingleRecipient(Long id) {
		
		return hohRepo.findById(id).get();
	}

	public Object postSingleHoh(HeadOfHousehold hoh) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
//	@GetMapping("/receipients/{id}")
//	public HeadOfHousehold sendReceipient(@PathVariable Long id) {
//		return hohRepo.findById(id).get();
//	}
//	@PostMapping("/add-receipient")
//	public HeadOfHousehold addHoh(String firstName, String lastName, String address, Long phoneNumber, boolean deliveryStatus, int houseSize, LocalDate dateOfBirth) {
//		HeadOfHousehold hohToAdd = new HeadOfHousehold(firstName, lastName, address, phoneNumber, deliveryStatus, houseSize, dateOfBirth);
//		if (hohRepo.findByPhoneNumber(hohToAdd.getPhoneNumber())==null) {
//			hohRepo.save(hohToAdd);
//		}
//		return hohRepo.findByPhoneNumber(hohToAdd.getPhoneNumber());
//	}
}
	
