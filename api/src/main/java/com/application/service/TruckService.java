package com.application.service;

import com.application.entity.Truck;
import com.application.entity.TruckCoordinates;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TruckService {
    Page<Truck> findAll(int page);
    Truck findById(long id);
    void delete(long id);
    List<TruckCoordinates> findCoordinatesByTrackId(long trackId);
    List<TruckCoordinates> findTrackCoordinatesSortedByTime(long trackId);
}
