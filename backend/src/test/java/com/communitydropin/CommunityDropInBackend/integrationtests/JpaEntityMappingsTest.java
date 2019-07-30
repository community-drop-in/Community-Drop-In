package com.communitydropin.CommunityDropInBackend.integrationtests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import repositories.RecipientRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaEntityMappingsTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private RecipientRepository recipientRepo;

	@Test
	public void shouldSaveAndLoadARecipient() {
		HeadOfHousehold testHead = new HeadOfHousehold("test name", "7/29/2019");
		recipientRepo.save(testHead);
	}
}
