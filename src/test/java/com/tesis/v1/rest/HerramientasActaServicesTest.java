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
import com.tesis.v1.domain.herramientasacta;
import com.tesis.v1.service.ActaService;
import com.tesis.v1.service.HerramientasActasService;

@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
class HerramientasActaServicesTest {

	private final static Logger log = LoggerFactory.getLogger(HerramientasActaServicesTest.class);

	@Autowired
	HerramientasActasService herramientasActasService;

	@Autowired
	ActaService actaService;

	@Test
	@Order(1)
	void save() throws Exception {
		herramientasacta herramientas = new herramientasacta();
	}

	@Test
	@Order(2)
	void findById() throws Exception {

		Optional<herramientasacta> herramientasOp = herramientasActasService.findById(1);
		if (herramientasOp.isEmpty()) {
			fail("No hay registros asi que paila");

		} else {
			herramientasacta herramientass = herramientasOp.get();
			log.info("Id HERRAMIENTAS DEL ACTA : " + herramientass.getIdherramienta().toString());
			log.info("JUICIO DE EXPERTOS : " + herramientass.getJuicioexpertos());
			log.info("RECOMILACIONES DEL ACTA: " + herramientass.getRecopilaciondatos());
			log.info("HABILIDADES DEL ACTA: " + herramientass.getHabilidades());
			log.info("HERRAMIENTAS DE REUNIONES DEL ACTA: " + herramientass.getHerramientareuniones());
			log.info("ID DEL DEL ACTA: " + herramientass.getActas().getIdactas().toString());

			//

		}

	}

	@Test
	@Order(3)
	void update() throws Exception {
		herramientasacta herramientas = new herramientasacta();
		Optional<actas> actaOPC = actaService.findById(1);
		if (actaOPC.isEmpty()) {
			fail("No hay registros asi que paila");

		} else {
			actas acta = actaOPC.get();
			log.info("ID  de las actas: " + acta.getIdactas().toString());
			log.info("Id reuniones : " + acta.getReuniones().getIdreuniones().toString());

			// actas acta = new a
			// herramientas.setActas();
			herramientas.setJuicioexpertos("JUICIOI DE EXPERTOS MODIFICADO TEST");
			herramientas.setRecopilaciondatos("RECOPIALCIONES UPDAE TEST");
			herramientas.setHabilidades("HABILIDADES UPDATE TEST");
			herramientas.setHerramientareuniones("herramientareuniones update TEST");
			herramientas.setActas(acta);
			herramientas.setIdherramienta(1);
			herramientasActasService.update(herramientas);

		}

	}

	@Test
	@Order(4)
	void findAll() throws Exception {
		for (herramientasacta herramientass : herramientasActasService.findAll()) {
			log.info("Id HERRAMIENTAS DEL ACTA : " + herramientass.getIdherramienta().toString());
			log.info("JUICIO DE EXPERTOS : " + herramientass.getJuicioexpertos());
			log.info("RECOMILACIONES DEL ACTA: " + herramientass.getRecopilaciondatos());
			log.info("HABILIDADES DEL ACTA: " + herramientass.getHabilidades());
			log.info("HERRAMIENTAS DE REUNIONES DEL ACTA: " + herramientass.getHerramientareuniones());
			log.info("ID DEL DEL ACTA: " + herramientass.getActas().getIdactas().toString());

		}
	}

	@Test
	@Order(5)
	void delete() throws Exception {

	}

}
