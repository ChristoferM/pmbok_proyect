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

import com.tesis.v1.domain.Reunion;
import com.tesis.v1.domain.pdp.Entradas;
import com.tesis.v1.domain.pga.entradapga;
import com.tesis.v1.domain.pga.pga;
import com.tesis.v1.dto.pga.ValidarPgaDTO;
import com.tesis.v1.dto.pga.entradapgaDTO;
import com.tesis.v1.dto.pga.herramientaspga;
import com.tesis.v1.dto.pga.pgaDTO;
import com.tesis.v1.mapper.pgaEntradaMapper;
import com.tesis.v1.mapper.pgaMapper;
import com.tesis.v1.service.pgaEntradasServices;
import com.tesis.v1.service.pgaHerramientasService;
import com.tesis.v1.service.pgaServices;

@RestController // Servicio
@RequestMapping("/api/pga") // Forma de llamar datos
@CrossOrigin
public class pgaController {

	@Autowired
	pgaServices pgaServices;

	@Autowired
	pgaHerramientasService pgaHerramientasService;

	@Autowired
	pgaEntradasServices pgaEntradasServices;

	@Autowired
	pgaMapper pgaMapper;

	@Autowired
	com.tesis.v1.mapper.pgaherramientasMapper pgaherramientasMapper;

	@Autowired
	pgaEntradaMapper pgaEntradaMapper;

	private final static Logger log = LoggerFactory.getLogger(pgaController.class);

	@RequestMapping("/validarPga/{idProyecto}")
	public ResponseEntity<?> validarPdp(@PathVariable("idProyecto") Integer idProyecto) throws Exception {
		ValidarPgaDTO validar = new ValidarPgaDTO();
		validar = pgaServices.encontrarData(idProyecto);
		return ResponseEntity.ok().body(validar);
	}

	@RequestMapping("/BuscarPgaPorIdProyecto/{idProyecto}") // pdpServices
	public ResponseEntity<?> BuscarPgaPorIdProyecto(@PathVariable("idProyecto") Integer idProyecto) throws Exception {
		log.info("*****************");
		pga pga = new pga();
		pga =pgaServices.BuscarPgaPorIdProyecto(idProyecto);
		log.info("*****************");
		pgaDTO pgaDTO = new pgaDTO() ;
		pgaDTO.setIdpga(pga.getIdpga());
		pgaDTO.setIdreuniones(pga.getReuniones().getIdreuniones());
		return ResponseEntity.ok().body(pgaDTO);
	}
	
	@RequestMapping("/savePgaPorIdProyecto/{idProyecto}")
	public ResponseEntity<?> savePgaPorIdProyecto(@PathVariable("idProyecto") Integer idProyecto) throws Exception {
		pga pga = new pga();
		pga =pgaServices.savePgaPorIdProyecto(idProyecto);
		log.info("\n \n \n");
		log.info(pga.getIdpga().toString());
		log.info(pga.getReuniones().getIdreuniones().toString());
		log.info("\n \n \n");
		pgaDTO pgaDTO = new pgaDTO() ;
		pgaDTO.setIdpga(pga.getIdpga());
		pgaDTO.setIdreuniones(pga.getReuniones().getIdreuniones());
		return ResponseEntity.ok().body(pgaDTO);
	}

	@RequestMapping("/savePga")
	public ResponseEntity<?> savePga(@Valid @RequestBody pgaDTO pgaDTO) throws Exception {
		log.info("GUARDANDADO PGA");
		Reunion reunion = new Reunion();
		pga pga = new pga();
		reunion.setIdreuniones(pgaDTO.getIdreuniones());
		pga.setReuniones(reunion);

		pga = pgaServices.save(pga);
		pgaDTO.setIdpga(pga.getIdpga());
		pgaDTO.setIdreuniones(pga.getReuniones().getIdreuniones());

		return ResponseEntity.ok().body(pgaDTO);
	}

	@RequestMapping("/saveHerramientasPga")
	public ResponseEntity<?> saveHerramientasPga(@Valid @RequestBody herramientaspga herramientasDTO) throws Exception {
		log.info("GUARDANDADO HERRAMIENTA PGA");
		pga pga = new pga();
		log.info("**************************11");
		com.tesis.v1.domain.pga.herramientaspga herramientaspga = new com.tesis.v1.domain.pga.herramientaspga();
		log.info("**************************22");
		
		pga.setIdpga(herramientasDTO.getIdpdp());
		herramientaspga.setPga(pga);		
		herramientaspga.setAnalisis(herramientasDTO.getAnalisis());
		herramientaspga.setJuicioexpertos(herramientasDTO.getJuicioexpertos());
		log.info("**************************33");
		herramientaspga = pgaHerramientasService.save(herramientaspga);
		log.info("**************************44");
		herramientasDTO = pgaherramientasMapper.toHerramientaPGA(herramientaspga);
		herramientasDTO.setIdpdp(herramientaspga.getPga().getIdpga());
		log.info("**************************44");
		return ResponseEntity.ok().body(herramientasDTO);
	}

	@RequestMapping("/saveEntradasPga")
	public ResponseEntity<?> saveEntradasPga(@Valid @RequestBody entradapgaDTO entradasDTO) throws Exception {
		log.info("GUARDANDADO ENTRADAS PGA");
		/*
		 * log.info(entradasDTO.getIdpga().toString());
		 * log.info(entradasDTO.getEstandares());
		 * log.info(entradasDTO.getObjetivocalidad()); log.info(entradasDTO.getCiclo());
		 * log.info(entradasDTO.getEnfoque());
		 * log.info(entradasDTO.getActivosprocesos());
		 */

		pga pga = new pga();
		entradapga entradapga = new entradapga();
		log.info("***********1");
		entradapga.setEstandares(entradasDTO.getEstandares());
		entradapga.setObjetivocalidad(entradasDTO.getObjetivocalidad());
		entradapga.setCiclo(entradasDTO.getCiclo());
		//entradapga.setEnfoque(entradasDTO.getEnfoque());
		entradapga.setActivosprocesos(entradasDTO.getActivosprocesos());
		// pga.setIdpga(entradasDTO.getIdpdp());
		log.info("***********2");
		pga.setIdpga(entradasDTO.getIdpga());
		entradapga.setPga(pga);
		log.info("***********2");

		/*
		 * log.info(entradapga.getActivosprocesos()); log.info(entradapga.getEnfoque());
		 * log.info(entradapga.getCiclo()); log.info(entradapga.getObjetivocalidad());
		 * log.info(entradapga.getEstandares());
		 * log.info(entradapga.getPga().getIdpga().toString());
		 */
		entradapga = pgaEntradasServices.save(entradapga);
		entradasDTO = pgaEntradaMapper.toHerramientasPGADTO(entradapga);
		entradasDTO.setIdpga(entradapga.getPga().getIdpga());
		return ResponseEntity.ok().body(entradasDTO);
	}

	// --- Controllers de buscar
	@RequestMapping("/BuscarPga/{id}") // pdpServices
	public ResponseEntity<?> findByIdPga(@PathVariable("id") Integer id) throws Exception {
		Optional<pga> pgaOptional = pgaServices.findById(id);

		if (pgaOptional.isEmpty()) {

			return ResponseEntity.ok().body("Error: No se encontro Usuario");
		}
		pga pga = pgaOptional.get();
		pgaDTO pgaDTO = new pgaDTO();
		log.info(pga.getIdpga().toString());
		pgaDTO.setIdpga(pga.getIdpga());
		pgaDTO.setIdreuniones(pga.getReuniones().getIdreuniones());
		return ResponseEntity.ok().body(pgaDTO);
	}

	@RequestMapping("/BuscarHerramientasPdp/{id}") // pdpServices
	public ResponseEntity<?> findHerramientaByIdPga(@PathVariable("id") Integer id) throws Exception {

		Optional<com.tesis.v1.domain.pga.herramientaspga> pgaHerramientasOptional = pgaHerramientasService.findById(id);

		if (pgaHerramientasOptional.isEmpty()) {

			return ResponseEntity.ok().body("Error: No se encontro Usuario");
		}
		com.tesis.v1.domain.pga.herramientaspga herramientaspga = pgaHerramientasOptional.get();
		herramientaspga herramientasDTO = new herramientaspga();
		herramientasDTO = pgaherramientasMapper.toHerramientaPGA(herramientaspga);
		herramientasDTO.setIdpdp(herramientaspga.getPga().getIdpga());

		return ResponseEntity.ok().body(herramientasDTO);
	}

	@RequestMapping("/BuscarEntradasPdp/{id}") // pdpServices
	public ResponseEntity<?> findEntradaByIdPga(@PathVariable("id") Integer id) throws Exception {

		Optional<entradapga> pgaEntradassOptional = pgaEntradasServices.findById(id);

		if (pgaEntradassOptional.isEmpty()) {

			return ResponseEntity.ok().body("Error: No se encontro Usuario");
		}
		entradapga entradapga = pgaEntradassOptional.get();
		entradapgaDTO entradapgaDTO = pgaEntradaMapper.toHerramientasPGADTO(entradapga);
		entradapgaDTO.setIdpga(entradapga.getPga().getIdpga());
		return

		ResponseEntity.ok().body(entradapgaDTO);
	}

}
