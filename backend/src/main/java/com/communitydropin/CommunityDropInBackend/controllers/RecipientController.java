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

import com.communitydropin.CommunityDropInBackend.entities.Recipient;
import com.communitydropin.CommunityDropInBackend.repositories.RecipientRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RecipientController {

	@Autowired
	RecipientRepository recipientRepo;

	@GetMapping("/recipients")
	public Iterable<Recipient> retrieveAllRecipientsSortByLastName() {
		return recipientRepo.findAll(Sort.by(Sort.Direction.ASC, "lastName"));
	}

	@GetMapping("/recipients/sortby-first-name")
	public Iterable<Recipient> retrieveAllRecipientsSortByFirstName() {
		return recipientRepo.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
	}

	@GetMapping("/recipients/sortby-address")
	public Iterable<Recipient> retrieveAllRecipientsSortByAddress() {
		return recipientRepo.findAll(Sort.by(Sort.Direction.ASC, "address"));
	}

	@GetMapping("/recipients/sortby-phone-number")
	public Iterable<Recipient> retrieveAllRecipientsSortByPhoneNumber() {
		return recipientRepo.findAll(Sort.by(Sort.Direction.ASC, "phoneNumber"));
	}

	@GetMapping("/recipients/sortby-delivery-status")
	public Iterable<Recipient> retrieveAllRecipientsSortByDeliveryStatus() {
		return recipientRepo.findAll(Sort.by(Sort.Direction.ASC, "deliveryStatus"));
	}

	@GetMapping("/recipients/sortby-house-size")
	public Iterable<Recipient> retrieveAllRecipientsSortByHouseSize() {
		return recipientRepo.findAll(Sort.by(Sort.Direction.ASC, "houseSize"));
	}

	@GetMapping("/recipients/sortby-date-of-birth")
	public Iterable<Recipient> retrieveAllRecipientsSortByDateOfBirth() {
		return recipientRepo.findAll(Sort.by(Sort.Direction.ASC, "dateOfBirth"));
	}

	@GetMapping("/recipients/{id}")
	public Recipient retrieveSingleRecipient(@PathVariable Long id) {

		return recipientRepo.findById(id).get();
	}

	@PostMapping("/recipients")
	public Iterable<Recipient> postSingleRecipient(@RequestBody String recipientDataString) throws JSONException {
		Recipient newRecipient = makeRecipientFromDataJson(recipientDataString);
		recipientRepo.save(newRecipient);
		return recipientRepo.findAll(Sort.by(Sort.Direction.ASC, "lastName"));
	}

	@PatchMapping("/recipients/{id}/update-address")
	public Recipient patchSingleRecipientAddress(@PathVariable() Long id, @RequestBody String newAddress)
			throws Exception {
		Recipient retrievedRecipient = idToRecipientJson(id);
		Object newAddressObject = JSONParser.parseJSON(newAddress);
		JSONObject newAddressJson = (JSONObject) newAddressObject;
		String address = newAddressJson.getString("address");
		retrievedRecipient.setAddress(address);
		return recipientRepo.save(retrievedRecipient);

	}

	@PatchMapping("/recipients/{id}/update-phone-number")
	public Recipient patchSingleRecipientPhoneNumber(@PathVariable() Long id, @RequestBody String newPhoneNumber)
			throws Exception {
		Recipient retrievedRecipient = idToRecipientJson(id);
		Object newPhoneNumberObject = JSONParser.parseJSON(newPhoneNumber);
		JSONObject newPhoneNumberJson = (JSONObject) newPhoneNumberObject;
		Long phoneNumber = newPhoneNumberJson.getLong("phoneNumber");
		retrievedRecipient.setPhoneNumber(phoneNumber);
		return recipientRepo.save(retrievedRecipient);

	}

	@PatchMapping("/recipients/{id}/update-house-size")
	public Recipient patchSingleRecipientHouseSize(@PathVariable Long id, @RequestBody String newHouseSize)
			throws Exception {
		Recipient retrievedRecipient = idToRecipientJson(id);
		Object newHouseSizeObject = JSONParser.parseJSON(newHouseSize);
		JSONObject newHouseSizeJson = (JSONObject) newHouseSizeObject;
		int houseSize = newHouseSizeJson.getInt("houseSize");
		retrievedRecipient.setHouseSize(houseSize);
		return recipientRepo.save(retrievedRecipient);
	}

	@PatchMapping("/recipients/{id}/update-delivery-status")
	public Recipient patchSingleRecipientDeliveryStatus(@PathVariable Long id) throws Exception {
		Recipient retrievedRecipient = idToRecipientJson(id);
		retrievedRecipient.changeDeliveryStatus();
		return recipientRepo.save(retrievedRecipient);

	}

	private Recipient makeRecipientFromDataJson(String recipientDataString) throws JSONException {
		Object recipientDataObject = JSONParser.parseJSON(recipientDataString);
		JSONObject recipientDataJson = (JSONObject) recipientDataObject;
		String firstName = recipientDataJson.getString("firstName");
		String lastName = recipientDataJson.getString("lastName");
		String address = recipientDataJson.getString("address");
		Long phoneNumber = recipientDataJson.getLong("phoneNumber");
		boolean deliveryStatus = recipientDataJson.getBoolean("deliveryStatus");
		int houseSize = recipientDataJson.getInt("houseSize");
		String dateOfBirthString = recipientDataJson.getString("dateOfBirth");
		LocalDate dateOfBirth = LocalDate.parse(dateOfBirthString);
		Recipient newRecipient;
		newRecipient = new Recipient(firstName, lastName, address, phoneNumber, deliveryStatus, houseSize, dateOfBirth);
		return newRecipient;
	}

	private Recipient idToRecipientJson(Long id) throws Exception {
		Optional<Recipient> retrievedOptional = recipientRepo.findById(id);
		Recipient retrievedRecipient;
		if (retrievedOptional.isPresent()) {
			retrievedRecipient = retrievedOptional.get();

		} else {
			throw new Exception("No such recipient");
		}
		return retrievedRecipient;
	}
}
