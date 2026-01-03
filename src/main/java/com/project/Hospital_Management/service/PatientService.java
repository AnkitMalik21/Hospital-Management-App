package com.project.Hospital_Management.service;

import com.project.Hospital_Management.dto.request.PatientProfileRequest;
import com.project.Hospital_Management.model.Patient;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface PatientService {
    Patient createPatientProfile(PatientProfileRequest request);
    Patient getPatientById(Long id);
    Patient getPatientByUserId(Long userId);
    List<Patient> getAllPatient();
    Patient updatePatientProfile(Long id,PatientProfileRequest request);

}
