package com.application.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Truck {
    @Id
    private Long id;

    @OneToMany(mappedBy = "track", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TruckCoordinates> truckCoordinatesList = new ArrayList<>();
}
