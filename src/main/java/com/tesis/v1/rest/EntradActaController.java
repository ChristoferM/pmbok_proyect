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
import com.tesis.v1.domain.entradacta;
import com.tesis.v1.domain.reuniones;
import com.tesis.v1.dto.actasDTO;
import com.tesis.v1.dto.entradactaDTO;
import com.tesis.v1.mapper.entradactaMapper;
import com.tesis.v1.service.ActaService;
import com.tesis.v1.service.EntradaActaService;

@RestController // Servicio
@RequestMapping("/api/EntradasActa") // Forma de llamar datos
@CrossOrigin
public class EntradActaController {
	private final static Logger log = LoggerFactory.getLogger(EntradActaController.class);
	
	@Autowired
	EntradaActaService entradaActaService ; 
	
	@Autowired
	ActaService actaService;
	
	@Autowired
	entradactaMapper entradactaMapper;
	
	@RequestMapping("/finById/{entradaId}")
	public ResponseEntity<?> finById(@PathVariable("entradaId") Integer entradaId)throws Exception{
		
		Optional<entradacta> entradactaopc = entradaActaService.findById(entradaId);
		log.info("Cargando ...");
		if( entradactaopc.isEmpty()) {
			return ResponseEntity.ok().body("Error: No se encontro La referencia");
			
		}
		entradacta entradActa = entradactaopc.get();
		entradactaDTO entradactaDTO  = entradactaMapper.toEntradActaDTO(entradActa);
		log.info("*");
		return ResponseEntity.ok().body(entradactaDTO);
		
	}
	@RequestMapping("/findByAll")
	public ResponseEntity<?> finByAll() throws Exception{
		//actas acta
		List<entradacta> entradactaLIST= entradaActaService.findAll();
		
		List<entradactaDTO> entradactaListDto = entradactaMapper.toEntradActaDTO(entradactaLIST);
		
		return ResponseEntity.ok().body(entradactaListDto);
	}
	@RequestMapping("/entradaDelActa/{idProyecto}")
	public ResponseEntity<?> entradaDelActa(@PathVariable("idProyecto") Integer idProyecto) throws Exception{
		//actas acta
		List<entradacta> entradactaLIST= entradaActaService.entradaDelActa(idProyecto);
		
		List<entradactaDTO> entradactaListDto = entradactaMapper.toEntradActaDTO(entradactaLIST);
		
		return ResponseEntity.ok().body(entradactaListDto);
	}
	
	
	@RequestMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody entradactaDTO entradactaDTO)  throws Exception{
		log.info("************************************ 1");
		/*
		 * private Integer idActa;
		private Integer identrada ;
		private String acuerdos ;
		private String factores;
		private String activosprocesos ;
		*/
		actas acta =new actas();
		acta.setIdactas(entradactaDTO.getIdActa());
		entradacta entradas = new entradacta();
		entradas.setActas(acta);
		entradas.setAcuerdos(entradactaDTO.getAcuerdos());
		entradas.setFactores(entradactaDTO.getFactores());
		entradas.setActivosprocesos(entradactaDTO.getActivosprocesos());
			
		log.info("************************************ 2");
		
		entradacta entradasnew  = entradaActaService.save(entradas);
		log.info("************************************ 3");
		entradactaDTO entradactaDTOnew = entradactaMapper.toEntradActaDTO(entradasnew);
		
		log.info("************************************ 4");
		return ResponseEntity.ok().body(entradactaDTOnew);
	}
	
	
	
}
