package com.application.service.impl;

import lombok.RequiredArgsConstructor;
import com.application.entity.Truck;
import com.application.entity.TruckCoordinates;
import com.application.repository.TruckCoordinatesRepository;
import com.application.repository.TruckRepository;
import com.application.service.TruckService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TruckServiceImpl implements TruckService {
    private final TruckRepository truckRepository;
    private final TruckCoordinatesRepository coordinatesRepository;

    @Override
    public Page<Truck> findAll(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return truckRepository.findAll(pageable);
    }

    @Override
    public Truck findById(long id) {
        return truckRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(long id) {
        truckRepository.deleteById(id);
    }

    @Override
    public List<TruckCoordinates> findCoordinatesByTrackId(long trackId) {
        return coordinatesRepository.findTrackCoordinatesByTrackId(trackId);
    }

    @Override
    public List<TruckCoordinates> findTrackCoordinatesSortedByTime(long trackId) {
        return coordinatesRepository.findTrackCoordinatesByTrackIdOrderByCreatedAt(trackId);
    }
}
