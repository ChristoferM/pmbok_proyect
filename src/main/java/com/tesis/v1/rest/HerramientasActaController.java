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
import com.tesis.v1.domain.Herramientasacta;
import com.tesis.v1.dto.HerramientasActaDTO;
import com.tesis.v1.service.ActaService;
import com.tesis.v1.service.HerramientasActasService;
import com.tesis.v1.mapper.HerramientasactaMapper;

@RestController // Servicio
@RequestMapping("/api/herramientasActa") // Forma de llamar datos
@CrossOrigin
public class HerramientasActaController {
	
	
	private final static Logger log = LoggerFactory.getLogger(HerramientasActaController.class);
	
	@Autowired
	HerramientasactaMapper herramientasactaMapper;
	
	@Autowired
	HerramientasActasService herramientasActasService;

	@Autowired
	ActaService actaService;
	
	@RequestMapping("/herramientaDelActa/{idProyecto}")
	public ResponseEntity<?> herramientaDelActa(@PathVariable("idProyecto") Integer idProyecto) throws Exception{
		List<Herramientasacta> herramientaLIST= herramientasActasService.herramientaDelActa(idProyecto);
		List<HerramientasActaDTO> herramientaListDto = herramientasactaMapper.toherramientasActa(herramientaLIST);
		
		return ResponseEntity.ok().body(herramientaListDto);
	}
	
	
	@RequestMapping("/finById/{herramientaId}")
	public ResponseEntity<?> finById(@PathVariable("herramientaId") Integer herramientaID)throws Exception{
		//herramientasacta herramienta= new Herramientasacta();
		
		Optional<Herramientasacta> herramientaoOpt = herramientasActasService.findById(herramientaID);
		log.info("Cargando ...");
		if( herramientaoOpt.isEmpty()) {
			return ResponseEntity.ok().body("Error: No se encontro Usuario");
			
		}
		Herramientasacta herramienta = herramientaoOpt.get();
		HerramientasActaDTO herramientasactaDTO = herramientasactaMapper.toherramientasActaDTO(herramienta);
		log.info("*");
		return ResponseEntity.ok().body(herramientasactaDTO);
		
	}
	@RequestMapping("/findByAll")
	public ResponseEntity<?> finByAll() throws Exception{
		List<Herramientasacta> herramientaLIST= herramientasActasService.findAll();
		List<HerramientasActaDTO> herramientaListDto = herramientasactaMapper.toherramientasActa(herramientaLIST);
		
		return ResponseEntity.ok().body(herramientaListDto);
	}

	@RequestMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody HerramientasActaDTO herramientasactaDTO)  throws Exception{
		Acta acta =new Acta();
		acta.setIdactas(herramientasactaDTO.getIdactas());
		Herramientasacta herramienta = new Herramientasacta();
		herramienta.setIdherramienta(0);
		herramienta.setActas(acta);
		herramienta.setJuicioexpertos(herramientasactaDTO.getJuicioexpertos());
		herramienta.setRecopilaciondatos(herramientasactaDTO.getRecopilaciondatos());
		herramienta.setHabilidades(herramientasactaDTO.getHabilidades());
		herramienta.setHerramientareuniones(herramientasactaDTO.getHabilidades());
		
		Herramientasacta herramientasactaNew = herramientasActasService.save(herramienta);
		
		HerramientasActaDTO herramientaDto = herramientasactaMapper.toherramientasActaDTO(herramientasactaNew);
		
		return ResponseEntity.ok().body(herramientaDto);
	}
	
}
