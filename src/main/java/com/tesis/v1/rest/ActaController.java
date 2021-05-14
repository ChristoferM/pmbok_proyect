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

import com.tesis.v1.domain.Acta;
import com.tesis.v1.domain.Reunion;
import com.tesis.v1.dto.ActasDTO;
import com.tesis.v1.service.ActaService;
import com.tesis.v1.service.HerramientasActasService;
import com.tesis.v1.mapper.ActasMapper;

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
	ActasMapper actaMapper ;
	
	
	@RequestMapping("/finById/{actaId}")
	public ResponseEntity<?> finById(@PathVariable("actaId") Integer actaId)throws Exception{
		//actas acta =new Acta();
		Optional<Acta> actaopc = actaService.findById(actaId);
		log.info("Cargando ...");
		if( actaopc.isEmpty()) {
			return ResponseEntity.ok().body("Error: No se encontro Usuario");
			
		}
		Acta acta = actaopc.get();
		ActasDTO actaDTO = actaMapper.toActasDTO(acta);
		log.info("*");
		return ResponseEntity.ok().body(actaDTO);
		
	}
	@RequestMapping("/findByAll")
	public ResponseEntity<?> finByAll() throws Exception{
		//actas acta
		List<Acta> actaLIST= actaService.findAll();
		List<ActasDTO> actasListDto = actaMapper.toActasDTO(actaLIST);
		
		return ResponseEntity.ok().body(actasListDto);
	}
	
	
	@RequestMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody ActasDTO actasDTO)  throws Exception{
		log.info("************************************ 1");
		Acta acta =new Acta();
		Reunion reunion = new Reunion();
		reunion.setIdreuniones(actasDTO.getIdreuniones());
		acta.setReuniones(reunion);
		log.info("************************************ 2");
		
		Acta actanew = actaService.save(acta);
		log.info("************************************ 3");
		ActasDTO actaDTO = new ActasDTO();
		actaDTO.setIdactas(actanew.getIdactas());
		actaDTO.setIdreuniones(actanew.getReuniones().getIdreuniones());
		log.info("************************************ 4");
		return ResponseEntity.ok().body(actaDTO);
	}
	
	

}
