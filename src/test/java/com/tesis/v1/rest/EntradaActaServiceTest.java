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

import com.tesis.v1.domain.Acta;
import com.tesis.v1.domain.Entradacta;
import com.tesis.v1.dto.ValidarActaDTO;
import com.tesis.v1.service.ActaService;
import com.tesis.v1.service.EntradaActaService;

@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
class EntradaActaServiceTest {

	private final static Logger log = LoggerFactory.getLogger(EntradaActaServiceTest.class);

	@Autowired
	EntradaActaService entradaActaService;

	@Autowired
	ActaService actaService;

	@Test
	void buscarData() throws Exception {
		Integer idProyecto = 1;
		log.info("Validando Acta");

		ValidarActaDTO validaciones = new ValidarActaDTO();
		log.info("validaciones realizadas");

		validaciones = entradaActaService.encontrarData(idProyecto);
		log.info("Resquest de validaciones");

		log.info(validaciones.getActa().toString());
		log.info(validaciones.getHerramientasValidate().toString());
		log.info(validaciones.getEntradactaValidate().toString());
		log.info(validaciones.getPlanValidate().toString());
		log.info(validaciones.getCasoNegocioValidate().toString());

	}

	@Test
	@Order(1)
	void save() throws Exception {
		Entradacta entradacta = new Entradacta();
		entradacta.setAcuerdos(" TESTE SPRING");
		entradacta.setFactores(" TEST SPRING");
		entradacta.setActivosprocesos(" TEST SPRING");
		entradaActaService.save(entradacta);

	}

	@Test
	@Order(2)
	void findById() throws Exception {
		Optional<Entradacta> actaOPC = entradaActaService.findById(2);
		Entradacta acta = actaOPC.get();
		log.info("--------------------");
		log.info("--------------------");
		log.info("ID DE LA ENTRADA" + acta.getIdentrada().toString());
		log.info("ACUERDOS DE LA ENTRADA" + acta.getAcuerdos());
		log.info("FACTORES DE LA ENTRADA" + acta.getFactores());
		log.info("ACTIVOS DE LA ENTRADA" + acta.getActivosprocesos());
		log.info("ID DE LA ACTA ALA QUE PERTENECE" + acta.getActas().getIdactas().toString());
		log.info("--------------------");
	}

	@Test
	@Order(3)
	void update() throws Exception {
		Entradacta entradacta = new Entradacta();
		Optional<Acta> actaOPC = actaService.findById(1);
		if (actaOPC.isEmpty()) {
			fail("No hay registros asi que paila");

		} else {
			Acta acta = actaOPC.get();
			log.info("ID  de las actas: " + acta.getIdactas().toString());
			log.info("Id reuniones : " + acta.getReuniones().getIdreuniones().toString());
			entradacta.setAcuerdos("UPDATE setAcuerdos TESTE SPRING");
			entradacta.setFactores("UPDATE setFactores TEST SPRING");
			entradacta.setActivosprocesos("UPDATE  setActivosprocesos TEST SPRING");
			entradacta.setIdentrada(2);
			entradacta.setActas(acta);
			entradaActaService.update(entradacta);

		}
	}

	@Test
	@Order(4)
	void findAll() throws Exception {

		for (Entradacta acta : entradaActaService.findAll()) {
			log.info("--------------------");
			log.info("ID DE LA ENTRADA" + acta.getIdentrada().toString());
			log.info("ACUERDOS DE LA ENTRADA" + acta.getAcuerdos());
			log.info("FACTORES DE LA ENTRADA" + acta.getFactores());
			log.info("ACTIVOS DE LA ENTRADA" + acta.getActivosprocesos());
			log.info("ID DE LA ACTA ALA QUE PERTENECE" + acta.getActas().getIdactas().toString());

			log.info("--------------------");

		}
	}

	@Test
	@Order(5)
	void delete() throws Exception {
		entradaActaService.deleteById(2);

	}

}
