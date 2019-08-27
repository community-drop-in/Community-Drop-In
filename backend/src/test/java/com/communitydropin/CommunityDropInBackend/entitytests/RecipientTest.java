package com.communitydropin.CommunityDropInBackend.entitytests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.time.LocalDate;

import org.junit.Test;

import com.communitydropin.CommunityDropInBackend.entities.Recipient;

public class RecipientTest {
	
	@Test
	public void shouldChangeHeadOfHouseholdDeliveryStatusFromFalseToTrue() {
		Recipient underTest = new Recipient("John", "Doe", "123 Anywhere Street", 6145551212L, false, 4,
				LocalDate.parse("1995-10-08"));
		underTest.changeDeliveryStatus();
		assertThat(underTest.isDeliveryStatus(), is(true));
	}
	
	@Test
	public void shouldChangeHeadOfHouseholdDeliveryStatusFromTrueToFalse() {
		Recipient underTest2 = new Recipient("John", "Doe", "123 Anywhere Street", 6145551212L, true, 4,
				LocalDate.parse("1995-10-08"));
		underTest2.changeDeliveryStatus();
		assertThat(underTest2.isDeliveryStatus(), is(false));
	}

}
