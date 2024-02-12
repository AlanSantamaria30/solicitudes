package com.solicitudes.santamaria.model;



import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
//@ApiModel(description = "Modelo de datos para el servicio de SOPERFIS")
public class SolicitudRequest {
	
	private PromotorRequest promotor;
    private EmpresaRequest empresa;
    private ClienteRequest cliente;
    private SolicitudInfo solicitud;

    // Getters y setters

    public PromotorRequest getPromotor() {
        return promotor;
    }

    public void setPromotor(PromotorRequest promotor) {
        this.promotor = promotor;
    }

    public EmpresaRequest getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaRequest empresa) {
        this.empresa = empresa;
    }

    public ClienteRequest getCliente() {
        return cliente;
    }

    public void setCliente(ClienteRequest cliente) {
        this.cliente = cliente;
    }

    public SolicitudInfo getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudInfo solicitud) {
        this.solicitud = solicitud;
    }

}
