package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Optional<Admin> login(Integer username, String password) {
        return adminRepository.findByUsernameAndPassword(username, password);
    }

    public void registerAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    public Optional<Admin> findByUsername(Integer username) {
        return adminRepository.findByUsername(username);
    }
}
