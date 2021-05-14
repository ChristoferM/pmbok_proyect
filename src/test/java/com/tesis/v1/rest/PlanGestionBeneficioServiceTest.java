package com.tesis.v1.rest;

import static org.junit.jupiter.api.Assertions.*;

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

import com.tesis.v1.domain.Entradacta;
import com.tesis.v1.domain.PlanGestionbeneficio;
import com.tesis.v1.service.EntradaActaService;
import com.tesis.v1.service.PlanGestionBeneficiosService;

@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
class PlanGestionBeneficioServiceTest {

	private final static Logger log = LoggerFactory.getLogger(PlanGestionBeneficioServiceTest.class);

	@Autowired
	PlanGestionBeneficiosService planGestionBeneficiosService;
	@Autowired
	EntradaActaService entradaActaService;

	@Test
	@Order(1)
	void save() throws Exception {
		log.info("save");
		PlanGestionbeneficio planesgestionbeneficio = new PlanGestionbeneficio();
		planesgestionbeneficio.setAcciones("test spring");
		planesgestionbeneficio.setComponentes("test spring");
		planesgestionbeneficio.setProdcutos("test spring");
		planesgestionbeneficio.setServicios("test spring");
		planesgestionbeneficio.setResultado("test spring");
		planGestionBeneficiosService.save(planesgestionbeneficio);
	}

	@Test
	@Order(2)
	void findById() throws Exception {
		planGestionBeneficiosService.findById(1);
	}

	@Test
	@Order(3)
	void update() throws Exception {
		Optional<Entradacta> actaOPC = entradaActaService.findById(2);
		if (actaOPC.isEmpty()) {
			fail("No hay registros asi que paila");

		} else {
			Entradacta entradacta = actaOPC.get();
			PlanGestionbeneficio planesgestionbeneficio = new PlanGestionbeneficio();
			planesgestionbeneficio.setAcciones("UPDATE setAcciones test spring");
			planesgestionbeneficio.setComponentes("UPDATE setProdcutos setComponentes test spring");
			planesgestionbeneficio.setProdcutos("UPDATE  setServicios test spring");
			planesgestionbeneficio.setServicios("UPDATE setServicios test spring");
			planesgestionbeneficio.setResultado("UPDATE setResultado test spring");
			planesgestionbeneficio.setId_plan_gb(1);
			planesgestionbeneficio.setEntradacta(entradacta);

			planGestionBeneficiosService.update(planesgestionbeneficio);
		}
	}

	@Test
	@Order(4)
	void findAll() throws Exception {
		planGestionBeneficiosService.findAll();
	}

	@Test
	@Order(5)
	void delete() throws Exception {
		planGestionBeneficiosService.deleteById(2);
	}

}
