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

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.communitydropin.CommunityDropInBackend.controllers.HeadOfHouseholdController;
import com.communitydropin.CommunityDropInBackend.entities.HeadOfHousehold;
import com.communitydropin.CommunityDropInBackend.repositories.HeadOfHouseholdRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
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

	private final String NEWADDRESSJSONPATCH = "{" + "\"address\": \"345 Anywhere Street\"}";

	private final String NEWPHONENUMBERJSONPATCH = "{\"phoneNumber\": 6145551234}";
	
	private final String NEWHOUSESIZEJSONPATCH = "{\"houseSize\": 5}";

	private HeadOfHousehold johnDoe;

	private HeadOfHousehold johnDoeWithNewAddress;

	private HeadOfHousehold johnDoeWithNewPhoneNumber;

	private HeadOfHousehold johnDoeWithNewHouseSize;

	private HeadOfHousehold johnDoeWithNewDeliveryStatus;

	@Before
	public void setup() {
		testHoh = new HeadOfHousehold("", "", "", 123L, false, 2, LocalDate.of(2019, 8, 02));
		johnDoe = new HeadOfHousehold("John", "Doe", "123 Anywhere Street", 6145551212L, false, 4,
				LocalDate.parse("1995-10-08"));
		johnDoeWithNewAddress = new HeadOfHousehold("John", "Doe", "345 Nowhere Street",
				6145551212L, false, 4, LocalDate.parse("1995-10-08"));
		johnDoeWithNewPhoneNumber = new HeadOfHousehold("John", "Doe", "123 Anywhere Street",
				6145551234L, false, 4, LocalDate.parse("1995-10-08"));
		johnDoeWithNewHouseSize = new HeadOfHousehold("John", "Doe", "123 Anywhere Street", 6145551212L, false, 5,
				LocalDate.parse("1995-10-08"));
		johnDoeWithNewDeliveryStatus = new HeadOfHousehold("John", "Doe", "123 Anywhere Street", 6145551212L, true, 4,
					LocalDate.parse("1995-10-08"));
		
		
	}

	@Test
	public void fetchCollectionOfHoh() throws Exception {
		when(hohRepo.findAll(Sort.by(Sort.Direction.ASC, "lastName"))).thenReturn(Collections.singletonList(testHoh));
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
		mockMvc.perform(post("/api/recipients").contentType(MediaType.APPLICATION_JSON_UTF8).content(JOHNDOEJSONPOST))
				.andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"))
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
				.content(NEWPHONENUMBERJSONPATCH)).andExpect(status().isOk())
				.andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(content().json(mapper.writeValueAsString(johnDoeWithNewPhoneNumber)));
	}
	
	@Test
	public void patchSingleRecipientHouseSize() throws Exception {
		when(hohRepo.findById(1L)).thenReturn(Optional.of(johnDoe));
		when(hohRepo.save(any(HeadOfHousehold.class))).thenReturn(johnDoeWithNewHouseSize);
		mockMvc.perform(patch("/api/recipients/1/update-house-size").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(NEWHOUSESIZEJSONPATCH)).andExpect(status().isOk())
				.andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(content().json(mapper.writeValueAsString(johnDoeWithNewHouseSize)));
	}
	
	@Test
	public void patchSingleRecipientDeliveryStatus() throws Exception {
		when(hohRepo.findById(1L)).thenReturn(Optional.of(johnDoe));
		when(hohRepo.save(any(HeadOfHousehold.class))).thenReturn(johnDoeWithNewDeliveryStatus);
		mockMvc.perform(patch("/api/recipients/1/update-delivery-status"))
				.andExpect(status().isOk())
				.andExpect(content().json(mapper.writeValueAsString(johnDoeWithNewDeliveryStatus)));
		
	}
	
	@Test
	public void fetchCollectionOfHohSortedByFirstName() throws JsonProcessingException, Exception {
		when(hohRepo.findAll(Sort.by(Sort.Direction.ASC, "firstName"))).thenReturn(Collections.singletonList(testHoh));
		mockMvc.perform(get("/api/recipients/sortby-first-name")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testHoh)), true));
	}
	@Test
	public void fetchCollectionOfHohSortedByAddress() throws JsonProcessingException, Exception {
		when(hohRepo.findAll(Sort.by(Sort.Direction.ASC, "address"))).thenReturn(Collections.singletonList(testHoh));
		mockMvc.perform(get("/api/recipients/sortby-address")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testHoh)), true));
	}
	@Test
	public void fetchCollectionOfHohSortedByPhoneNumber() throws JsonProcessingException, Exception {
		when(hohRepo.findAll(Sort.by(Sort.Direction.ASC, "phoneNumber"))).thenReturn(Collections.singletonList(testHoh));
		mockMvc.perform(get("/api/recipients/sortby-phone-number")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testHoh)), true));
	}
	@Test
	public void fetchCollectionOfHohSortedByDeliveryStatus() throws JsonProcessingException, Exception {
		when(hohRepo.findAll(Sort.by(Sort.Direction.ASC, "deliveryStatus"))).thenReturn(Collections.singletonList(testHoh));
		mockMvc.perform(get("/api/recipients/sortby-delivery-status")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testHoh)), true));
	}
	@Test
	public void fetchCollectionOfHohSortedByHouseSize() throws JsonProcessingException, Exception {
		when(hohRepo.findAll(Sort.by(Sort.Direction.ASC, "houseSize"))).thenReturn(Collections.singletonList(testHoh));
		mockMvc.perform(get("/api/recipients/sortby-house-size")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testHoh)), true));
	}
	@Test
	public void fetchCollectionOfHohSortedByDateOfBirth() throws JsonProcessingException, Exception {
		when(hohRepo.findAll(Sort.by(Sort.Direction.ASC, "dateOfBirth"))).thenReturn(Collections.singletonList(testHoh));
		mockMvc.perform(get("/api/recipients/sortby-date-of-birth")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testHoh)), true));
	}
}