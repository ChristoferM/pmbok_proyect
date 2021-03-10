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

import com.tesis.v1.domain.proyectos;
import com.tesis.v1.domain.reuniones;
import com.tesis.v1.repository.proyectosRepository;
import com.tesis.v1.repository.reunionesRepository;

@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
class ReunionesProyectoTest {

	private final static Logger log = LoggerFactory.getLogger(ReunionesProyectoTest.class);

	private final static Integer idreuniones = 1;

	private final static Integer idproyectos = 1;

	@Autowired
	reunionesRepository reunionesRepository;

	@Autowired
	proyectosRepository proyectosRepository;

	@Test
	@Transactional
	@Order(1)
	void findByIdReuniones() {
		log.info("-> buscar ID de Reuniones");
		Optional<reuniones> reunionesOptional = reunionesRepository.findById(idreuniones);
		assertTrue(reunionesOptional.isPresent(), "No hay reuniones ocn ese ID");

		reuniones reuniones = reunionesOptional.get();
		log.info("idreuniones : " + reuniones.getIdreuniones().toString());
		log.info("nombrereunion : " + reuniones.getNombrereunion());
		log.info("descripcionreunion : " + reuniones.getDescripcionreunion());
		log.info(" idproyecto : " + reuniones.getProyectos().getIdproyecto().toString());
		//log.info("idfase : " + reuniones.getFaseProyecto().getIdfase().toString());

	}

	@Test
	@Transactional
	@Order(2)
	void findByIdProyectos() {
		log.info("-> buscar ID de proyectos");
		Optional<proyectos> proyectosOptional = proyectosRepository.findById(idproyectos);
		assertTrue(proyectosOptional.isPresent(), "No hay proyectos con ese ID");

		proyectos proyectos = proyectosOptional.get();
		log.info("idproyecto : " + proyectos.getIdproyecto().toString());
		log.info("nombre : " + proyectos.getNombre());
		log.info("descripcion : " + proyectos.getDescripcion());

	}

	@Test
	@Transactional
	@Order(3)
	void findAllReuniones() {
		log.info("-> buscar tdas las Reuniones");
		List<reuniones> reunioness = reunionesRepository.findAll();

		for (reuniones reuniones : reunioness) {
			log.info("idreuniones : " + reuniones.getIdreuniones().toString());
			log.info("nombrereunion : " + reuniones.getNombrereunion());
			log.info("descripcionreunion : " + reuniones.getDescripcionreunion());
			log.info(" idproyecto : " + reuniones.getProyectos().getIdproyecto().toString());
			//log.info("idfase : " + reuniones.getFaseProyecto().getIdfase().toString());

		}
	}

	@Test
	@Transactional
	@Order(4)
	void findAllProyectos() {
		log.info("-> buscar todos los proyectos");
		List<proyectos> proyectoss = proyectosRepository.findAll();

		for (proyectos proyectos : proyectoss) {
			log.info("idproyecto : " + proyectos.getIdproyecto().toString());
			log.info("nombre : " + proyectos.getNombre());
			log.info("descripcion : " + proyectos.getDescripcion());

		}

	}

}
