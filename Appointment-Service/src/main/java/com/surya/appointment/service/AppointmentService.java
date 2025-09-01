package com.surya.appointment.service;


import java.util.List;

import com.surya.appointment.entity.Appointment;

public interface AppointmentService {

    Appointment bookAppointment(Appointment appointment);

    List<Appointment> getAppointmentsByDoctorId(Long doctorId);

    List<Appointment> getAppointmentsByPatientId(Long patientId);

    List<Appointment> getAllAppointments();
}
