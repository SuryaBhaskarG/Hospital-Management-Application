package com.surya.medicalRecords.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surya.medicalRecords.entities.MedicalRecord;
import com.surya.medicalRecords.repository.MedicalRecordRepository;

import java.util.List;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

    @Autowired
    private MedicalRecordRepository recordRepository;

    @Override
    public MedicalRecord createRecord(MedicalRecord record) {
        return recordRepository.save(record);
    }

    @Override
    public List<MedicalRecord> getRecordsByPatientId(Long patientId) {
        return recordRepository.findByPatientId(patientId);
    }

    @Override
    public List<MedicalRecord> getAllRecords() {
        return recordRepository.findAll();
    }
}
