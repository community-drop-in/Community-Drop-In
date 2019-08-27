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
import java.util.List;
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

import com.communitydropin.CommunityDropInBackend.controllers.FoodOrderController;
import com.communitydropin.CommunityDropInBackend.entities.FoodOrder;
import com.communitydropin.CommunityDropInBackend.entities.Recipient;
import com.communitydropin.CommunityDropInBackend.repositories.FoodOrderRepository;
import com.communitydropin.CommunityDropInBackend.repositories.RecipientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(FoodOrderController.class)
@RunWith(SpringRunner.class)
public class FoodOrderWebLayerTest {

	private static final String FOODORDER2JSON = "{"
			+ "\"phoneNumber\": 6145551212,"
			+ "\"date\": \"2019-08-02\""
			+ "}";

	@Autowired
	MockMvc mockMvc;

	@MockBean
	RecipientRepository recipientRepo;

	@MockBean
	FoodOrderRepository foodOrderRepo;

	ObjectMapper mapper = new ObjectMapper();

	private Recipient recipient;

	private FoodOrder foodOrder;
	
	private FoodOrder foodOrder2;

	Iterable <FoodOrder> foodOrderList;

	@Before
	public void setup() {
		recipient = new Recipient("John", "Doe", "123 Anywhere Street", 6145551212L, false, 4,
				LocalDate.parse("1995-10-08"));
		recipientRepo.save(recipient);
		foodOrder = new FoodOrder(recipient, LocalDate.of(2001, 1, 1));
		foodOrderRepo.save(foodOrder);
		foodOrderList = Collections.singletonList(foodOrder);
		foodOrder2 = new FoodOrder(recipient, LocalDate.of(2019, 8, 2));
	}

	@Test
	public void shouldBeAbleToRetrieveAllFoodOrders() throws Exception {
		when(foodOrderRepo.findAll(Sort.by(Sort.Direction.ASC,"date"))).thenReturn(foodOrderList);
		mockMvc.perform(get("/api/food-orders")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().json(mapper.writeValueAsString(foodOrderList), true));
	}

	@Test
	public void shouldBeAbleToRetrieveSingleFoodOrder() throws Exception {
		when(foodOrderRepo.findById(1L)).thenReturn(Optional.of(foodOrder));
		mockMvc.perform(get("/api/food-orders/1")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().json(mapper.writeValueAsString(foodOrder), true));
	}

	@Test
	public void shouldBeAbleToPostSingleFoodOrder() throws Exception {
		when(recipientRepo.findAll(Sort.by(Sort.Direction.ASC, "lastName"))).thenReturn(Collections.singletonList(recipient));
		when(recipientRepo.findByPhoneNumber(6145551212L)).thenReturn(recipient);
		mockMvc.perform(post("/api/food-orders").contentType(MediaType.APPLICATION_JSON_UTF8)
			.content(FOODORDER2JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(recipient)), true));
	}
}
