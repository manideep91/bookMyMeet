package com.wf.bookingApp.repository;

import com.wf.bookingApp.entity.Building;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BuildingRepository extends MongoRepository<Building, String> {
}
