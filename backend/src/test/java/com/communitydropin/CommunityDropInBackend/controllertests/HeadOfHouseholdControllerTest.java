package com.communitydropin.CommunityDropInBackend.controllertests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import java.util.Collections;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.communitydropin.CommunityDropInBackend.HeadOfHousehold;
import com.communitydropin.CommunityDropInBackend.HeadOfHouseholdRepository;
import com.communitydropin.CommunityDropInBackend.controllers.HeadOfHouseholdController;

public class HeadOfHouseholdControllerTest {
	
	@InjectMocks
	private HeadOfHouseholdController underTest;
	
	@Mock
	private HeadOfHouseholdRepository hohRepo;
	
	@Mock
	private HeadOfHousehold hoh;
	
	@Before
	public void setup () {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void hohControllerShouldReturnAllHohs () {
		when(hohRepo.findAll()).thenReturn(Collections.singletonList(hoh));
		Iterable<HeadOfHousehold> hohs = underTest.retrieveAllRecipients();
		assertThat(hohs, contains(hoh));
		
	}
	
	@Test
	public void hohControllerShouldReturnSingleHoh() {
		when(hohRepo.findById(1L)).thenReturn(Optional.of(hoh));
		HeadOfHousehold retrievedHoh = underTest.retrieveSingleRecipient(1L);
		assertThat(retrievedHoh, is(hoh));
	}
	@Test
	public void hohControllerShouldPostSingleHoh() {
		when(hohRepo.save(any(HeadOfHousehold.class))).thenReturn(hoh);
	}

}
