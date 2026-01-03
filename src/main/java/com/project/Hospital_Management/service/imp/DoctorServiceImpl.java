package com.project.Hospital_Management.service.imp;

import com.project.Hospital_Management.dto.request.DoctorProfileRequest;
import com.project.Hospital_Management.exception.ResourceNotFoundException;
import com.project.Hospital_Management.model.Doctor;
import com.project.Hospital_Management.model.User;
import com.project.Hospital_Management.repository.DoctorRepository;
import com.project.Hospital_Management.repository.UserRepository;
import com.project.Hospital_Management.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public  class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final UserRepository userRepository;

    @Override
    public Doctor createDoctorProfile(DoctorProfileRequest request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(()-> new ResourceNotFoundException("USER NOT FOUND"));

        Doctor doctor = Doctor.builder()
                .user(user)
                .specialization(request.specialization())
                .qualification(request.qualification())
                .department(request.department())
                .department(request.department())
                .availability(request.availability())
                .build();

        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Doctor not found"));
    }
}
