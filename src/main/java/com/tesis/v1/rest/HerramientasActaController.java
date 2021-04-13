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
import com.tesis.v1.domain.herramientasacta;
import com.tesis.v1.dto.herramientasactaDTO;
import com.tesis.v1.mapper.herramientasactaMapper;
import com.tesis.v1.service.ActaService;
import com.tesis.v1.service.HerramientasActasService;

@RestController // Servicio
@RequestMapping("/api/herramientasActa") // Forma de llamar datos
@CrossOrigin
public class HerramientasActaController {
	private final static Logger log = LoggerFactory.getLogger(HerramientasActaController.class);
	
	@Autowired
	HerramientasActasService herramientasActasService;

	@Autowired
	ActaService actaService;
	
	@Autowired
	herramientasactaMapper herramientasactaMapper;
	
	@RequestMapping("/finById/{herramientaId}")
	public ResponseEntity<?> finById(@PathVariable("herramientaId") Integer herramientaID)throws Exception{
		//herramientasacta herramienta= new herramientasacta();
		
		Optional<herramientasacta> herramientaoOpt = herramientasActasService.findById(herramientaID);
		log.info("Cargando ...");
		if( herramientaoOpt.isEmpty()) {
			return ResponseEntity.ok().body("Error: No se encontro Usuario");
			
		}
		herramientasacta herramienta = herramientaoOpt.get();
		herramientasactaDTO herramientasactaDTO = herramientasactaMapper.toherramientasActaDTO(herramienta);
		log.info("*");
		return ResponseEntity.ok().body(herramientasactaDTO);
		
	}
	@RequestMapping("/findByAll")
	public ResponseEntity<?> finByAll() throws Exception{
		List<herramientasacta> herramientaLIST= herramientasActasService.findAll();
		List<herramientasactaDTO> herramientaListDto = herramientasactaMapper.toherramientasActa(herramientaLIST);
		
		return ResponseEntity.ok().body(herramientaListDto);
	}
	@RequestMapping("/herramientaDelActa/{idProyecto}")
	public ResponseEntity<?> herramientaDelActa(@PathVariable("idProyecto") Integer idProyecto) throws Exception{
		List<herramientasacta> herramientaLIST= herramientasActasService.herramientaDelActa(idProyecto);
		List<herramientasactaDTO> herramientaListDto = herramientasactaMapper.toherramientasActa(herramientaLIST);
		
		return ResponseEntity.ok().body(herramientaListDto);
	}
	
	@RequestMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody herramientasactaDTO herramientasactaDTO)  throws Exception{
		actas acta =new actas();
		acta.setIdactas(herramientasactaDTO.getIdactas());
		herramientasacta herramienta = new herramientasacta();
		herramienta.setIdherramienta(0);
		herramienta.setActas(acta);
		herramienta.setJuicioexpertos(herramientasactaDTO.getJuicioexpertos());
		herramienta.setRecopilaciondatos(herramientasactaDTO.getRecopilaciondatos());
		herramienta.setHabilidades(herramientasactaDTO.getHabilidades());
		herramienta.setHerramientareuniones(herramientasactaDTO.getHabilidades());
		
		
		
		herramientasacta herramientasactaNew = herramientasActasService.save(herramienta);
		
		herramientasactaDTO herramientaDto = herramientasactaMapper.toherramientasActaDTO(herramientasactaNew);
		
		return ResponseEntity.ok().body(herramientaDto);
	}
	
}
