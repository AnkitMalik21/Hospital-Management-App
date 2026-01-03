package com.project.Hospital_Management.service.imp;

import com.project.Hospital_Management.exception.ResourceNotFoundException;
import com.project.Hospital_Management.model.Role;
import com.project.Hospital_Management.model.User;
import com.project.Hospital_Management.repository.UserRepository;
import com.project.Hospital_Management.service.AdminService;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User createAdmin(User user) {
        if(userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("EMAIL ALREADY EXISTS");
        }

        user.setRole(Role.ADMIN);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(Long userId) {
         if(!userRepository.existsById(userId)){
             throw  new ResourceNotFoundException("USER NOT FOUND");
         }

         userRepository.deleteById(userId);
        return String.format("User with ID %d has been deleted successfully.", userId);

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
