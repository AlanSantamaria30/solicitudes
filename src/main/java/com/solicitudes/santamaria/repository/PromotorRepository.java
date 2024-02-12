package com.solicitudes.santamaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solicitudes.santamaria.entity.Promotor;

@Repository
public interface PromotorRepository extends JpaRepository<Promotor, Long> {
    
}
