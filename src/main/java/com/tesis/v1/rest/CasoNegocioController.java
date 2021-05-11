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

import com.tesis.v1.domain.casonegocio;
import com.tesis.v1.domain.entradacta;
import com.tesis.v1.dto.casonegocioDTO;
import com.tesis.v1.mapper.casonegocioMapper;
import com.tesis.v1.service.CasoNegocioService;
import com.tesis.v1.service.EntradaActaService;

@RestController // Servicio
@RequestMapping("/api/CasoNegocio") // Forma de llamar datos
@CrossOrigin
public class CasoNegocioController {

	private final static Logger log = LoggerFactory.getLogger(CasoNegocioController.class);

	@Autowired
	EntradaActaService entradaActaService ; 
	
	@Autowired
	CasoNegocioService CasoNegocioService;
	
	@Autowired
	casonegocioMapper casonegocioMapper;
	
	@RequestMapping("/finById/{casoId}")
	public ResponseEntity<?> finById(@PathVariable("casoId") Integer casoId)throws Exception{
		//casonegocio casonegocio0 = new casonegocio (); 
		Optional<casonegocio> casonegocioopc = CasoNegocioService.findById(casoId);
		
		log.info("Cargando ...");
		if( casonegocioopc.isEmpty()) {
			return ResponseEntity.ok().body("Error: No se enco	ntro La referencia");
			
		}
		casonegocio casonegocio = casonegocioopc.get();
		
		casonegocioDTO casonegocioDTO  = casonegocioMapper.tocasoNegocioDTO(casonegocio);
		casonegocioDTO.setIdEntradaActa(casonegocio.getEntradacta().getIdentrada()); 
		log.info("*");
		return ResponseEntity.ok().body(casonegocioDTO);
		
	}
	
	@RequestMapping("/casoNegocioDelActa/{idProyecto}")
	public ResponseEntity<?> casoNegocioDelActa(@PathVariable("idProyecto") Integer idProyecto) throws Exception{
		
		List<casonegocio> casonegocioLIST= CasoNegocioService.casoNegocioDelActa(idProyecto);
		
		List<casonegocioDTO> casonegocioDTO = casonegocioMapper.tocasoNegocioDTO(casonegocioLIST);
		
		return ResponseEntity.ok().body(casonegocioDTO);
	}
	
	@RequestMapping("/findByAll")
	public ResponseEntity<?> finByAll() throws Exception{
		
		List<casonegocio> casonegocioLIST= CasoNegocioService.findAll();
		
		List<casonegocioDTO> casonegocioDTO = casonegocioMapper.tocasoNegocioDTO(casonegocioLIST);
		
		return ResponseEntity.ok().body(casonegocioDTO);
	}
	
	
	@RequestMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody casonegocioDTO casonegocioDTO)  throws Exception{
		log.info("************************************ 1");
		/*
		private Integer idEntradaActa;
		private Integer id_caso_negocio;
		private String metas;
		private String objetivos;
		private String incidentes;
		private String oportunidades;
		*/
		casonegocio casonegocio = new casonegocio ();
		entradacta entradas = new entradacta();
		casonegocio.setMetas(casonegocioDTO.getMetas());
		casonegocio.setObjetivos(casonegocioDTO.getObjetivos());
		casonegocio.setIncidentes(casonegocioDTO.getIncidentes());
		casonegocio.setOportunidades(casonegocioDTO.getOportunidades());
		entradas.setIdentrada(casonegocioDTO.getIdEntradaActa());
		casonegocio.setEntradacta(entradas);
			
		log.info("************************************ 2");
		
		casonegocio casonegocionew  = CasoNegocioService.save(casonegocio);
		
		
		log.info("************************************ 3");
		casonegocioDTO casonegocioDTOnew = casonegocioMapper.tocasoNegocioDTO(casonegocionew);
		
		log.info("************************************ 4");
		return ResponseEntity.ok().body(casonegocioDTOnew);
	}
	
	
}
