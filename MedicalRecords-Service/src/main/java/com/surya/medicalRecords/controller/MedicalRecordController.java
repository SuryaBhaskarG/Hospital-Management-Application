package com.surya.medicalRecords.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.surya.medicalRecords.entities.MedicalRecord;
import com.surya.medicalRecords.service.MedicalRecordService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/records")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService recordService;

    @PostMapping("/create")
    public ResponseEntity<MedicalRecord> createRecord(@RequestBody MedicalRecord record) {
        return ResponseEntity.ok(recordService.createRecord(record));
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<MedicalRecord>> getRecordsByPatientId(@PathVariable Long patientId) {
        return ResponseEntity.ok(recordService.getRecordsByPatientId(patientId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<MedicalRecord>> getAllRecords() {
        return ResponseEntity.ok(recordService.getAllRecords());
    }
}

