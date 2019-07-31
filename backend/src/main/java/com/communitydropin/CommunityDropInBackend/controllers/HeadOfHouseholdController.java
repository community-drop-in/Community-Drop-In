package com.communitydropin.CommunityDropInBackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/recipients")
	public Iterable<HeadOfHousehold> retrieveAllRecipients(){
		return hohRepo.findAll();
	}
	@GetMapping("/recipients/{id}")
	public HeadOfHousehold retrieveSingleRecipient(@PathVariable Long id) {
		
		return hohRepo.findById(id).get();
	}
	@PostMapping("/recipients")
	public Iterable <HeadOfHousehold> postSingleRecipient(@RequestBody HeadOfHousehold hoh) {
		hohRepo.save(hoh);
		return hohRepo.findAll();
	}
}
	
