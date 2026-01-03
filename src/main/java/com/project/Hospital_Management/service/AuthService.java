package com.project.Hospital_Management.service;

import com.project.Hospital_Management.dto.request.LoginRequest;
import com.project.Hospital_Management.dto.request.RegisterRequest;
import com.project.Hospital_Management.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}
