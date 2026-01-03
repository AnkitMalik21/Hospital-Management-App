package com.project.Hospital_Management.service;

import com.project.Hospital_Management.model.User;

import java.util.List;

public interface AdminService {
    User createAdmin(User uer);
    String deleteUser(Long userId);
    List<User> getAllUsers();
}
