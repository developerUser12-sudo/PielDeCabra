package com.pieldecabra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pieldecabra.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{
Optional<Admin> findByEmail(String email);
}
