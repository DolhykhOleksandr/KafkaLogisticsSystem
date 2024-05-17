package com.application.repository;

import com.application.entity.TruckCoordinates;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TruckCoordinatesRepository extends JpaRepository<TruckCoordinates, Long> {
    List<TruckCoordinates> findTrackCoordinatesByTrackId(Long trackId);
    List<TruckCoordinates> findTrackCoordinatesByTrackIdOrderByCreatedAt(Long trackId);
}
