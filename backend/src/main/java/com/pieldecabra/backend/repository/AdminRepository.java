package com.pieldecabra.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pieldecabra.backend.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{
Optional<Admin> findByEmail(String email);
}
