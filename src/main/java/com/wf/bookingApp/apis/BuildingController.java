package com.wf.bookingApp.apis;

import com.wf.bookingApp.entity.Building;
import com.wf.bookingApp.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buildings")
public class BuildingController {

    private final BuildingService buildingService;

    @Autowired
    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @GetMapping
    public ResponseEntity<List<Building>> getAllBuildings() {
        List<Building> buildings = buildingService.getAllBuildings();
        return ResponseEntity.ok(buildings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Building> getBuildingById(@PathVariable String id) {
        Building building = buildingService.getBuildingById(id);
        return building != null ? ResponseEntity.ok(building) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Building> createBuilding(@RequestBody Building building) {
        Building createdBuilding = buildingService.saveBuilding(building);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBuilding);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuilding(@PathVariable String id) {
        buildingService.deleteBuilding(id);
        return ResponseEntity.noContent().build();
    }
}
