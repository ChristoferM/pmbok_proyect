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

import com.tesis.v1.domain.actas;
import com.tesis.v1.domain.reuniones;
import com.tesis.v1.service.ActaService;
import com.tesis.v1.service.EntradaActaService;
import com.tesis.v1.service.HerramientasActasService;

@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
class ActaServiceTest {

	private final static Logger log = LoggerFactory.getLogger(ActaServiceTest.class);

	@Autowired
	ActaService actaService;

	@Autowired
	EntradaActaService entradaActaService;

	@Autowired
	HerramientasActasService herramientasActasService;

	@Test
	@Order(1)
	void save() throws Exception {
		log.info("GUARDANDADO ACTA");
		actas acta = new actas();
		//acta.setIdactas(2);
		reuniones  reuniones0= new reuniones();
		reuniones0.setIdreuniones(1);
		acta.setReuniones(reuniones0);
		actaService.save(acta);
		log.info("guardado");

	}

	@Test
	@Order(2)
	void findById() throws Exception {
		Optional<actas> actaOPC = actaService.findById(2);
		if (actaOPC.isEmpty()) {
			fail("No hay registros asi que paila");

		} else {
			actas acta = actaOPC.get();
			log.info("ID  de las actas: " + acta.getIdactas().toString());
			log.info("Id reuniones : " + acta.getReuniones().getIdreuniones().toString());

		}
		
		
	}

	@Test
	@Order(3)
	void update() throws Exception {
		actas acta = new actas();
		acta.setIdactas(2);
		reuniones  reuniones0= new reuniones();
		reuniones0.setIdreuniones(1);
		acta.setReuniones(reuniones0);
		
		actaService.update(acta);
	}

	@Test
	@Order(4)
	void findAll() throws Exception {
		for (actas acta : actaService.findAll()) {
			log.info("ID  de las actas: " + acta.getIdactas().toString());
			log.info("Id reuniones : " + acta.getReuniones().getIdreuniones().toString());
			
		}
		
	}
	@Test
	@Order(5)
	void delete() throws Exception {
		actas acta = new actas();
		acta.setIdactas(2);
		reuniones  reuniones0= new reuniones();
		reuniones0.setIdreuniones(1);
		acta.setReuniones(reuniones0);
		
		actaService.delete(acta);
	}

}
