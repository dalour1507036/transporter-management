package com.tripsync.transporter_management.controller.api.v1;

import com.tripsync.transporter_management.entity.Transporter;
import com.tripsync.transporter_management.service.TransporterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transporters")
public class TransporterController {
    private final TransporterService transporterService;

    public TransporterController(TransporterService transporterService) {
        this.transporterService = transporterService;
    }

    @GetMapping("/available")
    public ResponseEntity<List<Transporter>> getAvailableTransporters(@RequestParam String startLocation) {
        List<Transporter> transporters = transporterService.getAvailableTransporters(startLocation);
        return ResponseEntity.ok(transporters);
    }

    @PostMapping("/{transporterId}/busy")
    public ResponseEntity<Void> markTransporterBusy(@PathVariable String transporterId) {
        transporterService.markTransporterBusy(transporterId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{transporterId}/free")
    public ResponseEntity<Void> markTransporterFree(@PathVariable String transporterId) {
        transporterService.markTransporterFree(transporterId);
        return ResponseEntity.ok().build();
    }
}

