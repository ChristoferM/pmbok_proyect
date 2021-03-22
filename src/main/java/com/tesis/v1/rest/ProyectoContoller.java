package com.tesis.v1.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesis.v1.domain.proyectos;
import com.tesis.v1.dto.proyectosDTO;
import com.tesis.v1.mapper.proyectosMapper;
import com.tesis.v1.service.ProyectoService;

@RestController // Servicio
@RequestMapping("/api/proyecto") // Forma de llamar datos
@CrossOrigin
public class ProyectoContoller {
	private final static Logger log = LoggerFactory.getLogger(ProyectoContoller.class);
	
	@Autowired
	ProyectoService proyectoService;
	
	@Autowired
	proyectosMapper proyectosMapper ;
	
	@RequestMapping("/finById/{proyectoId}")
	public ResponseEntity<?> finById(@PathVariable("proyectoId") Integer poryectoId)throws Exception{
		Optional<proyectos> usuarioOpt = proyectoService.findById(poryectoId);
		log.info("Cargando ...");
		if( usuarioOpt.isEmpty()) {
			return ResponseEntity.ok().body("Error: No se encontro Usuario");
			
		}
		proyectos proyectos = usuarioOpt.get();
		proyectosDTO usuarioDTO = proyectosMapper.toproyectosDTO(proyectos);
		log.info("*");
		return ResponseEntity.ok().body(usuarioDTO);
		
	}
	@RequestMapping("/findByAll")
	public ResponseEntity<?> finByAll() throws Exception{
		List<proyectos> proyectosLIST= proyectoService.findAll();
		List<proyectosDTO> usuarioListDto = proyectosMapper.toproyectosDTOs(proyectosLIST);
		
		return ResponseEntity.ok().body(usuarioListDto);
	}
	
	
	@RequestMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody proyectosDTO proyectosDto)  throws Exception{
	
		proyectos proyecto = proyectosMapper.toproyectos(proyectosDto);
		
		proyecto = proyectoService.save(proyecto);
		
		proyectosDto = proyectosMapper.toproyectosDTO(proyecto);
		
		return ResponseEntity.ok().body(proyectosDto);
	}
	
}
