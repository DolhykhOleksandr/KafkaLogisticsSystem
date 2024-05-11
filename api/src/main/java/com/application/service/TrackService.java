package com.application.service;

import com.application.entity.Track;
import com.application.entity.TrackCoordinates;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TrackService {
    Page<Track> findAll(int page);
    Track findById(long id);
    void delete(long id);
    List<TrackCoordinates> findCoordinatesByTrackId(long trackId);
    List<TrackCoordinates> findTrackCoordinatesSortedByTime(long trackId);
}
