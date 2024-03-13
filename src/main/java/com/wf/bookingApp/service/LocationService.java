package com.wf.bookingApp.service;

import com.wf.bookingApp.entity.Location;
import com.wf.bookingApp.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;
    private final BuildingService buildingService;
    private final FloorService floorService;
    private final RoomService roomService;

    @Autowired
    public LocationService(LocationRepository locationRepository,
                           BuildingService buildingService,
                           FloorService floorService,
                           RoomService roomService) {
        this.locationRepository = locationRepository;
        this.buildingService = buildingService;
        this.floorService = floorService;
        this.roomService = roomService;
    }

    public Location saveLocation(Location location) {
        // Save rooms first
        location.getBuildings().forEach(building ->
                building.getFloors().forEach(floor ->
                        floor.getRooms().forEach(roomService::saveRoom)));

        // Save floors next
        location.getBuildings().forEach(building ->
                building.getFloors().forEach(floorService::saveFloor));

        // Save buildings last
        location.getBuildings().forEach(buildingService::saveBuilding);

        // Then save the location
        return locationRepository.save(location);
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location getLocationById(String id) {
        return locationRepository.findById(id).orElse(null);
    }

    public void deleteLocation(String id) {
        locationRepository.deleteById(id);
    }
}
