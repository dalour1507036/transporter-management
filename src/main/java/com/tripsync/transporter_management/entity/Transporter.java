package com.tripsync.transporter_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transporter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String transporterId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean isAvailable;

    @Column(nullable = false)
    private String currentLocation;
}

