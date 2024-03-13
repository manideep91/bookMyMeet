package com.wf.bookingApp.service;

import com.wf.bookingApp.entity.Building;
import com.wf.bookingApp.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {

    private final BuildingRepository buildingRepository;

    @Autowired
    public BuildingService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

    public Building getBuildingById(String id) {
        return buildingRepository.findById(id).orElse(null);
    }

    public Building saveBuilding(Building building) {
        return buildingRepository.save(building);
    }

    public void deleteBuilding(String id) {
        buildingRepository.deleteById(id);
    }
}
