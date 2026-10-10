package com.pieldecabra.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pieldecabra.backend.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long>{

}
