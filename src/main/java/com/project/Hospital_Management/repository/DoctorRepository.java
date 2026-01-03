package com.project.Hospital_Management.repository;

import com.project.Hospital_Management.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    List<Doctor> findBySpecialization(String specialization);
    Optional<Doctor> findByUserId(Long UserId);
}
