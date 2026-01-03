package com.project.Hospital_Management.controller;

import com.project.Hospital_Management.dto.request.PatientProfileRequest;
import com.project.Hospital_Management.model.Patient;
import com.project.Hospital_Management.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> createProfile(@Valid @RequestBody PatientProfileRequest request){
        return ResponseEntity.ok(patientService.createPatientProfile(request));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','DOCTOR','PATIENT')")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id){
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Patient> getPatientByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(patientService.getPatientByUserId(userId));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','PATIENT')")
    public ResponseEntity<Patient> updateProfile(@PathVariable Long id,@Valid @RequestBody PatientProfileRequest request){
        return ResponseEntity.ok(patientService.updatePatientProfile(id,request));
    }
}
