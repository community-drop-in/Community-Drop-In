package com.communitydropin.CommunityDropInBackend;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class HeadOfHouseholdController {

	@Autowired
	HeadOfHouseholdRepository hohRepo;
	
	@GetMapping("/receipients")
	public Iterable<HeadOfHousehold> sendReceipients(){
		return hohRepo.findAll();
	}
	@GetMapping("/receipients/{id}")
	public HeadOfHousehold sendReceipient(@PathVariable Long id) {
		return hohRepo.findById(id).get();
	}
	@PostMapping("/add-receipient")
	public HeadOfHousehold addHoh(String firstName, String lastName, String address, Long phoneNumber, boolean deliveryStatus, int houseSize, Calendar dateOfBirth) {
		HeadOfHousehold hohToAdd = new HeadOfHousehold(firstName, lastName, address, phoneNumber, deliveryStatus, houseSize, dateOfBirth);
		if (hohRepo.findByPhoneNumber(hohToAdd.getPhoneNumber())==null) {
			hohRepo.save(hohToAdd);
		}
		return hohRepo.findByPhoneNumber(hohToAdd.getPhoneNumber());
	}
}
	
