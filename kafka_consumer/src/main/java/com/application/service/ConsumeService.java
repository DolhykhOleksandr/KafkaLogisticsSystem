package com.application.service;

import com.application.entity.Truck;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import com.application.entity.TruckCoordinates;
import com.application.repository.TruckRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumeService {

    private final TruckService truckService;
    private final TruckRepository truckRepository;

    @KafkaListener(topics = "topic")
    public void receiveMessage(ConsumerRecord<String, String> record) {
        log.info("receive message: {}", record);
        Long trackId = Long.parseLong(record.key());
        Truck truck = truckRepository.findById(trackId).orElse(new Truck());
        if (truck.getId() == null) {
            truck.setId(trackId);
        }
        TruckCoordinates coordinates = truckService.parse(record.value());
        truck.getTruckCoordinatesList().add(coordinates);
        coordinates.setTruck(truck);
        truckService.save(truck);
        log.info("Successfully received message: {}", record);
        log.info("Successfully saved track: {}", truck);
    }
}
