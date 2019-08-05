package com.communitydropin.CommunityDropInBackend.integrationtests;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.communitydropin.CommunityDropInBackend.FoodOrder;
import com.communitydropin.CommunityDropInBackend.FoodOrderRepository;
import com.communitydropin.CommunityDropInBackend.HeadOfHousehold;
import com.communitydropin.CommunityDropInBackend.HeadOfHouseholdRepository;

@WebMvcTest(FoodOrder.class)
@RunWith(SpringRunner.class)
public class FoodOrderWebLayerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	HeadOfHouseholdRepository hohRepo;
	
	@MockBean
	FoodOrderRepository foodOrderRepo;
	
	private HeadOfHousehold hoh;
	
	private FoodOrder foodOrder;
	
	List<FoodOrder> foodOrderList;
	
	@Before
	public void setup() {
		hoh = new HeadOfHousehold("John", "Doe", "123 Anywhere Street", 6145551212L, false, 4,
				LocalDate.parse("1995-10-08"));
		foodOrder = new FoodOrder(hoh, LocalDate.of(2001, 1, 1));
		foodOrderList = Collections.singletonList(foodOrder);
	}
	
	@Test
	public void shouldBeAbleToRetrieveAllFoodOrders() throws Exception {
		when(foodOrderRepo.findAll()).thenReturn(foodOrderList);
		mockMvc.perform(get("/api/food-orders")).andDo(print()).andExpect(status().isOk());
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//				.andExpect(content().json(mapper.writeValueAsString(foodOrderList), true))
	}
}
