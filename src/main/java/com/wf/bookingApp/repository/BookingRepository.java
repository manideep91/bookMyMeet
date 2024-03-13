package com.wf.bookingApp.repository;

import com.wf.bookingApp.entity.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, String> {
}
