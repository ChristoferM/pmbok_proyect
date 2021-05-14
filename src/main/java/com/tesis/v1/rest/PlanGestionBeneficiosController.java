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

import com.tesis.v1.domain.Entradacta;
import com.tesis.v1.domain.PlanGestionbeneficio;
import com.tesis.v1.dto.PlanGestionBeneficioDTO;
import com.tesis.v1.service.EntradaActaService;
import com.tesis.v1.service.PlanGestionBeneficiosService;
import com.tesis.v1.mapper.PlanGestionBeneficioMapper;

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
	PlanGestionBeneficioMapper planesgestionbeneficiosMapper;

	@RequestMapping("/finById/{planId}")
	public ResponseEntity<?> finById(@PathVariable("planId") Integer planId) throws Exception {
		/*
		 * PlanGestionbeneficio planesgestionbeneficios0 = new
		 * PlanGestionbeneficio();
		 */

		Optional<PlanGestionbeneficio> planesgestionbeneficiosopc = PlanGestionBeneficiosService.findById(planId);
		log.info("Cargando ...");
		if (planesgestionbeneficiosopc.isEmpty()) {
			return ResponseEntity.ok().body("Error: No se encontro La referencia");

		}
		PlanGestionbeneficio planesgestionbeneficios = planesgestionbeneficiosopc.get();

		PlanGestionBeneficioDTO planesgestionbeneficiosDTO = planesgestionbeneficiosMapper
				.toplanesGestionBeneficiosDTO(planesgestionbeneficios);

		log.info("*");
		return ResponseEntity.ok().body(planesgestionbeneficiosDTO);

	}
	
	@RequestMapping("/findByAll")
	public ResponseEntity<?> finByAll() throws Exception {
		// actas acta
		List<PlanGestionbeneficio> planesgestionbeneficiosLIST = PlanGestionBeneficiosService.findAll();

		List<PlanGestionBeneficioDTO> planesgestionbeneficiosListDto = planesgestionbeneficiosMapper
				.toplanesGestionBeneficiosDTO(planesgestionbeneficiosLIST);

		return ResponseEntity.ok().body(planesgestionbeneficiosListDto);
	}

	@RequestMapping("/planGestionDelActa/{idProyecto}")
	public ResponseEntity<?> planGestionDelActa(@PathVariable("idProyecto") Integer idProyecto) throws Exception {
		// actas acta
		List<PlanGestionbeneficio> planesgestionbeneficiosLIST = PlanGestionBeneficiosService.planGestionDelActa(idProyecto);

		List<PlanGestionBeneficioDTO> planesgestionbeneficiosListDto = planesgestionbeneficiosMapper
				.toplanesGestionBeneficiosDTO(planesgestionbeneficiosLIST);

		return ResponseEntity.ok().body(planesgestionbeneficiosListDto);
	}

	@RequestMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody PlanGestionBeneficioDTO planesgestionbeneficiosDTO)
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
		PlanGestionbeneficio planesgestionbeneficios = new PlanGestionbeneficio();
		Entradacta entradas = new Entradacta();
		// PlanGestionBeneficioDTO PlanGestionBeneficioDTO = new
		// PlanGestionBeneficioDTO ();
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

		PlanGestionbeneficio planesgestionbeneficiosnew = PlanGestionBeneficiosService.save(planesgestionbeneficios);
		log.info("************************************ 3");
		PlanGestionBeneficioDTO planesgestionbeneficiosDTOnew = planesgestionbeneficiosMapper
				.toplanesGestionBeneficiosDTO(planesgestionbeneficiosnew);

		log.info("************************************ 4");
		return ResponseEntity.ok().body(planesgestionbeneficiosDTOnew);
	}

}
