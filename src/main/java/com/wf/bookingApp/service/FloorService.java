package com.wf.bookingApp.service;

import com.wf.bookingApp.entity.Floor;
import com.wf.bookingApp.repository.FloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorService {

    private final FloorRepository floorRepository;

    @Autowired
    public FloorService(FloorRepository floorRepository) {
        this.floorRepository = floorRepository;
    }

    public List<Floor> getAllFloors() {
        return floorRepository.findAll();
    }

    public Floor getFloorById(String id) {
        return floorRepository.findById(id).orElse(null);
    }

    public Floor saveFloor(Floor floor) {
        return floorRepository.save(floor);
    }

    public void deleteFloor(String id) {
        floorRepository.deleteById(id);
    }
}
