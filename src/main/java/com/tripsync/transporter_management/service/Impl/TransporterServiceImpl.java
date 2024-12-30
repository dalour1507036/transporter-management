package com.tripsync.transporter_management.service.Impl;

import com.tripsync.transporter_management.entity.Transporter;
import com.tripsync.transporter_management.repository.TransporterRepository;
import com.tripsync.transporter_management.service.TransporterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransporterServiceImpl implements TransporterService {
    private final TransporterRepository transporterRepository;

    public TransporterServiceImpl(TransporterRepository transporterRepository) {
        this.transporterRepository = transporterRepository;
    }

    @Override
    public List<Transporter> getAvailableTransporters(String startLocation) {
        // Filter by proximity (dummy implementation)
        return transporterRepository.findByIsAvailableTrue().stream()
            .filter(transporter -> transporter.getCurrentLocation().equalsIgnoreCase(startLocation))
            .collect(Collectors.toList());
    }

    @Override
    public void markTransporterBusy(String transporterId) {
        Transporter transporter = transporterRepository.findById(Long.valueOf(transporterId))
            .orElseThrow(() -> new IllegalArgumentException("Transporter not found"));
        transporter.setAvailable(false);
        transporterRepository.save(transporter);
    }

    @Override
    public void markTransporterFree(String transporterId) {
        Transporter transporter = transporterRepository.findById(Long.valueOf(transporterId))
            .orElseThrow(() -> new IllegalArgumentException("Transporter not found"));
        transporter.setAvailable(true);
        transporterRepository.save(transporter);
    }
}
