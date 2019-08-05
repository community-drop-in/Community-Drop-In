package com.communitydropin.CommunityDropInBackend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Order {
	
	@Id
	@GeneratedValue
	private Long id;

	
}
