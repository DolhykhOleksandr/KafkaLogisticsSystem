package com.application.service;

import com.application.model.Truck;
import lombok.RequiredArgsConstructor;
import com.application.model.TruckCoordinates;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

@Service
@RequiredArgsConstructor
public class LogisticService {
    private final TruckService truckService;

    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

    public void sendParallelTrucks() {
        for (int i = 0; i < 10; i++) {
            final int trackIndex = i;
            executorService.scheduleAtFixedRate(() -> {
                Truck truck = new Truck((long) (trackIndex + 1),
                        new TruckCoordinates(36.385913, -127.441406));
                truckService.sendNewCoordinates(truck);
            }, 0, 10, SECONDS);
        }
    }

    public void stopSending() {
        executorService.shutdown();
    }
}
