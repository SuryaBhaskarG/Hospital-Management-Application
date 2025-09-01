package com.surya.doctor.service;


import java.util.List;

import com.surya.doctor.entity.Doctor;

public interface DoctorService {

    Doctor createDoctor(Doctor doctor);

    Doctor getDoctorById(Long id);

    List<Doctor> getAllDoctors();
}
