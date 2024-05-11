package com.application.service;

import com.application.model.Track;
import com.application.model.TrackCoordinates;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.random.RandomGenerator;

@Service
@RequiredArgsConstructor
@Slf4j
public class TrackService {
    private final ProducerService producerService;

    private void changeCoordinates(Track track) {
        TrackCoordinates coordinates = track.getCoordinates();
        double longitude = coordinates.getLongitude();
        double latitude = coordinates.getLatitude();
        track.setCoordinates(new TrackCoordinates(RandomGenerator.getDefault().nextDouble(latitude, 50.0),
                RandomGenerator.getDefault().nextDouble(longitude, 50.0)));
    }

    @SneakyThrows
    public void sendNewCoordinates(Track track) {
        changeCoordinates(track);
        producerService.sendMessage(track.getCoordinates().toString(),
                String.valueOf(track.getId()));
        log.info("Successfully sent new coordinates to topic");
    }
}
