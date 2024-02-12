package com.solicitudes.santamaria.model;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SolicitudInfo {
	private String idSolicitud;
    private BigDecimal monto;
    private String producto;
    private String tipoSolicitudStr;
    private String idTipoSolicitud;
    private BigDecimal tasa;
    private Integer plazo;
    private String frecuencia;
    private Date fechaSolicitud;

}
