package com.communitydropin.CommunityDropInBackend.controllers;

import java.time.LocalDate;
import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
	public Iterable<HeadOfHousehold> retrieveAllRecipients() {
		return hohRepo.findAll();
	}

	@GetMapping("/recipients/{id}")
	public HeadOfHousehold retrieveSingleRecipient(@PathVariable Long id) {

		return hohRepo.findById(id).get();
	}

	@PostMapping("/recipients")
	public HeadOfHousehold postSingleRecipient(@RequestBody String hohDataString) throws JSONException {
		HeadOfHousehold newHoh = makeHohFromDataJson(hohDataString);
		return hohRepo.save(newHoh);
	}

	private HeadOfHousehold makeHohFromDataJson(String hohDataString) throws JSONException {
		Object hohDataObject = JSONParser.parseJSON(hohDataString);
		JSONObject hohDataJson = (JSONObject) hohDataObject;
		String firstName = hohDataJson.getString("firstName");
		String lastName = hohDataJson.getString("lastName");
		String address = hohDataJson.getString("address");
		Long phoneNumber = hohDataJson.getLong("phoneNumber");
		boolean deliveryStatus = hohDataJson.getBoolean("deliveryStatus");
		int houseSize = hohDataJson.getInt("houseSize");
		String dateOfBirthString = hohDataJson.getString("dateOfBirth");
		LocalDate dateOfBirth = LocalDate.parse(dateOfBirthString);
		HeadOfHousehold newHoh;
		newHoh = new HeadOfHousehold(firstName, lastName, address, phoneNumber, deliveryStatus, houseSize, dateOfBirth);
		return newHoh;
	}
	@PatchMapping("/recipients/{id}")
	public HeadOfHousehold patchSingleRecipientAddress(@PathVariable() Long id, @RequestBody String newAddress) throws Exception{
		Optional<HeadOfHousehold> retrievedOptional = hohRepo.findById(id);
		HeadOfHousehold retrievedHoh;
		if(retrievedOptional.isPresent()) {
			retrievedHoh = retrievedOptional.get();
		}
		else { throw new Exception("No such Head of Household.");
		}
		Object newAddressObject = JSONParser.parseJSON(newAddress);
		JSONObject newAddressJson = (JSONObject) newAddressObject;
		String address = newAddressJson.getString("address");
		retrievedHoh.setAddress(address);
		return hohRepo.save(retrievedHoh);
		
	}
}
