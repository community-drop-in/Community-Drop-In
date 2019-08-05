package com.communitydropin.CommunityDropInBackend.repositories;

import org.springframework.data.repository.CrudRepository;

import com.communitydropin.CommunityDropInBackend.entities.FoodOrder;

public interface FoodOrderRepository extends CrudRepository<FoodOrder, Long> {

}
