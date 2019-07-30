package com.communitydropin.CommunityDropInBackend;

import org.springframework.data.repository.CrudRepository;

public interface HeadOfHouseholdRepository extends CrudRepository<HeadOfHousehold, Long>{
	HeadOfHousehold findByPhoneNumber(Long phoneNumber);
}
