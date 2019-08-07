package com.communitydropin.CommunityDropInBackend;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.communitydropin.CommunityDropInBackend.entities.FoodOrder;
import com.communitydropin.CommunityDropInBackend.entities.HeadOfHousehold;
import com.communitydropin.CommunityDropInBackend.repositories.FoodOrderRepository;
import com.communitydropin.CommunityDropInBackend.repositories.HeadOfHouseholdRepository;

@Service
public class Initializer implements CommandLineRunner {
	@Autowired
	HeadOfHouseholdRepository hohRepo;
	
	@Autowired
	FoodOrderRepository foodOrderRepo;

	@Override
	public void run(String... args) throws Exception {
		populateHoh();
		populateOrders();
	}

	private void populateHoh() {
		HeadOfHousehold hoh = new HeadOfHousehold("Joe", "Schmmo", "1770 Pennsylvania Ave", 3304529259L, true, 3,
				LocalDate.of(1995, 10, 7));
		hohRepo.save(hoh);
		HeadOfHousehold johnDoe = new HeadOfHousehold("John", "Doe", "771 Ainavlysnnep Ave", 3304529260L, false, 1,
				LocalDate.of(1994, 10, 7));
		hohRepo.save(johnDoe);
		HeadOfHousehold martinFowler = new HeadOfHousehold("Martin", "Fowler", "5555 Fake Ave", 6144462687L, false, 2,
				LocalDate.of(1983, 4, 6));
		hohRepo.save(martinFowler);
		HeadOfHousehold robbieRotten = new HeadOfHousehold("Robbie", "Rotten", "6666 Rotten Rd", 9876543210L, false, 3,
				LocalDate.of(1984, 12, 21));
		hohRepo.save(robbieRotten);
		
	}
	
	private void populateOrders() {
		FoodOrder order = new FoodOrder(hohRepo.findByPhoneNumber(3304529259L), LocalDate.of(2019, 8, 2));
		foodOrderRepo.save(order);
	}

}
