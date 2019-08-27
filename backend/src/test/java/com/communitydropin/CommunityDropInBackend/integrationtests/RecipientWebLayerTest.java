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

import com.communitydropin.CommunityDropInBackend.controllers.RecipientController;
import com.communitydropin.CommunityDropInBackend.entities.Recipient;
import com.communitydropin.CommunityDropInBackend.repositories.RecipientRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(RecipientController.class)
@RunWith(SpringRunner.class)
public class RecipientWebLayerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	RecipientRepository recipientRepo;

	private Recipient testRecipient;
	private ObjectMapper mapper = new ObjectMapper();

	private final String JOHNDOEJSONPOST = "{" + "\"firstName\": \"John\"," + "\"lastName\": \"Doe\","
			+ "\"address\": \"123 Anywhere Street\"," + "\"phoneNumber\": 6145551212," + "\"deliveryStatus\": false,"
			+ "\"houseSize\": 4," + "\"dateOfBirth\": \"1995-10-08\"" + "}";

	private final String NEWADDRESSJSONPATCH = "{" + "\"address\": \"345 Anywhere Street\"}";

	private final String NEWPHONENUMBERJSONPATCH = "{\"phoneNumber\": 6145551234}";
	
	private final String NEWHOUSESIZEJSONPATCH = "{\"houseSize\": 5}";

	private Recipient johnDoe;

	private Recipient johnDoeWithNewAddress;

	private Recipient johnDoeWithNewPhoneNumber;

	private Recipient johnDoeWithNewHouseSize;

	private Recipient johnDoeWithNewDeliveryStatus;

	@Before
	public void setup() {
		testRecipient = new Recipient("", "", "", 123L, false, 2, LocalDate.of(2019, 8, 02));
		johnDoe = new Recipient("John", "Doe", "123 Anywhere Street", 6145551212L, false, 4,
				LocalDate.parse("1995-10-08"));
		johnDoeWithNewAddress = new Recipient("John", "Doe", "345 Nowhere Street",
				6145551212L, false, 4, LocalDate.parse("1995-10-08"));
		johnDoeWithNewPhoneNumber = new Recipient("John", "Doe", "123 Anywhere Street",
				6145551234L, false, 4, LocalDate.parse("1995-10-08"));
		johnDoeWithNewHouseSize = new Recipient("John", "Doe", "123 Anywhere Street", 6145551212L, false, 5,
				LocalDate.parse("1995-10-08"));
		johnDoeWithNewDeliveryStatus = new Recipient("John", "Doe", "123 Anywhere Street", 6145551212L, true, 4,
					LocalDate.parse("1995-10-08"));
		
		
	}

	@Test
	public void fetchCollectionOfRecipient() throws Exception {
		when(recipientRepo.findAll(Sort.by(Sort.Direction.ASC, "lastName"))).thenReturn(Collections.singletonList(testRecipient));
		mockMvc.perform(get("/api/recipients")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testRecipient)), true));
	}

	@Test
	public void fetchSingleRecipient() throws Exception {
		when(recipientRepo.findById(1L)).thenReturn(Optional.of(testRecipient));
		mockMvc.perform(get("/api/recipients/1")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().json(mapper.writeValueAsString(testRecipient), true));
	}

	@Test
	public void postSingleRecipient() throws Exception {
		when(recipientRepo.findAll(Sort.by(Sort.Direction.ASC, "lastName"))).thenReturn(Collections.singletonList(johnDoe));
		mockMvc.perform(post("/api/recipients").contentType(MediaType.APPLICATION_JSON_UTF8).content(JOHNDOEJSONPOST))
				.andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(johnDoe)), true));
	}

	@Test
	public void patchSingleRecipientAddress() throws Exception {
		when(recipientRepo.findById(1L)).thenReturn(Optional.of(johnDoe));
		when(recipientRepo.save(any(Recipient.class))).thenReturn(johnDoeWithNewAddress);
		mockMvc.perform(patch("/api/recipients/1/update-address").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(NEWADDRESSJSONPATCH)).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(content().json(mapper.writeValueAsString(johnDoeWithNewAddress)));
	}

	@Test
	public void patchSingleRecipientPhoneNumber() throws Exception {
		when(recipientRepo.findById(1L)).thenReturn(Optional.of(johnDoe));
		when(recipientRepo.save(any(Recipient.class))).thenReturn(johnDoeWithNewPhoneNumber);
		mockMvc.perform(patch("/api/recipients/1/update-phone-number").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(NEWPHONENUMBERJSONPATCH)).andExpect(status().isOk())
				.andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(content().json(mapper.writeValueAsString(johnDoeWithNewPhoneNumber)));
	}
	
	@Test
	public void patchSingleRecipientHouseSize() throws Exception {
		when(recipientRepo.findById(1L)).thenReturn(Optional.of(johnDoe));
		when(recipientRepo.save(any(Recipient.class))).thenReturn(johnDoeWithNewHouseSize);
		mockMvc.perform(patch("/api/recipients/1/update-house-size").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(NEWHOUSESIZEJSONPATCH)).andExpect(status().isOk())
				.andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(content().json(mapper.writeValueAsString(johnDoeWithNewHouseSize)));
	}
	
	@Test
	public void patchSingleRecipientDeliveryStatus() throws Exception {
		when(recipientRepo.findById(1L)).thenReturn(Optional.of(johnDoe));
		when(recipientRepo.save(any(Recipient.class))).thenReturn(johnDoeWithNewDeliveryStatus);
		mockMvc.perform(patch("/api/recipients/1/update-delivery-status"))
				.andExpect(status().isOk())
				.andExpect(content().json(mapper.writeValueAsString(johnDoeWithNewDeliveryStatus)));
		
	}
	
	@Test
	public void fetchCollectionOfRecipientSortedByFirstName() throws JsonProcessingException, Exception {
		when(recipientRepo.findAll(Sort.by(Sort.Direction.ASC, "firstName"))).thenReturn(Collections.singletonList(testRecipient));
		mockMvc.perform(get("/api/recipients/sortby-first-name")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testRecipient)), true));
	}
	@Test
	public void fetchCollectionOfRecipientSortedByAddress() throws JsonProcessingException, Exception {
		when(recipientRepo.findAll(Sort.by(Sort.Direction.ASC, "address"))).thenReturn(Collections.singletonList(testRecipient));
		mockMvc.perform(get("/api/recipients/sortby-address")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testRecipient)), true));
	}
	@Test
	public void fetchCollectionOfRecipientSortedByPhoneNumber() throws JsonProcessingException, Exception {
		when(recipientRepo.findAll(Sort.by(Sort.Direction.ASC, "phoneNumber"))).thenReturn(Collections.singletonList(testRecipient));
		mockMvc.perform(get("/api/recipients/sortby-phone-number")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testRecipient)), true));
	}
	@Test
	public void fetchCollectionOfRecipientSortedByDeliveryStatus() throws JsonProcessingException, Exception {
		when(recipientRepo.findAll(Sort.by(Sort.Direction.ASC, "deliveryStatus"))).thenReturn(Collections.singletonList(testRecipient));
		mockMvc.perform(get("/api/recipients/sortby-delivery-status")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testRecipient)), true));
	}
	@Test
	public void fetchCollectionOfRecipientSortedByHouseSize() throws JsonProcessingException, Exception {
		when(recipientRepo.findAll(Sort.by(Sort.Direction.ASC, "houseSize"))).thenReturn(Collections.singletonList(testRecipient));
		mockMvc.perform(get("/api/recipients/sortby-house-size")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testRecipient)), true));
	}
	@Test
	public void fetchCollectionOfRecipientSortedByDateOfBirth() throws JsonProcessingException, Exception {
		when(recipientRepo.findAll(Sort.by(Sort.Direction.ASC, "dateOfBirth"))).thenReturn(Collections.singletonList(testRecipient));
		mockMvc.perform(get("/api/recipients/sortby-date-of-birth")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testRecipient)), true));
	}
}