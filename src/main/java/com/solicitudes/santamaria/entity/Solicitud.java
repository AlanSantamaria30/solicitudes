package com.solicitudes.santamaria.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table (schema = "solicitud",name = "solicitudes")
public class Solicitud {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Column(name="id_solicitud")
    private String idSolicitud;
    
    @Column(name="monto")
    private BigDecimal monto;
    
    @Column(name="producto")
    private String producto;
    
    @Column(name="tipo_solicitud_str")
    private String tipoSolicitudStr;
    
    @Column(name="id_tipo_solicitud")
    private Long idTipoSolicitud;
    
    @Column(name="tasa")
    private BigDecimal tasa;
    
    @Column(name="plazo")
    private Integer plazo;
    
    @Column(name="frecuencia")
    private String frecuencia;
    
    @Column(name="fechaSolicitud")
    private Date fechaSolicitud;
    
    public Solicitud() {
        // Constructor vacío
    }
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;
}
