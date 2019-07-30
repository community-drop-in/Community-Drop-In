package com.communitydropin.CommunityDropInBackend.integrationtests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.GregorianCalendar;

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
		Calendar testCalendar = new GregorianCalendar(2013,1,2);
		HeadOfHousehold hoh = new HeadOfHousehold("", "", "", 22332L, false, 5, testCalendar);
		hohRepo.save(hoh);
		entityManager.flush();
		entityManager.clear();
		
		HeadOfHousehold foundHoh = hohRepo.findById(hoh.getId()).get();
		assertThat(foundHoh, is(hoh));
	}
}
