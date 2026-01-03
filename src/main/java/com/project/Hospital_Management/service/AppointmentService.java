package com.project.Hospital_Management.service;

import com.project.Hospital_Management.dto.request.AppointmentRequest;
import com.project.Hospital_Management.model.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment bookAppointment(AppointmentRequest request);
    List<Appointment> getAppointmentsByDoctor(Long doctorId);
    List<Appointment> getAppointmentsByPatient(Long patientId);
    void cancelAppointment(Long appointmentId);
}
