package com.communitydropin.CommunityDropInBackend.integrationtests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.communitydropin.CommunityDropInBackend.HeadOfHousehold;
import com.communitydropin.CommunityDropInBackend.HeadOfHouseholdRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaEntityMappingsTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private HeadOfHouseholdRepository hohRepo;
	
	@Test
	public void shoudLoadAndSaveHoh() {
		HeadOfHousehold hoh = new HeadOfHousehold("", "", "", null, false, 0);
	}
}
