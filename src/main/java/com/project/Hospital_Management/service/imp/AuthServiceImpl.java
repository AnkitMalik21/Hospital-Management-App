package com.project.Hospital_Management.service.imp;

import com.project.Hospital_Management.dto.request.LoginRequest;
import com.project.Hospital_Management.dto.request.RegisterRequest;
import com.project.Hospital_Management.dto.response.AuthResponse;
import com.project.Hospital_Management.exception.ResourceNotFoundException;
import com.project.Hospital_Management.model.User;
import com.project.Hospital_Management.repository.UserRepository;
import com.project.Hospital_Management.security.JwtUtils;
import com.project.Hospital_Management.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse register(RegisterRequest request) {
        if(userRepository.existsByEmail(request.email())){
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(request.role())
                .build();

        userRepository.save(user);
        String jwtToken = jwtUtils.generateToken(user);

        return new AuthResponse(jwtToken,"User registered successfully");
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(),request.password())
        );

        User user = userRepository.findByEmail(request.email())
                .orElseThrow(()-> new ResourceNotFoundException("User not found"));

        String jwtToken = jwtUtils.generateToken(user);
        return new AuthResponse(jwtToken,"Login successful");
    }
}
