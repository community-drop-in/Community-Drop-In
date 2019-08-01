package com.communitydropin.CommunityDropInBackend.controllers;

import java.time.LocalDate;

import org.json.JSONException;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONParser;
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
	public Iterable <HeadOfHousehold> postSingleRecipient(@RequestBody String hohDataString) throws JSONException {
		Object hohDataObject = JSONParser.parseJSON(hohDataString);
		JSONObject hohDataJson = (JSONObject) hohDataObject;
		String firstName = hohDataJson.getString("firstName");
		String lastName = hohDataJson.getString("lastName");
		HeadOfHousehold newHoh;
//		newHoh = new HeadOfHousehold(firstName, lastName, address, phoneNumber, deliveryStatus, houseSize, dateOfBirth);
		newHoh = new HeadOfHousehold(firstName, lastName, "address", 6145551212L, true, 5, LocalDate.of(1900, 1, 1));
		hohRepo.save(newHoh);
		return hohRepo.findAll();
	}
}
	
