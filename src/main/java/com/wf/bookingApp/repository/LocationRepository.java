package com.wf.bookingApp.repository;

import com.wf.bookingApp.entity.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<Location, String> {

}
