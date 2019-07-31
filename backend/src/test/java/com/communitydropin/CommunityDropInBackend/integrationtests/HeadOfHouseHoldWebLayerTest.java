package com.communitydropin.CommunityDropInBackend.integrationtests;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

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

	@Before
	public void setup() {
		testHoh = new HeadOfHousehold("", "", "", 123L, false, 2, LocalDate.of(2019, 8, 02));
	}

	@Test
	public void fetchCollectionOfHoh() throws Exception {
		when(hohRepo.findAll()).thenReturn(Collections.singletonList(testHoh));
		mockMvc.perform(get("/api/receipients")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testHoh)), true));
	}

//	@Test
//	public void fetchSingleHoh() throws Exception {
//		when(hohRepo.findById(1L)).thenReturn(Optional.of(testHoh));
//		mockMvc.perform(get("/api/receipients/1")).andDo(print()).andExpect(status().isOk())
//				.andExpect(content().contentType("application/json;charset=UTF-8"))
//				.andExpect(content().json(mapper.writeValueAsString(testHoh), true));
//	}
//
//	@Test
//	public void addHoh() throws Exception {
//		when(hohRepo.save(any(HeadOfHousehold.class))).thenReturn(testHoh);
//		when(hohRepo.findAll()).thenReturn(Collections.singletonList(testHoh));
//		mockMvc.perform(post("/api/add-receipient").contentType(MediaType.APPLICATION_JSON_UTF8)
//				.content(mapper.writeValueAsString(testHoh))).andExpect(status().isOk())
//				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testHoh))));
//	}

}
