package com.wf.bookingApp.repository;

import com.wf.bookingApp.entity.Floor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FloorRepository extends MongoRepository<Floor, String> {
}
