package com.application.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TruckCoordinates {
    public final double latitude;
    public final double longitude;

    public TruckCoordinates(double lat, double lon) {
        latitude = lat;
        longitude = lon;
    }
}
