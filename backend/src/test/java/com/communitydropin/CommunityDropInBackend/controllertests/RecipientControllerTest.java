package com.communitydropin.CommunityDropInBackend.controllertests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;

import com.communitydropin.CommunityDropInBackend.controllers.RecipientController;
import com.communitydropin.CommunityDropInBackend.entities.Recipient;
import com.communitydropin.CommunityDropInBackend.repositories.RecipientRepository;

public class RecipientControllerTest {

	@InjectMocks
	private RecipientController underTest;

	@Mock
	private RecipientRepository recipientRepo;

	@Mock
	private Recipient recipient;

	private final String JOHNDOEJSONPOST = "{" + "\"firstName\": \"John\"," + "\"lastName\": \"Doe\","
			+ "\"address\": \"123 Anywhere Street\"," + "\"phoneNumber\": 6145551212," + "\"deliveryStatus\": false,"
			+ "\"houseSize\": 4," + "\"dateOfBirth\": \"1995-10-08\"" + "}";

	private Recipient johnDoe = new Recipient("John", "Doe", "123 Anywhere Street", 6145551212L, false, 4,
			LocalDate.parse("1995-10-08"));

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void recipientControllerShouldReturnAllRecipients() {
		when(recipientRepo.findAll(Sort.by(Sort.Direction.ASC, "lastName"))).thenReturn(Collections.singletonList(recipient));
		Iterable<Recipient> recipients = underTest.retrieveAllRecipientsSortByLastName();
		assertThat(recipients, contains(recipient));

	}

	@Test
	public void recipientControllerShouldReturnSingleRecipient() {
		when(recipientRepo.findById(1L)).thenReturn(Optional.of(recipient));
		Recipient retrievedRecipient = underTest.retrieveSingleRecipient(1L);
		assertThat(retrievedRecipient, is(recipient));
	}

	@Test
	public void recipientControllerShouldPostSingleRecipient() throws JSONException {
		when(recipientRepo.findAll(Sort.by(Sort.Direction.ASC, "lastName"))).thenReturn(Collections.singletonList(johnDoe));
		Iterable <Recipient> postSingleRecipientReturn = underTest.postSingleRecipient(JOHNDOEJSONPOST);
		verify(recipientRepo).save(johnDoe);
		assertThat(postSingleRecipientReturn, contains(johnDoe));
	}

}
