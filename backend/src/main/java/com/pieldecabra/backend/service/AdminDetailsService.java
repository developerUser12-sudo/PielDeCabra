package com.pieldecabra.backend.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pieldecabra.backend.entity.Admin;
import com.pieldecabra.backend.repository.AdminRepository;

@Service
public class AdminDetailsService implements UserDetailsService {

    private final AdminRepository repo;

    public AdminDetailsService(AdminRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Admin admin = repo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Administrador no encontrado"));
        return User.builder().username(admin.getEmail()).password(admin.getContrasena()).roles("ADMIN").build();
    }
}
