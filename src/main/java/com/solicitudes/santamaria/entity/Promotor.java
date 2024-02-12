package com.solicitudes.santamaria.entity;

import com.solicitudes.santamaria.model.EmpresaRequest;

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
@Table (schema = "solicitud",name = "promotor")
public class Promotor {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 	
	 	@Column(name="codigo")
	    private String codigo;
	 	
	 	@ManyToOne
	    @JoinColumn(name = "empresa_id")
	    private Empresa empresa;
	 	
	 	public Promotor() {
	        // Constructor vacío
	    }
}
