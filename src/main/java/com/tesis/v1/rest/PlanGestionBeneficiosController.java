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

import com.tesis.v1.domain.entradacta;
import com.tesis.v1.domain.planesgestionbeneficios;
import com.tesis.v1.dto.planesgestionbeneficiosDTO;
import com.tesis.v1.mapper.planesgestionbeneficiosMapper;
import com.tesis.v1.service.EntradaActaService;
import com.tesis.v1.service.PlanGestionBeneficiosService;

@RestController // Servicio
@RequestMapping("/api/PlanGestionBeneficios") // Forma de llamar datos
@CrossOrigin
public class PlanGestionBeneficiosController {

	private final static Logger log = LoggerFactory.getLogger(PlanGestionBeneficiosController.class);

	@Autowired
	EntradaActaService entradaActaService;

	@Autowired
	PlanGestionBeneficiosService PlanGestionBeneficiosService;

	@Autowired
	planesgestionbeneficiosMapper planesgestionbeneficiosMapper;

	@RequestMapping("/finById/{planId}")
	public ResponseEntity<?> finById(@PathVariable("planId") Integer planId) throws Exception {
		/*
		 * planesgestionbeneficios planesgestionbeneficios0 = new
		 * planesgestionbeneficios();
		 */

		Optional<planesgestionbeneficios> planesgestionbeneficiosopc = PlanGestionBeneficiosService.findById(planId);
		log.info("Cargando ...");
		if (planesgestionbeneficiosopc.isEmpty()) {
			return ResponseEntity.ok().body("Error: No se encontro La referencia");

		}
		planesgestionbeneficios planesgestionbeneficios = planesgestionbeneficiosopc.get();

		planesgestionbeneficiosDTO planesgestionbeneficiosDTO = planesgestionbeneficiosMapper
				.toplanesGestionBeneficiosDTO(planesgestionbeneficios);

		log.info("*");
		return ResponseEntity.ok().body(planesgestionbeneficiosDTO);

	}
	
	@RequestMapping("/findByAll")
	public ResponseEntity<?> finByAll() throws Exception {
		// actas acta
		List<planesgestionbeneficios> planesgestionbeneficiosLIST = PlanGestionBeneficiosService.findAll();

		List<planesgestionbeneficiosDTO> planesgestionbeneficiosListDto = planesgestionbeneficiosMapper
				.toplanesGestionBeneficiosDTO(planesgestionbeneficiosLIST);

		return ResponseEntity.ok().body(planesgestionbeneficiosListDto);
	}

	@RequestMapping("/planGestionDelActa/{idProyecto}")
	public ResponseEntity<?> planGestionDelActa(@PathVariable("idProyecto") Integer idProyecto) throws Exception {
		// actas acta
		List<planesgestionbeneficios> planesgestionbeneficiosLIST = PlanGestionBeneficiosService.planGestionDelActa(idProyecto);

		List<planesgestionbeneficiosDTO> planesgestionbeneficiosListDto = planesgestionbeneficiosMapper
				.toplanesGestionBeneficiosDTO(planesgestionbeneficiosLIST);

		return ResponseEntity.ok().body(planesgestionbeneficiosListDto);
	}

	@RequestMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody planesgestionbeneficiosDTO planesgestionbeneficiosDTO)
			throws Exception {
		log.info("************************************ 1");
		/*
		private Integer idEntradaActa;
		--    private Integer id_plan_gb;
		private String acciones;
		private String componentes;
		private String prodcutos;
		private String servicios;
		private String resultado;
		 */
		planesgestionbeneficios planesgestionbeneficios = new planesgestionbeneficios();
		entradacta entradas = new entradacta();
		// planesgestionbeneficiosDTO planesgestionbeneficiosDTO = new
		// planesgestionbeneficiosDTO ();
		planesgestionbeneficios.setAcciones(planesgestionbeneficiosDTO.getAcciones());
		planesgestionbeneficios.setComponentes(planesgestionbeneficiosDTO.getComponentes());
		planesgestionbeneficios.setProdcutos(planesgestionbeneficiosDTO.getProdcutos());
		planesgestionbeneficios.setServicios(planesgestionbeneficiosDTO.getServicios());
		planesgestionbeneficios.setResultado(planesgestionbeneficiosDTO.getResultado());
		log.info("ACTA NUEMEOR: "+planesgestionbeneficiosDTO.getIdEntradaActa().toString() );
		entradas.setIdentrada(planesgestionbeneficiosDTO.getIdEntradaActa());
		log.info("ACTA NUEMEOR planes: "+entradas.getIdentrada().toString() );
		
		planesgestionbeneficios.setEntradacta(entradas);
		

		log.info("************************************ 2");

		planesgestionbeneficios planesgestionbeneficiosnew = PlanGestionBeneficiosService.save(planesgestionbeneficios);
		log.info("************************************ 3");
		planesgestionbeneficiosDTO planesgestionbeneficiosDTOnew = planesgestionbeneficiosMapper
				.toplanesGestionBeneficiosDTO(planesgestionbeneficiosnew);

		log.info("************************************ 4");
		return ResponseEntity.ok().body(planesgestionbeneficiosDTOnew);
	}

}
