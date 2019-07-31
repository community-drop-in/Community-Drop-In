package com.communitydropin.CommunityDropInBackend;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class Initializer implements CommandLineRunner {
	@Autowired
	HeadOfHouseholdRepository hohRepo;

	@Override
	public void run(String... args) throws Exception {
		populateHoh();
	}

	private void populateHoh() {
		HeadOfHousehold hoh = new HeadOfHousehold("Joe", "Schmmo", "1770 Pennsylvania Ave", 3304529259L, true, 3,
				LocalDate.of(1995, 10, 7));
		hohRepo.save(hoh);
	}

}
