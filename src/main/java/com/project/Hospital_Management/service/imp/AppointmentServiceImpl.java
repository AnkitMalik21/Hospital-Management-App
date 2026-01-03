package com.project.Hospital_Management.service.imp;

import com.project.Hospital_Management.dto.request.AppointmentRequest;
import com.project.Hospital_Management.exception.ResourceNotFoundException;
import com.project.Hospital_Management.model.Appointment;
import com.project.Hospital_Management.model.AppointmentStatus;
import com.project.Hospital_Management.model.Doctor;
import com.project.Hospital_Management.model.Patient;
import com.project.Hospital_Management.repository.AppointmentRepository;
import com.project.Hospital_Management.repository.DoctorRepository;
import com.project.Hospital_Management.repository.PatientRepository;
import com.project.Hospital_Management.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Override
    public Appointment bookAppointment(AppointmentRequest request) {
        Doctor doctor = doctorRepository.findById(request.doctorId())
                .orElseThrow(()-> new ResourceNotFoundException("DOCTOR NOT FOUND"));

        Patient patient = patientRepository.findById(request.patientId())
                .orElseThrow(()-> new ResourceNotFoundException("PATIENT NOT FOUND"));

        Appointment appointment = Appointment.builder()
                .doctor(doctor)
                .patient(patient)
                .appointmentTime(request.appointmentTime())
                .reason(request.reason())
                .status(AppointmentStatus.SCHEDULED)
                .build();

        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAppointmentsByDoctor(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    @Override
    public List<Appointment> getAppointmentsByPatient(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    @Override
    public void cancelAppointment(Long appointmentId) {
         Appointment appointment = appointmentRepository.findById(appointmentId)
                 .orElseThrow(()-> new ResourceNotFoundException("APPOINTMENT NOT FOUND"));

         appointment.setStatus(AppointmentStatus.CANCELLED);
         appointmentRepository.save(appointment);
    }
}
