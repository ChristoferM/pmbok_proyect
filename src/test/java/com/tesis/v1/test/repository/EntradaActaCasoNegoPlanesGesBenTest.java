package com.tesis.v1.test.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.tesis.v1.domain.casonegocio;
import com.tesis.v1.domain.entradacta;
import com.tesis.v1.domain.planesgestionbeneficios;
import com.tesis.v1.repository.casonegocioRepository;
import com.tesis.v1.repository.entradactaRepository;
import com.tesis.v1.repository.planesgestionbeneficiosRepository;

@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
class EntradaActaCasoNegoPlanesGesBenTest {

	private final static Logger log = LoggerFactory.getLogger(EntradaActaCasoNegoPlanesGesBenTest.class);

	private final static String email = "email@test.com.co";

	private final static Integer idusuario = 1;

	private final static Integer idgrupo = 2;

	@Autowired
	entradactaRepository entradactaRepository;

	@Autowired
	casonegocioRepository casonegocioRepository;

	@Autowired
	planesgestionbeneficiosRepository planesgestionbeneficiosRepository;

	// ------------------------ ENTRADA ACTA
	@Test
	@Transactional
	@Order(1)
	void findByIdEntrada() {
		log.info("-> buscar ID de Reuniones");
		Optional<entradacta> entradaactaOpcioan = entradactaRepository.findById(idgrupo);

		assertTrue(entradaactaOpcioan.isPresent(), "No existe una entreada de acta con ese ID");

		entradacta entradacta = entradaactaOpcioan.get();

		log.info("ID DE ENTRADA : " + entradacta.getIdentrada().toString());
		log.info(" acuerdos DE ENTRADA : " + entradacta.getAcuerdos());
		log.info(" factores DE ENTRADA : " + entradacta.getFactores());
		log.info(" activosprocesos DE ENTRADA : " + entradacta.getActivosprocesos());

	}

	@Test
	@Transactional
	@Order(2)
	void findAllEntrada() {
		log.info("-> buscar ID de Reuniones");
		List<entradacta> entradactas = entradactaRepository.findAll();

		for (entradacta entradacta : entradactas) {
			log.info("ID DE ENTRADA : " + entradacta.getIdentrada().toString());
			log.info(" acuerdos DE ENTRADA : " + entradacta.getAcuerdos());
			log.info(" factores DE ENTRADA : " + entradacta.getFactores());
			log.info(" activosprocesos DE ENTRADA : " + entradacta.getActivosprocesos());
		}

	}

	// -------------------------- CAso de negocio HIJO DE ENTRADA ACTA
	@Test
	@Transactional
	@Order(3)
	void findByIdCasoNegocio() {
		log.info("-> buscar ID de Reuniones");
		Optional<casonegocio> casonegocioOpcional = casonegocioRepository.findById(idgrupo);

		assertTrue(casonegocioOpcional.isPresent(), "No existe una entreada de acta con ese ID");

		casonegocio casonegocio = casonegocioOpcional.get();
		log.info("ID DE CASO DE NEGOCIOS"+ casonegocio.getId_caso_negocio().toString());
		log.info("metas DE CASO DE NEGOCIOS"+ casonegocio.getMetas());
		log.info("objetivos DE CASO DE NEGOCIOS"+ casonegocio.getObjetivos());
		log.info("incidentes DE CASO DE NEGOCIOS"+ casonegocio.getIncidentes());
		log.info("oportunidades DE CASO DE NEGOCIOS"+ casonegocio.getOportunidades());
		log.info("identrada DE CASO DE NEGOCIOS"+ casonegocio.getEntradacta().getIdentrada().toString());

	}

	@Test
	@Transactional
	@Order(4)
	void findAllCasoNegocio() {
		log.info("-> buscar ID de Reuniones");
		List<casonegocio> CasoNegocioaOpcioan = casonegocioRepository.findAll();

		for (casonegocio casonegocio : CasoNegocioaOpcioan) {
			log.info("ID DE CASO DE NEGOCIOS"+ casonegocio.getId_caso_negocio().toString());
			log.info("metas DE CASO DE NEGOCIOS"+ casonegocio.getMetas());
			log.info("objetivos DE CASO DE NEGOCIOS"+ casonegocio.getObjetivos());
			log.info("incidentes DE CASO DE NEGOCIOS"+ casonegocio.getIncidentes());
			log.info("oportunidades DE CASO DE NEGOCIOS"+ casonegocio.getOportunidades());
			log.info("identrada DE CASO DE NEGOCIOS"+ casonegocio.getEntradacta().getIdentrada().toString());
		}

	}

	// -------------------------- PLAN GESTION DE BENERIFICIADOS HIJO DE ENTRADA
	// ACTA

	@Test
	@Transactional
	@Order(5)
	void findByIdPlanesGestionBene() {
		log.info("-> buscar ID de Reuniones");
		Optional<planesgestionbeneficios> planesgestionbeneficiosOpcioan = planesgestionbeneficiosRepository
				.findById(idusuario);

		assertTrue(planesgestionbeneficiosOpcioan.isPresent(), "No existe una entreada de acta con ese ID");

		planesgestionbeneficios planesgestionbeneficios = planesgestionbeneficiosOpcioan.get();

		log.info("ID DE PLAN DE BEFENEFICIOS"+ planesgestionbeneficios.getId_plan_gb().toString());
		log.info("acciones DE PLAN DE BEFENEFICIO"+ planesgestionbeneficios.getAcciones());
		log.info(" componentes DE PLAN DE BEFENEFICIO"+ planesgestionbeneficios.getComponentes());
		log.info("prodcutos D DE PLAN DE BEFENEFICIO"+ planesgestionbeneficios.getProdcutos());
		log.info(" servicios DE PLAN DE BEFENEFICIO"+ planesgestionbeneficios.getServicios());
		log.info(" resultado DE PLAN DE BEFENEFICIO"+ planesgestionbeneficios.getResultado());
		log.info(" identrada DE PLAN DE BEFENEFICIO"+
				planesgestionbeneficios.getEntradacta().getIdentrada().toString());

	}

	@Test
	@Transactional
	@Order(6)
	void findAllPlanesGestionBene() {
		log.info("-> buscar ID de Reuniones");
		List<planesgestionbeneficios> planesgestionbeneficiosOptinal = planesgestionbeneficiosRepository.findAll();

		for (planesgestionbeneficios planesgestionbeneficios : planesgestionbeneficiosOptinal) {
			log.info("ID DE PLAN DE BEFENEFICIOS"+ planesgestionbeneficios.getId_plan_gb().toString());
			log.info("acciones DE PLAN DE BEFENEFICIO"+ planesgestionbeneficios.getAcciones().toString());
			log.info("componentes DE PLAN DE BEFENEFICIO"+ planesgestionbeneficios.getComponentes());
			log.info("prodcutos D DE PLAN DE BEFENEFICIO"+ planesgestionbeneficios.getProdcutos());
			log.info("servicios DE PLAN DE BEFENEFICIO"+ planesgestionbeneficios.getServicios());
			log.info("resultado DE PLAN DE BEFENEFICIO"+ planesgestionbeneficios.getResultado());
			log.info("identrada DE PLAN DE BEFENEFICIO"+
					planesgestionbeneficios.getEntradacta().getIdentrada().toString());
		}
	}
}
