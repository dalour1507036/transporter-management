package com.tripsync.transporter_management.service;

import com.tripsync.transporter_management.entity.Transporter;

import java.util.List;

public interface TransporterService {
    List<Transporter> getAvailableTransporters(String startLocation);

    void markTransporterBusy(String transporterId);

    void markTransporterFree(String transporterId);

}
