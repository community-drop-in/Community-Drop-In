package com.communitydropin.CommunityDropInBackend.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.communitydropin.CommunityDropInBackend.entities.Recipient;


public interface RecipientRepository extends CrudRepository<Recipient, Long>{
	Recipient findByPhoneNumber(Long phoneNumber);

	Iterable<Recipient> findAll(Sort by);
}
