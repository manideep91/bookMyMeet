package com.wf.bookingApp.apis;

import com.wf.bookingApp.entity.Floor;
import com.wf.bookingApp.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/floors")
public class FloorController {

    private final FloorService floorService;

    @Autowired
    public FloorController(FloorService floorService) {
        this.floorService = floorService;
    }

    @GetMapping
    public ResponseEntity<List<Floor>> getAllFloors() {
        List<Floor> floors = floorService.getAllFloors();
        return new ResponseEntity<>(floors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Floor> getFloorById(@PathVariable String id) {
        Floor floor = floorService.getFloorById(id);
        if (floor != null) {
            return new ResponseEntity<>(floor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Floor> createFloor(@RequestBody Floor floor) {
        Floor savedFloor = floorService.saveFloor(floor);
        return new ResponseEntity<>(savedFloor, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFloor(@PathVariable String id) {
        floorService.deleteFloor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
