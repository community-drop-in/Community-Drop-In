package com.communitydropin.CommunityDropInBackend.controllers;

import java.time.LocalDate;
import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.communitydropin.CommunityDropInBackend.entities.HeadOfHousehold;
import com.communitydropin.CommunityDropInBackend.repositories.HeadOfHouseholdRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class HeadOfHouseholdController {

	@Autowired
	HeadOfHouseholdRepository hohRepo;

	@GetMapping("/recipients")
	public Iterable<HeadOfHousehold> retrieveAllRecipientsSortByLastName() {
		return hohRepo.findAll(Sort.by(Sort.Direction.ASC, "lastName"));
	}

	@GetMapping("/recipients/sortby-first-name")
	public Iterable<HeadOfHousehold> retrieveAllRecipientsSortByFirstName() {
		return hohRepo.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
	}

	@GetMapping("/recipients/sortby-address")
	public Iterable<HeadOfHousehold> retrieveAllRecipientsSortByAddress() {
		return hohRepo.findAll(Sort.by(Sort.Direction.ASC, "address"));
	}

	@GetMapping("/recipients/sortby-phone-number")
	public Iterable<HeadOfHousehold> retrieveAllRecipientsSortByPhoneNumber() {
		return hohRepo.findAll(Sort.by(Sort.Direction.ASC, "phoneNumber"));
	}

	@GetMapping("/recipients/sortby-delivery-status")
	public Iterable<HeadOfHousehold> retrieveAllRecipientsSortByDeliveryStatus() {
		return hohRepo.findAll(Sort.by(Sort.Direction.ASC, "deliveryStatus"));
	}

	@GetMapping("/recipients/sortby-house-size")
	public Iterable<HeadOfHousehold> retrieveAllRecipientsSortByHouseSize() {
		return hohRepo.findAll(Sort.by(Sort.Direction.ASC, "houseSize"));
	}

	@GetMapping("/recipients/sortby-date-of-birth")
	public Iterable<HeadOfHousehold> retrieveAllRecipientsSortByDateOfBirth() {
		return hohRepo.findAll(Sort.by(Sort.Direction.ASC, "dateOfBirth"));
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

	@PatchMapping("/recipients/{id}/update-address")
	public HeadOfHousehold patchSingleRecipientAddress(@PathVariable() Long id, @RequestBody String newAddress)
			throws Exception {
		HeadOfHousehold retrievedHoh = idToHohJson(id);
		Object newAddressObject = JSONParser.parseJSON(newAddress);
		JSONObject newAddressJson = (JSONObject) newAddressObject;
		String address = newAddressJson.getString("address");
		retrievedHoh.setAddress(address);
		return hohRepo.save(retrievedHoh);

	}

	@PatchMapping("/recipients/{id}/update-phone-number")
	public HeadOfHousehold patchSingleRecipientPhoneNumber(@PathVariable() Long id, @RequestBody String newPhoneNumber)
			throws Exception {
		HeadOfHousehold retrievedHoh = idToHohJson(id);
		Object newPhoneNumberObject = JSONParser.parseJSON(newPhoneNumber);
		JSONObject newPhoneNumberJson = (JSONObject) newPhoneNumberObject;
		Long phoneNumber = newPhoneNumberJson.getLong("phoneNumber");
		retrievedHoh.setPhoneNumber(phoneNumber);
		return hohRepo.save(retrievedHoh);

	}

	@PatchMapping("/recipients/{id}/update-house-size")
	public HeadOfHousehold patchSingleRecipientHouseSize(@PathVariable Long id, @RequestBody String newHouseSize)
			throws Exception {
		HeadOfHousehold retrievedHoh = idToHohJson(id);
		Object newHouseSizeObject = JSONParser.parseJSON(newHouseSize);
		JSONObject newHouseSizeJson = (JSONObject) newHouseSizeObject;
		int houseSize = newHouseSizeJson.getInt("houseSize");
		retrievedHoh.setHouseSize(houseSize);
		return hohRepo.save(retrievedHoh);
	}

	@PatchMapping("/recipients/{id}/update-delivery-status")
	public HeadOfHousehold patchSingleRecipientDeliveryStatus(@PathVariable Long id) throws Exception {
		HeadOfHousehold retrievedHoh = idToHohJson(id);
		retrievedHoh.changeDeliveryStatus();
		return hohRepo.save(retrievedHoh);

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

	private HeadOfHousehold idToHohJson(Long id) throws Exception {
		Optional<HeadOfHousehold> retrievedOptional = hohRepo.findById(id);
		HeadOfHousehold retrievedHoh;
		if (retrievedOptional.isPresent()) {
			retrievedHoh = retrievedOptional.get();

		} else {
			throw new Exception("No such Head of Household");
		}
		return retrievedHoh;
	}
}
