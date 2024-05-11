package com.application.repository;

import com.application.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TrackRepository extends JpaRepository<Track, Long> {
}
