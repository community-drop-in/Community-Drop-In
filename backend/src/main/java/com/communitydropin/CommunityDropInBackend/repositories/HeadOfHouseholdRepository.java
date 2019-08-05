package com.communitydropin.CommunityDropInBackend.repositories;

import org.springframework.data.repository.CrudRepository;

import com.communitydropin.CommunityDropInBackend.entities.HeadOfHousehold;


public interface HeadOfHouseholdRepository extends CrudRepository<HeadOfHousehold, Long>{
	HeadOfHousehold findByPhoneNumber(Long phoneNumber);
}
