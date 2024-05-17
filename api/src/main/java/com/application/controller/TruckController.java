package com.application.controller;

import com.application.entity.Truck;
import com.application.entity.TruckCoordinates;
import com.application.service.TruckService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/track")
@RequiredArgsConstructor
public class TruckController {
    private final TruckService truckService;

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public Page<Truck> getAllTrack(@RequestParam(defaultValue = "0") int page) {
        return truckService.findAll(page);
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Truck getTrackById(@PathVariable Long id) {
        return truckService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTrackById(@PathVariable Long id) {
        truckService.delete(id);
    }

    @GetMapping("/coordinates/get/{trackId}")
    @ResponseStatus(HttpStatus.OK)
    public List<TruckCoordinates> getTrackCoordinatesByTrackId(@PathVariable Long trackId) {
        return truckService.findCoordinatesByTrackId(trackId);
    }

    @GetMapping("/coordinates/get/ordered/{trackId}")
    @ResponseStatus(HttpStatus.OK)
    public List<TruckCoordinates> getTrackCoordinatesByTrackIdOrderedByCreatedAt(@PathVariable Long trackId) {
        return truckService.findTrackCoordinatesSortedByTime(trackId);
    }
}
