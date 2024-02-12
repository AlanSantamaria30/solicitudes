package com.solicitudes.santamaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solicitudes.santamaria.entity.Cliente;
import com.solicitudes.santamaria.entity.Empresa;
import com.solicitudes.santamaria.entity.Promotor;
import com.solicitudes.santamaria.entity.Solicitud;
import com.solicitudes.santamaria.model.SolicitudRequest;
import com.solicitudes.santamaria.repository.ClienteRepository;
import com.solicitudes.santamaria.repository.EmpresaRepository;
import com.solicitudes.santamaria.repository.PromotorRepository;
import com.solicitudes.santamaria.repository.SolicitudRepository;
import com.solicitudes.santamaria.service.SolicitudService;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponses;

//import io.swagger.annotations.ApiResponse;






@RestController
@RequestMapping("/api/solicitudes")
//@Api(tags = "Solicitudes", description = "Operaciones relacionadas con las solicitudes")
public class SolicitudesController {

	 	@Autowired
	    private PromotorRepository promotorRepository;
	    
	    @Autowired
	    private EmpresaRepository empresaRepository;
	    
	    @Autowired
	    private ClienteRepository clienteRepository;
	    
	    @Autowired
	    private SolicitudRepository solicitudRepository;
	    
	    @Autowired
	    private SolicitudService solicitudService;

	    @PostMapping("/guardar-solicitud")
	   // @ApiResponses( 
	    //		value = { 
	    //				@ApiResponse(code = 200, message = "Peticion exitosa."),
	    //				@ApiResponse(code = 204, message = "La peticion se ha completado con exito pero su respuesta no tiene ningun contenido.")})
	    //@ApiOperation(value = "Guardar Solicitud", response = Solicitud.class)
	    public ResponseEntity<String> guardarSolicitud(@RequestBody SolicitudRequest solicitudRequest) {
	        try {
	           

	            // Crear y guardar la empresa
	            Empresa empresa = new Empresa(null, null);
	            empresa.setNombre(solicitudRequest.getEmpresa().getNombre());
	            empresaRepository.save(empresa);

	            // Crear y guardar el promotor
	            Promotor promotor = new Promotor(null, null, null);
	            promotor.setCodigo(solicitudRequest.getPromotor().getCodigo());
	            promotor.setEmpresa(empresa);
	            promotorRepository.saveAndFlush(promotor);

	            // Crear y guardar el cliente
	            Cliente cliente = new Cliente(null, null, null, null, promotor);
	            cliente.setNombre(solicitudRequest.getCliente().getNombre());
	            cliente.setApellidoPaterno(solicitudRequest.getCliente().getApellidoPaterno());
	            cliente.setApellidoMaterno(solicitudRequest.getCliente().getApellidoMaterno());
	            clienteRepository.save(cliente);

	            // Crear y guardar la solicitud
	            Solicitud solicitud = new Solicitud(null, null, null, null, null, null, null, null, null, null, cliente);
	            solicitud.setIdSolicitud(solicitudRequest.getSolicitud().getIdSolicitud());
	            solicitud.setMonto(solicitudRequest.getSolicitud().getMonto());
	            solicitud.setProducto(solicitudRequest.getSolicitud().getProducto());
	            solicitud.setTipoSolicitudStr(solicitudRequest.getSolicitud().getTipoSolicitudStr());
	            solicitud.setIdTipoSolicitud(Long.parseLong(solicitudRequest.getSolicitud().getIdTipoSolicitud()));
	            solicitud.setTasa(solicitudRequest.getSolicitud().getTasa());
	            solicitud.setPlazo(solicitudRequest.getSolicitud().getPlazo());
	            solicitud.setFrecuencia(solicitudRequest.getSolicitud().getFrecuencia());
	            solicitud.setFechaSolicitud(solicitudRequest.getSolicitud().getFechaSolicitud());
	            solicitudRepository.save(solicitud);
	            
	            return ResponseEntity.ok("Solicitud guardada correctamente");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar la solicitud");
	        }
	    }
	    
	    @GetMapping("/{id}")
	    //@ApiResponses( 
	    //		value = { 
	    //				@ApiResponse(code = 200, message = "Peticion exitosa."),
	    //				@ApiResponse(code = 204, message = "La peticion se ha completado con exito pero su respuesta no tiene ningun contenido.")})
	    //@ApiOperation(value = "Obtener una solicitud por ID", response = Solicitud.class)
	    public ResponseEntity<Solicitud> getSolicitudById(@PathVariable Long id) {
	        Solicitud solicitud = solicitudService.getSolicitudById(id);
	        if (solicitud != null) {
	            return ResponseEntity.ok().body(solicitud);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	    
	    @PutMapping("/{id}")
	    //@ApiOperation(value = "Actualizar solicitud por ID", response = Solicitud.class)
	    //@ApiResponses( 
	    //		value = { 
	    //				@ApiResponse(code = 200, message = "Peticion exitosa."),
	    //				@ApiResponse(code = 204, message = "La peticion se ha completado con exito pero su respuesta no tiene ningun contenido.")})
	    public ResponseEntity<Solicitud> actualizarSolicitud(@PathVariable Long id, @RequestBody SolicitudRequest solicitudRequest) {
	    
	        Solicitud solicitudExistente = solicitudService.buscarSolicitudPorId(id);
	        
	        if (solicitudExistente == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        solicitudExistente.setMonto(solicitudRequest.getSolicitud().getMonto());
	        solicitudExistente.setProducto(solicitudRequest.getSolicitud().getProducto());
	        solicitudExistente.setFrecuencia(solicitudRequest.getSolicitud().getFrecuencia());
	  
	        Solicitud solicitudActualizada = solicitudService.guardarSolicitud(solicitudExistente);
	        
	        return new ResponseEntity<>(solicitudActualizada, HttpStatus.OK);
	    }
}
