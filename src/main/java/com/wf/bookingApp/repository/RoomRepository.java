package com.wf.bookingApp.repository;

import com.wf.bookingApp.entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room, String> {
}
