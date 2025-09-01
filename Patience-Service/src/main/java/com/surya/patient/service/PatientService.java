package com.surya.patient.service;


import java.util.List;

import com.surya.patient.entity.Patient;

public interface PatientService {
    Patient createPatient(Patient patient);
    Patient getPatientById(Long id);
    List<Patient> getAllPatients();
}
