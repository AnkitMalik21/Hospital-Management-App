package com.project.Hospital_Management.service;

import com.project.Hospital_Management.dto.request.DoctorProfileRequest;
import com.project.Hospital_Management.model.Doctor;
import java.util.List;

public interface DoctorService {
    Doctor createDoctorProfile(DoctorProfileRequest request);
    List<Doctor> getAllDoctors();
    Doctor getDoctorById(Long id);
}
