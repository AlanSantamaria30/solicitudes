package com.solicitudes.santamaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solicitudes.santamaria.entity.Solicitud;
import com.solicitudes.santamaria.repository.SolicitudRepository;

@Service
public class SolicitudService {
	@Autowired
    private SolicitudRepository solicitudRepository;

    public Solicitud getSolicitudById(Long id) {
        return solicitudRepository.findById(id).orElse(null);
    }
    
    public Solicitud buscarSolicitudPorId(Long id) {
        return solicitudRepository.findById(id).orElse(null);
    }
    
    public Solicitud guardarSolicitud(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }
    
    

}
