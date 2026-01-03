package com.project.Hospital_Management.controller;

import com.project.Hospital_Management.model.User;
import com.project.Hospital_Management.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(adminService.getAllUsers());
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return ResponseEntity.ok(adminService.deleteUser(id));
    }

    @PostMapping("/create")
    public ResponseEntity<User> createAdmin(@RequestBody User user){
        return ResponseEntity.ok(adminService.createAdmin(user));
    }
}
