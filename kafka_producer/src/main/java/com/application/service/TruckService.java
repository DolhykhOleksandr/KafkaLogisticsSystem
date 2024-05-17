package com.application.service;

import com.application.model.Truck;
import com.application.model.TruckCoordinates;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.random.RandomGenerator;

@Service
@RequiredArgsConstructor
@Slf4j
public class TruckService {
    private final ProducerService producerService;

    private void changeCoordinates(Truck truck) {
        TruckCoordinates coordinates = truck.getCoordinates();
        double longitude = coordinates.getLongitude();
        double latitude = coordinates.getLatitude();
        truck.setCoordinates(new TruckCoordinates(RandomGenerator.getDefault().nextDouble(latitude, 50.0),
                RandomGenerator.getDefault().nextDouble(longitude, 50.0)));
    }

    @SneakyThrows
    public void sendNewCoordinates(Truck truck) {
        changeCoordinates(truck);
        producerService.sendMessage(truck.getCoordinates().toString(),
                String.valueOf(truck.getId()));
        log.info("Successfully sent new coordinates to topic");
    }
}
