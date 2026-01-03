package com.project.Hospital_Management.service.imp;

import com.project.Hospital_Management.dto.request.PatientProfileRequest;
import com.project.Hospital_Management.exception.ResourceNotFoundException;
import com.project.Hospital_Management.model.Patient;
import com.project.Hospital_Management.model.User;
import com.project.Hospital_Management.repository.PatientRepository;
import com.project.Hospital_Management.repository.UserRepository;
import com.project.Hospital_Management.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl  implements PatientService {

    private final PatientRepository patientRepository;
    private final UserRepository userRepository;

    @Override
    public Patient createPatientProfile(PatientProfileRequest request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(()->new ResourceNotFoundException("USER NOT FOUND"));

        if(patientRepository.findByUserId(request.userId()).isPresent()){
            throw new RuntimeException("Patient profile already exist for this user");
        }

        Patient patient = Patient.builder()
                .user(user)
                .bloodGroup(request.bloodGroup())
                .emergencyContact(request.emergencyContact())
                .medicalHistory(request.medicalHistory())
                .build();
        return patientRepository.save(patient);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Patient not found"));
    }

    @Override
    public Patient getPatientByUserId(Long userId) {
        return patientRepository.findByUserId(userId)
                .orElseThrow(()-> new ResourceNotFoundException("Patient Profile"));

    }

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Patient updatePatientProfile(Long id, PatientProfileRequest request) {
        Patient patient = getPatientById(id);

        patient.setBloodGroup(request.bloodGroup());
        patient.setEmergencyContact(request.emergencyContact());
        patient.setMedicalHistory(request.medicalHistory());

        return patientRepository.save(patient);
    }
}
