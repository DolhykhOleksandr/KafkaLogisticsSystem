package com.application.service;

import lombok.RequiredArgsConstructor;
import com.application.entity.Truck;
import com.application.entity.TruckCoordinates;
import com.application.repository.TruckCoordinatesRepository;
import com.application.repository.TruckRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TruckService {
    private final TruckRepository truckRepository;
    private final TruckCoordinatesRepository coordinatesRepository;

    @Transactional
    public Truck save(Truck truck) {
        Truck saved = truckRepository.save(truck);
        coordinatesRepository.save(saved.getTruckCoordinatesList().getFirst());
        return saved;
    }

    public TruckCoordinates parse(String input) {
        TruckCoordinates coordinates = new TruckCoordinates();
        coordinates.setLatitude(getLatitude(input));
        coordinates.setLongitude(getLongitude(input));
        coordinates.setCreatedAt(LocalDateTime.now());
        return coordinates;
    }

    private double getLongitude(String input) {
        int startIndex = input.indexOf("longitude=") + "longitude=".length();
        int endIndex = input.indexOf(")", startIndex);
        return Double.parseDouble(input.substring(startIndex, endIndex).trim());
    }

    private double getLatitude(String input) {
        int startIndex = input.indexOf("latitude=") + "latitude=".length();
        int endIndex = input.indexOf(",", startIndex);
        return Double.parseDouble(input.substring(startIndex, endIndex).trim());
    }
}
