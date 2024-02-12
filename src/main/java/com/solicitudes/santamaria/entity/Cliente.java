package com.solicitudes.santamaria.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table (schema = "solicitud",name = "clientes")
public class Cliente {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="nombre")
    private String nombre;
	
	@Column(name="apellido_Paterno")
    private String apellidoPaterno;
	
	@Column(name="apellido_Materno")
    private String apellidoMaterno;
	
	public Cliente() {
        // Constructor vacío
    }
	
	@ManyToOne
    @JoinColumn(name = "promotor_id")
    private Promotor promotor;
}
