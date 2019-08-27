package com.communitydropin.CommunityDropInBackend;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.communitydropin.CommunityDropInBackend.entities.FoodOrder;
import com.communitydropin.CommunityDropInBackend.entities.Recipient;
import com.communitydropin.CommunityDropInBackend.repositories.FoodOrderRepository;
import com.communitydropin.CommunityDropInBackend.repositories.RecipientRepository;

@Service
public class Initializer implements CommandLineRunner {
	@Autowired
	RecipientRepository recipientRepo;
	
	@Autowired
	FoodOrderRepository foodOrderRepo;

	@Override
	public void run(String... args) throws Exception {
		populateHoh();
		populateOrders();
	}

	private void populateHoh() {
		Recipient hoh1 = new Recipient("Isaac", "Kim", "1770 Pennsylvania Ave", 3305551111L, true, 2,
				LocalDate.of(1990, 5, 7));
		recipientRepo.save(hoh1);
		Recipient hoh2 = new Recipient("Kai", "Hennacy", "1771 Connecticut Ave", 3305552222L, false, 1,
				LocalDate.of(1998, 5, 21));
		recipientRepo.save(hoh2);
		Recipient hoh4 = new Recipient("Matt", "Laine", "1773 Indiana St", 3305554444L, false, 5,
				LocalDate.of(1992, 8, 1));
		recipientRepo.save(hoh4);
		Recipient hoh5 = new Recipient("Don", "Hamilton III", "1774 Kentucky Rd", 3305555555L, false, 2,
				LocalDate.of(1985, 11, 12));
		recipientRepo.save(hoh5);
		Recipient hoh6 = new Recipient("Ben", "Williams", "1775 West Virginia Ave", 3305556666L, false, 3,
				LocalDate.of(1982, 7, 7));
		recipientRepo.save(hoh6);
		Recipient hoh7 = new Recipient("Lacey", "Nichols", "1776 New York Ave", 3305557777L, false, 2,
				LocalDate.of(1990, 4, 4));
		recipientRepo.save(hoh7);
		Recipient hoh8 = new Recipient("Kendra", "Reynolds", "1777 Rhode Island Ct", 3305558888L, false, 2,
				LocalDate.of(1990,  5, 5));
		recipientRepo.save(hoh8);
		
	}
	
	private void populateOrders() {
		FoodOrder order1 = new FoodOrder(recipientRepo.findByPhoneNumber(3305552222L), LocalDate.now());
		foodOrderRepo.save(order1);
		FoodOrder order2 = new FoodOrder(recipientRepo.findByPhoneNumber(3305556666L), LocalDate.now());
		foodOrderRepo.save(order2);
		FoodOrder order3 = new FoodOrder(recipientRepo.findByPhoneNumber(3305557777L), LocalDate.now());
		foodOrderRepo.save(order3);
		FoodOrder order4 = new FoodOrder(recipientRepo.findByPhoneNumber(3305558888L), LocalDate.now());
		foodOrderRepo.save(order4);
	}

}
