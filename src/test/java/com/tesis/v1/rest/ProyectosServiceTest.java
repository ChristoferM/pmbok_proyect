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

import com.tesis.v1.domain.proyectos;
import com.tesis.v1.service.ProyectoService;

@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
class ProyectosServiceTest {

	private final static Logger log = LoggerFactory.getLogger(ProyectosServiceTest.class);
	@Autowired
	ProyectoService proyectoService;

	@Test
	@Order(1)
	void save() throws Exception {
		/*
		 * email@test.com.co
		 * springTst@test.com.co
		 * */
		proyectos proyecto = new proyectos();
		proyecto.setNombre("Test new  Proyecto Srping");
		proyecto.setDescripcion("DESCRIPCION newTEST SPIRNG");
		proyecto.setAdmin("fallo@test.com.co");
		proyectoService.save(proyecto);

	}

	@Test
	@Order(2)
	void findById() throws Exception {
		Optional<proyectos> proyectosOp = proyectoService.findById(2);
		if (proyectosOp.isEmpty()) {
			fail("No hay registros asi que paila");

		} else {
			proyectos proyecto = proyectosOp.get();
			log.info("Id FASE PROYECTO : " + proyecto.getIdproyecto().toString());
			log.info("Nombre del proyecto : " + proyecto.getNombre());
			log.info("Descripcion del proyecto: " + proyecto.getDescripcion());

		}
	}

	@Test
	@Order(3)
	void update() throws Exception {
		proyectos proyecto = new proyectos();
		proyecto.setIdproyecto(1);
		proyecto.setAdmin("email@test.com.co");
		proyecto.setNombre("Test update Proyecto Srping");
		proyecto.setDescripcion("DESCRIPCION update TEST SPIRNG");
		//proyectoService.save(proyecto);
		proyectoService.update(proyecto);
	}

	@Test
	@Order(4)
	void findAll() throws Exception {
		for (proyectos proyecto : proyectoService.findAll()) {
			log.info("Id FASE PROYECTO : " + proyecto.getIdproyecto().toString());
			log.info("Nombre del proyecto : " + proyecto.getNombre());
			log.info("Descripcion del proyecto: " + proyecto.getDescripcion());
			// log.info("Descripcion del proyecto: "+ proyecto.get);

		}
	}

	@Test
	@Order(5)
	void delete() throws Exception {
		proyectoService.deleteById(2);

	}
}
