package com.communitydropin.CommunityDropInBackend.controllertests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

import org.json.JSONException;
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

	private final String JOHNDOEJSONPOST = "{" + "\"firstName\": \"John\"," + "\"lastName\": \"Doe\","
			+ "\"address\": \"123 Anywhere Street\"," + "\"phoneNumber\": 6145551212," + "\"deliveryStatus\": false,"
			+ "\"houseSize\": 4," + "\"dateOfBirth\": \"1995-10-08\"" + "}";

	private HeadOfHousehold johnDoe = new HeadOfHousehold("John", "Doe", "123 Anywhere Street", 6145551212L, false, 4,
			LocalDate.parse("1995-10-08"));

	private HeadOfHousehold johnDoe6145551234 = new HeadOfHousehold("John", "Doe", "123 Anywhere Street", 6145551234L, false, 4,
			LocalDate.parse("1995-10-08"));;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void hohControllerShouldReturnAllHohs() {
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
	public void hohControllerShouldPostSingleHoh() throws JSONException {
		when(hohRepo.save(any(HeadOfHousehold.class))).thenReturn(johnDoe);
		HeadOfHousehold postSingleRecipientReturn = underTest.postSingleRecipient(JOHNDOEJSONPOST);
		verify(hohRepo).save(johnDoe);
		assertThat(postSingleRecipientReturn, is(johnDoe));
	}

	@Test
	public void hohControllerShouldPatchSinglePhoneNumber() throws JSONException {
		when(hohRepo.save(johnDoe6145551234)).thenReturn(johnDoe6145551234);
		underTest.postSingleRecipient(JOHNDOEJSONPOST);
		Long id = johnDoe.getId();
		assertThat(underTest.patchSingleRecipientPhoneNumber(id , 6145551234L), is(johnDoe6145551234));
		
	}

}
