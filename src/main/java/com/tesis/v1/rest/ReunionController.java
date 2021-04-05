package com.tesis.v1.rest;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesis.v1.domain.actas;
import com.tesis.v1.domain.faseproyecto;
import com.tesis.v1.domain.proyectos;
import com.tesis.v1.domain.reuniones;
import com.tesis.v1.dto.actasDTO;
import com.tesis.v1.dto.reunionesDTO;
import com.tesis.v1.mapper.reunionesMapper;
import com.tesis.v1.service.ReunionesService;

@RestController // Servicio
@RequestMapping("/api/Reunion") // Forma de llamar datos
@CrossOrigin
public class ReunionController {
	
	private final static Logger log = LoggerFactory.getLogger(ReunionController.class);

	@Autowired
	ReunionesService reunionesService;
	
	@Autowired
	reunionesMapper reunionesMapper;
	
	
	@RequestMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody reunionesDTO reunionesDTO)  throws Exception{
		log.info("************************************ 1");
		faseproyecto faseproyecto = new faseproyecto ();
		proyectos proyectos = new proyectos();
		
		reuniones reunion = new reuniones();
		reunion.setDescripcionreunion(reunionesDTO.getDescripcionreunion());
		reunion.setNombrereunion(reunionesDTO.getNombrereunion());
		
		faseproyecto.setIdfase(reunionesDTO.getIdfase());
		reunion.setFaseproyecto(faseproyecto);
		
		proyectos.setIdproyecto(reunionesDTO.getIdproyecto());
		reunion.setProyectos(proyectos);
		
		
		
		log.info("************************************ 2");
		
		reuniones reunionnew = reunionesService.save(reunion);
		log.info("************************************ 3");
		reunionesDTO reunionesDTOnew = new reunionesDTO();
		
		
		reunionesDTOnew = reunionesMapper.toReunionDTO(reunionnew);
		
		
		log.info("************************************ 4");
		return ResponseEntity.ok().body(reunionesDTOnew);
		
	}
}
