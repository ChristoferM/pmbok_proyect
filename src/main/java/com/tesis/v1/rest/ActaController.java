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

import com.tesis.v1.domain.actas;
import com.tesis.v1.domain.reuniones;
import com.tesis.v1.dto.actasDTO;
import com.tesis.v1.mapper.actasMapper;
import com.tesis.v1.service.ActaService;
import com.tesis.v1.service.HerramientasActasService;

@RestController // Servicio
@RequestMapping("/api/acta") // Forma de llamar datos
@CrossOrigin
public class ActaController {
	
	private final static Logger log = LoggerFactory.getLogger(ActaController.class);
	@Autowired
	ActaService actaService;
	
	@Autowired
	HerramientasActasService herramientasActasService;
	
	@Autowired
	actasMapper actaMapper ;
	
	
	@RequestMapping("/finById/{actaId}")
	public ResponseEntity<?> finById(@PathVariable("actaId") Integer actaId)throws Exception{
		//actas acta =new actas();
		Optional<actas> actaopc = actaService.findById(actaId);
		log.info("Cargando ...");
		if( actaopc.isEmpty()) {
			return ResponseEntity.ok().body("Error: No se encontro Usuario");
			
		}
		actas acta = actaopc.get();
		actasDTO actaDTO = actaMapper.toActasDTO(acta);
		log.info("*");
		return ResponseEntity.ok().body(actaDTO);
		
	}
	@RequestMapping("/findByAll")
	public ResponseEntity<?> finByAll() throws Exception{
		//actas acta
		List<actas> actaLIST= actaService.findAll();
		List<actasDTO> actasListDto = actaMapper.toActasDTO(actaLIST);
		
		return ResponseEntity.ok().body(actasListDto);
	}
	
	
	@RequestMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody actasDTO actasDTO)  throws Exception{
		log.info("************************************ 1");
		actas acta =new actas();
		reuniones reunion = new reuniones();
		reunion.setIdreuniones(actasDTO.getIdreuniones());
		acta.setReuniones(reunion);
		log.info("************************************ 2");
		
		actas actanew = actaService.save(acta);
		log.info("************************************ 3");
		actasDTO actaDTO = new actasDTO();
		actaDTO.setIdactas(actanew.getIdactas());
		actaDTO.setIdreuniones(actanew.getReuniones().getIdreuniones());
		log.info("************************************ 4");
		return ResponseEntity.ok().body(actaDTO);
	}
	
	

}
