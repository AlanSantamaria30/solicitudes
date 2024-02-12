package com.solicitudes.santamaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solicitudes.santamaria.entity.Solicitud;

@Repository
public interface SolicitudRepository  extends JpaRepository<Solicitud, Long> {

}
