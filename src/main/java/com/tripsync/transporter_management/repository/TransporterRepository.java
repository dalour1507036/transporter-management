package com.tripsync.transporter_management.repository;

import com.tripsync.transporter_management.entity.Transporter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransporterRepository extends JpaRepository<Transporter, Long> {
    List<Transporter> findByIsAvailableTrue();
}

