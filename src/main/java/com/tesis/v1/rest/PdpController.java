package com.tesis.v1.rest;

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
import com.tesis.v1.domain.reuniones;
import com.tesis.v1.domain.pdp.entradas;
import com.tesis.v1.domain.pdp.herramientas;
import com.tesis.v1.domain.pdp.pdp;
import com.tesis.v1.dto.actasDTO;
import com.tesis.v1.dto.pdp.entradasDTO;
import com.tesis.v1.dto.pdp.herramientasDTO;
import com.tesis.v1.dto.pdp.pdpDTO;
import com.tesis.v1.mapper.pdpEntradasMapper;
import com.tesis.v1.mapper.pdpHerramientasMapper;
import com.tesis.v1.mapper.pdpMapper;
import com.tesis.v1.service.entradasPdpService;
import com.tesis.v1.service.herramientasServicePdp;
import com.tesis.v1.service.pdpService;

@RestController // Servicio
@RequestMapping("/api/pdp") // Forma de llamar datos
@CrossOrigin
public class PdpController {
	
	private final static Logger log = LoggerFactory.getLogger(PdpController.class);
	
	
	@Autowired
	pdpService pdpServices;
	
	@Autowired
	entradasPdpService entradasPdpServices;
	
	@Autowired
	herramientasServicePdp herramientasServicePdps;
	
	@Autowired
	pdpMapper pdpMapper;
	
	@Autowired
	pdpHerramientasMapper pdpHerramientasMapper;
	
	@Autowired
	pdpEntradasMapper pdpEntradasMapper;
	
	@RequestMapping("/savePdp")
	public ResponseEntity<?> savePdp(@Valid @RequestBody pdpDTO pdpDTO)  throws Exception{
		log.info("GUARDANDADO ");
		pdp pdp = new pdp();
		reuniones  reuniones0= new reuniones();
		reuniones0.setIdreuniones(pdpDTO.getIdreuniones());
		
		pdp.setReuniones(reuniones0);
		pdpDTO pdp0 = new pdpDTO();
		pdp =pdpServices.save(pdp);
		
		pdp0.setIdpdp(pdp.getIdpdp());
		pdp0.setIdreuniones(pdp.getReuniones().getIdreuniones());
		return ResponseEntity.ok().body(pdp0);
	}
	
	
	@RequestMapping("/saveHerramientasPdp")
	public ResponseEntity<?> saveHerramientasPdp(@Valid @RequestBody herramientasDTO herramientasDTO)  throws Exception{
		log.info("GUARDANDADO ");
		pdp pdp = new pdp();
		herramientas herramientasPdp= new herramientas();
		pdp.setIdpdp(
				herramientasDTO.getIdpdp());
		herramientasPdp.setPdp(pdp);
		
		herramientasPdp.setJuicioexpertos(
				herramientasDTO.getJuicioexpertos());
		
		herramientasPdp.setRecopilaciondatos(
				herramientasDTO.getRecopilaciondatos());
		
		herramientasPdp.setHabilidades(
				herramientasDTO.getHabilidades());
		
		herramientasPdp.setHerramientareuniones(
				herramientasDTO.getHerramientareuniones());
		//herramientasacta herramientasactaNew = herramientasActasService.save(herramienta);
		
		herramientasPdp = herramientasServicePdps.save(herramientasPdp);
		herramientasDTO herramientasDTOs = pdpHerramientasMapper.toherramientaDTO(herramientasPdp);
		
		return ResponseEntity.ok().body(herramientasDTOs);
	}
	
	@RequestMapping("/saveEntradasPdp")
	public ResponseEntity<?> saveEntradasPdp(@Valid @RequestBody entradasDTO entradasDTO)  throws Exception{
		
		// pdpEntradasMapper
		//entradasPdpServices
		log.info("GUARDANDADO ");
		pdp pdp = new pdp();
		pdp.setIdpdp(entradasDTO.getIdpdp());
		entradas entradasPdp =new entradas();
		
		entradasPdp.setPdp(pdp);
		entradasPdp.setOtrosprocesos(entradasDTO.getOtrosprocesos());
		entradasPdp.setFactoresambientales( entradasDTO.getFactoresambientales()); 
		entradasPdp.setActivosprocesos(entradasDTO.getActivosprocesos());
		
		entradasPdp = entradasPdpServices.save(entradasPdp);
		
		entradasDTO=pdpEntradasMapper.toEntradasPdpDTO(entradasPdp);
		log.info(entradasPdp.getIdentradapdp().toString());
		entradasDTO.setIdentradapdp(entradasPdp.getIdentradapdp());
		entradasDTO.setIdpdp(entradasPdp.getPdp().getIdpdp());
		log.info(entradasPdp.getPdp().getIdpdp().toString());
		return ResponseEntity.ok().body(entradasDTO);
	}
	
	
	// --- Controllers de buscar 
	@RequestMapping("/BuscarPdp/{id}")//pdpServices
	public ResponseEntity<?> findByIdPdp(@PathVariable("id") Integer id)throws Exception{
		//
		Optional<pdp> pdpOpt = pdpServices.findById(id);
		log.info("Cargando ...");
		if( pdpOpt.isEmpty()) {
			return ResponseEntity.ok().body("Error: No se encontro Usuario");
			
		}
		pdp pdps = pdpOpt.get();
		pdpDTO pdpDTOs = pdpMapper.toPdpDTO(pdps);
		log.info(pdps.getIdpdp().toString());
		pdpDTOs.setIdpdp(pdps.getIdpdp());
		pdpDTOs.setIdreuniones(pdps.getReuniones().getIdreuniones());
		log.info("*");
		return ResponseEntity.ok().body(pdpDTOs);
	}
	
	@RequestMapping("/BuscarHerramientasPdp/{id}")//herramientasServicePdp
	public ResponseEntity<?> findByIdHerramientasPdp(@PathVariable("id") Integer id)throws Exception{
		//herramientasDTO
		//herramientas
		Optional<herramientas> herramientaspdpOpt = herramientasServicePdps.findById(id);
		log.info("Cargando ...");
		if( herramientaspdpOpt.isEmpty()) {
			return ResponseEntity.ok().body("Error: No se encontro El Dato");
			
		}
		herramientas herramientasPdp = herramientaspdpOpt.get();
		herramientasDTO herramientasDTOs = pdpHerramientasMapper.toherramientaDTO(herramientasPdp);
		//log.info(herramientasPdp.getPdp().getIdpdp().toString());
		herramientasDTOs.setIdpdp(herramientasPdp.getPdp().getIdpdp());
		return ResponseEntity.ok().body(herramientasDTOs);
	}
	
	@RequestMapping("/BuscarEntradasPdp/{id}")// entradasPdpServices
	public ResponseEntity<?> findByIdEntradasPdp(@PathVariable("id") Integer id)throws Exception{
		//entradasPdpServices
		//pdpEntradasMapper
		//entradasDTO
		//entradas

		Optional<entradas> entradaspdpOpt = entradasPdpServices.findById(id);
		log.info("Cargando ...");
		if( entradaspdpOpt.isEmpty()) {
			return ResponseEntity.ok().body("Error: No se encontro El Dato");
			
		}
		entradas entradasPdp = entradaspdpOpt.get();
		entradasDTO entradasDTOs = pdpEntradasMapper.toEntradasPdpDTO(entradasPdp);
		//log.info(herramientasPdp.getPdp().getIdpdp().toString());
		entradasDTOs.setIdpdp(entradasPdp.getPdp().getIdpdp());
		return ResponseEntity.ok().body(entradasDTOs);
	}
}
