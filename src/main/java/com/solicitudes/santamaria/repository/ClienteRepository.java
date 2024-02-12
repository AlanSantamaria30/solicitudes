package com.solicitudes.santamaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solicitudes.santamaria.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
