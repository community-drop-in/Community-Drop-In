package com.communitydropin.CommunityDropInBackend.integrationtests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.communitydropin.CommunityDropInBackend.FoodOrder;
import com.communitydropin.CommunityDropInBackend.HeadOfHousehold;
import com.communitydropin.CommunityDropInBackend.HeadOfHouseholdRepository;
import com.communitydropin.CommunityDropInBackend.FoodOrderRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaEntityMappingsTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private HeadOfHouseholdRepository hohRepo;
	
	@Autowired
	private FoodOrderRepository foodOrderRepo;
		
	private HeadOfHousehold hoh;
	private FoodOrder order;
	
	@Before
	public void setup () {
		hoh = new HeadOfHousehold("", "", "", 22332L, false, 5, LocalDate.of(2013, 1, 2));
		hohRepo.save(hoh);
		flushAndClearEntityManager();
	}
	
	@Test
	public void shoudLoadAndSaveHoh() {
		HeadOfHousehold foundHoh = hohRepo.findById(hoh.getId()).get();
		assertThat(foundHoh, is(hoh));
	}
	@Test
	public void shouldLoadAndSaveOrder() {
		FoodOrder foundOrder = foodOrderRepo.findById(order.getId()).get();
		assertThat(foundOrder, is(order));
	}

	private void flushAndClearEntityManager() {
		entityManager.flush();
		entityManager.clear();
	}
}
