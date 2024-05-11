package com.application.repository;

import com.application.entity.TrackCoordinates;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackCoordinatesRepository extends JpaRepository<TrackCoordinates, Long> {
    List<TrackCoordinates> findTrackCoordinatesByTrackId(Long trackId);
}
