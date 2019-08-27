package com.communitydropin.CommunityDropInBackend.controllertests;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.communitydropin.CommunityDropInBackend.controllers.QueuePageController;
import com.communitydropin.CommunityDropInBackend.entities.FoodOrder;
import com.communitydropin.CommunityDropInBackend.entities.Recipient;
import com.communitydropin.CommunityDropInBackend.repositories.FoodOrderRepository;
import com.communitydropin.CommunityDropInBackend.repositories.RecipientRepository;

public class QueuePageControllerTest {

	@InjectMocks
	private QueuePageController underTest;
	
	@Mock
	private FoodOrderRepository orderRepo;
	
	@Mock
	private RecipientRepository recipientRepo;
	
	@Mock 
	private Recipient recipient;
	
	@Mock 
	private Recipient recipient2;
	
	@Mock
	private FoodOrder order;
	
	@Mock
	private FoodOrder order2;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		recipient = new Recipient("John", "Doe", "123 Anywhere Street", 6145551212L, false, 4,
				LocalDate.parse("1995-10-08"));
		recipientRepo.save(recipient);
		recipient2 = new Recipient("Jane", "Dio", "123 Anywhere Ave", 6145551212L, false, 2,
				LocalDate.parse("1995-11-08"));
		recipientRepo.save(recipient2);
		order = new FoodOrder(recipient, LocalDate.of(2001, 1, 1));
		orderRepo.save(order);
		order2 = new FoodOrder(recipient, LocalDate.of(2001, 1, 2));
		orderRepo.save(order2);
	}
	
	@Test
	public void queuePageControllerShouldReturnAllOrders() {
		when(orderRepo.findAll()).thenReturn(Collections.singletonList(order));
		Iterable<FoodOrder> orders = underTest.getOrders();
		assertThat(orders, contains(order));
	}
	
	@Test
	public void queuePageControllerShouldDeleteSingleOrder() {
		when(orderRepo.findAll()).thenReturn(Collections.singletonList(order2));
		Iterable<FoodOrder> orders = underTest.deleteOrder(order.getId());
		verify(orderRepo).deleteById(order.getId());
		assertThat(orders, not(contains(order)));
	}
	
}
