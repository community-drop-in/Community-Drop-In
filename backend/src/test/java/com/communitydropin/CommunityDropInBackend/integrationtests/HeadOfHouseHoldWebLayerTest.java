package com.communitydropin.CommunityDropInBackend.integrationtests;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.communitydropin.CommunityDropInBackend.HeadOfHousehold;
import com.communitydropin.CommunityDropInBackend.HeadOfHouseholdRepository;
import com.communitydropin.CommunityDropInBackend.controllers.HeadOfHouseholdController;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(HeadOfHouseholdController.class)
@RunWith(SpringRunner.class)
public class HeadOfHouseHoldWebLayerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	HeadOfHouseholdRepository hohRepo;

	private HeadOfHousehold testHoh;
	private ObjectMapper mapper = new ObjectMapper();
	
	private final String JOHNDOEJSONPOST = "{" + "\"firstName\": \"John\"," + "\"lastName\": \"Doe\","
			+ "\"address\": \"123 Anywhere Street\"," + "\"phoneNumber\": 6145551212," + "\"deliveryStatus\": false,"
			+ "\"houseSize\": 4," + "\"dateOfBirth\": \"1995-10-08\"" + "}";
	
	private final String NEWADDRESSJSONPATCH = "{"
			+ "\"address\": \"345 Anywhere Street\"}";

	private HeadOfHousehold johnDoe = new HeadOfHousehold("John", "Doe", "123 Anywhere Street", 6145551212L, false, 4,
			LocalDate.parse("1995-10-08"));

	private HeadOfHousehold johnDoe6145551234 = new HeadOfHousehold("John", "Doe", "123 Anywhere Street", 6145551234L, false, 4,
			LocalDate.parse("1995-10-08"));

	private HeadOfHousehold johnDoeWithNewAddress = new HeadOfHousehold("John", "Doe", "345 Nowhere Street", 6145551212L, false, 4,
			LocalDate.parse("1995-10-08"));

	private HeadOfHousehold johnDoeWithNewPhoneNumber = new HeadOfHousehold("John", "Doe", "123 Anywhere Street", 6145551234L, false, 4,
			LocalDate.parse("1995-10-08"));

	private final String NEWPHONENUMBERJSONPATCH = "{\"phoneNumber\": 6145551234}";
	

	@Before
	public void setup() {
		testHoh = new HeadOfHousehold("", "", "", 123L, false, 2, LocalDate.of(2019, 8, 02));
	}

	@Test
	public void fetchCollectionOfHoh() throws Exception {
		when(hohRepo.findAll()).thenReturn(Collections.singletonList(testHoh));
		mockMvc.perform(get("/api/recipients")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testHoh)), true));
	}

	@Test
	public void fetchSingleHoh() throws Exception {
		when(hohRepo.findById(1L)).thenReturn(Optional.of(testHoh));
		mockMvc.perform(get("/api/recipients/1")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().json(mapper.writeValueAsString(testHoh), true));
	}

	@Test
	public void postSingleRecipient() throws Exception {
		when(hohRepo.save(any(HeadOfHousehold.class))).thenReturn(johnDoe);
		mockMvc.perform(post("/api/recipients").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(JOHNDOEJSONPOST)).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(content().json(mapper.writeValueAsString(johnDoe)));
	}
	
	@Test
	public void patchSingleRecipientAddress() throws Exception {
		when(hohRepo.findById(1L)).thenReturn(Optional.of(johnDoe));
		when(hohRepo.save(any(HeadOfHousehold.class))).thenReturn(johnDoeWithNewAddress);
		mockMvc.perform(patch("/api/recipients/1/update-address").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(NEWADDRESSJSONPATCH)).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(content().json(mapper.writeValueAsString(johnDoeWithNewAddress)));
	}
	
	@Test
	public void patchSingleRecipientPhoneNumber() throws Exception {
		when(hohRepo.findById(1L)).thenReturn(Optional.of(johnDoe));
		when(hohRepo.save(any(HeadOfHousehold.class))).thenReturn(johnDoeWithNewPhoneNumber);
		mockMvc.perform(patch("/api/recipients/1/update-phone-number").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(NEWPHONENUMBERJSONPATCH)).andExpect(status().isOk());
	}
}