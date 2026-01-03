package com.project.Hospital_Management.repository;

import com.project.Hospital_Management.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Optional<Patient> findByUserId(Long userId);
}
