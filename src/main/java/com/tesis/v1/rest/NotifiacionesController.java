package com.tesis.v1.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesis.v1.domain.notificaciones;
import com.tesis.v1.dto.GrupoDTO;
import com.tesis.v1.dto.NotificacionesDTO;
import com.tesis.v1.repository.NotificacionesRepository;
import com.tesis.v1.service.NotificacionesService;

@RestController // Servicio
@RequestMapping("/api/notificaciones") // Forma de llamar datos
@CrossOrigin
public class NotifiacionesController {
	
	@Autowired
	NotificacionesRepository notificacionesRepository;
	
	@Autowired
	NotificacionesService notificacionesService;
	
	
	@RequestMapping("/BuscarEnviados/{user}")
    public ResponseEntity<?> BuscarEnviados(@PathVariable("user") String user) throws Exception {
		
		return ResponseEntity.ok().body(notificacionesService.BuscarEnviados(user));
	}
	
	@RequestMapping("/BuscarRecibidos/{user}")
    public ResponseEntity<?> BuscarRecibidos(@PathVariable("user") String user) throws Exception {
		
		return ResponseEntity.ok().body(notificacionesService.BuscarRecibidos(user));
	}

	 @RequestMapping("/nuevaNotificacion")
	    public ResponseEntity<?> save(@Valid @RequestBody NotificacionesDTO DTO) throws Exception {
		 notificaciones entity = new notificaciones();
		 
		 entity.setEmisor(DTO.getEmisor());
		 entity.setReceptor(DTO.getReceptor());
		 entity.setMensaje(DTO.getMensaje());
		 entity.setEstado(false);;
		 
		 
		 return ResponseEntity.ok().body(notificacionesService.save(entity));
	 }
	 
	 @RequestMapping("/editarEstado")
	    public ResponseEntity<?> editarEstado(@Valid @RequestBody NotificacionesDTO DTO) throws Exception {
		 notificaciones entity = new notificaciones();
		 
		 entity.setIdnotificaciones(DTO.getIdnotificaciones());
		 entity.setEmisor(DTO.getEmisor());
		 entity.setReceptor(DTO.getReceptor());
		 entity.setMensaje(DTO.getMensaje());
		 entity.setEstado(DTO.getEstado());
		 
		 
		 return ResponseEntity.ok().body(notificacionesService.update(entity));
	 }
	 @RequestMapping("/CrearNotificacionMatricula")
	    public ResponseEntity<?> CrearNotificacionMatricula(@Valid @RequestBody GrupoDTO DTO) throws Exception { 
		 
		 return ResponseEntity.ok().body(notificacionesService.CrearNotificacionMatricula(DTO));
	 }
	 
}
