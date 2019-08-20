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
		HeadOfHousehold hoh1 = new HeadOfHousehold("Isaac", "Kim", "1770 Pennsylvania Ave", 3305551111L, true, 2,
				LocalDate.of(1990, 5, 7));
		hohRepo.save(hoh1);
		HeadOfHousehold hoh2 = new HeadOfHousehold("Kai", "Hennacy", "1771 Connecticut Ave", 3305552222L, false, 1,
				LocalDate.of(1998, 5, 21));
		hohRepo.save(hoh2);
		HeadOfHousehold hoh3 = new HeadOfHousehold("Brandon", "Cox", "1772 Ohio Dr", 3305553333L, false, 1,
				LocalDate.of(1993, 10, 6));
		hohRepo.save(hoh3);
		HeadOfHousehold hoh4 = new HeadOfHousehold("Matt", "Laine", "1773 Indiana St", 3305554444L, false, 5,
				LocalDate.of(1992, 8, 1));
		hohRepo.save(hoh4);
		HeadOfHousehold hoh5 = new HeadOfHousehold("Don", "Hamilton III", "1774 Kentucky Rd", 3305555555L, false, 2,
				LocalDate.of(1985, 11, 12));
		hohRepo.save(hoh5);
		HeadOfHousehold hoh6 = new HeadOfHousehold("Ben", "Williams", "1775 West Virginia Ave", 3305556666L, false, 3,
				LocalDate.of(1982, 7, 7));
		hohRepo.save(hoh6);
		HeadOfHousehold hoh7 = new HeadOfHousehold("Lacey", "Nichols", "1776 New York Ave", 3305557777L, false, 2,
				LocalDate.of(1990, 4, 4));
		hohRepo.save(hoh7);
		HeadOfHousehold hoh8 = new HeadOfHousehold("Kendra", "Reynolds", "1777 Rhode Island Ct", 3305558888L, false, 2,
				LocalDate.of(1990,  5, 5));
		hohRepo.save(hoh8);
		
	}
	
	private void populateOrders() {
		FoodOrder order1 = new FoodOrder(hohRepo.findByPhoneNumber(3305552222L), LocalDate.now());
		foodOrderRepo.save(order1);
		FoodOrder order2 = new FoodOrder(hohRepo.findByPhoneNumber(3305556666L), LocalDate.now());
		foodOrderRepo.save(order2);
		FoodOrder order3 = new FoodOrder(hohRepo.findByPhoneNumber(3305557777L), LocalDate.now());
		foodOrderRepo.save(order3);
		FoodOrder order4 = new FoodOrder(hohRepo.findByPhoneNumber(3305558888L), LocalDate.now());
		foodOrderRepo.save(order4);
	}

}
