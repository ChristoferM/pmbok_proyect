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

import com.tesis.v1.domain.Proyecto;
import com.tesis.v1.domain.Reunion;
import com.tesis.v1.repository.ProyectoRepository;
import com.tesis.v1.repository.ReunionRepository;

@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
class ReunionesProyectoTest {

	private final static Logger log = LoggerFactory.getLogger(ReunionesProyectoTest.class);

	private final static Integer idreuniones = 1;

	private final static Integer idproyectos = 1;

	@Autowired
	ReunionRepository reunionesRepository;

	@Autowired
	ProyectoRepository proyectosRepository;

	@Test
	@Transactional
	@Order(1)
	void findByIdReuniones() {
		log.info("-> buscar ID de Reuniones");
		Optional<Reunion> reunionesOptional = reunionesRepository.findById(idreuniones);
		assertTrue(reunionesOptional.isPresent(), "No hay reuniones ocn ese ID");

		Reunion reuniones = reunionesOptional.get();
		log.info("idreuniones : " + reuniones.getIdreuniones().toString());
		log.info("nombrereunion : " + reuniones.getNombrereunion());
		log.info("descripcionreunion : " + reuniones.getDescripcionreunion());
		log.info(" idproyecto : " + reuniones.getProyectos().getIdproyecto().toString());
		//log.info("idfase : " + Reunion.getFaseProyecto().getIdfase().toString());

	}

	@Test
	@Transactional
	@Order(2)
	void findByIdProyectos() {
		log.info("-> buscar ID de proyectos");
		Optional<Proyecto> proyectosOptional = proyectosRepository.findById(idproyectos);
		assertTrue(proyectosOptional.isPresent(), "No hay proyectos con ese ID");

		Proyecto proyectos = proyectosOptional.get();
		log.info("idproyecto : " + proyectos.getIdproyecto().toString());
		log.info("nombre : " + proyectos.getNombre());
		log.info("descripcion : " + proyectos.getDescripcion());

	}

	@Test
	@Transactional
	@Order(3)
	void findAllReuniones() {
		log.info("-> buscar tdas las Reuniones");
		List<Reunion> reunioness = reunionesRepository.findAll();

		for (Reunion reuniones : reunioness) {
			log.info("idreuniones : " + reuniones.getIdreuniones().toString());
			log.info("nombrereunion : " + reuniones.getNombrereunion());
			log.info("descripcionreunion : " + reuniones.getDescripcionreunion());
			log.info(" idproyecto : " + reuniones.getProyectos().getIdproyecto().toString());
			//log.info("idfase : " + Reunion.getFaseProyecto().getIdfase().toString());

		}
	}

	@Test
	@Transactional
	@Order(4)
	void findAllProyectos() {
		log.info("-> buscar todos los proyectos");
		List<Proyecto> proyectoss = proyectosRepository.findAll();

		for (Proyecto proyectos : proyectoss) {
			log.info("idproyecto : " + proyectos.getIdproyecto().toString());
			log.info("nombre : " + proyectos.getNombre());
			log.info("descripcion : " + proyectos.getDescripcion());

		}

	}
	
	@Test
	@Transactional
	@Order(5)
	void findbyEmail() {
		log.info("-> buscar ID de proyectos");
		String email= "prueba@Prueba22.com.co";
		/*Optional<proyectos> proyectosOptional = ProyectoRepository.finByEmail(email);
		log.info("aca ->"+proyectosOptional.isPresent());
		if(proyectosOptional.isPresent()) {
			Proyecto Proyecto = proyectosOptional.get();
			log.info("idproyecto : " + Proyecto.getIdproyecto().toString());
			log.info("nombre : " + Proyecto.getNombre());
			log.info("descripcion : " + Proyecto.getDescripcion());
		}else {
			log.info("aca ->"+proyectosOptional.isPresent());
			log.info(" NO se encontro nada");
		}*/
		log.info("-> buscar todos los proyectos");
		List<Proyecto> proyectoss = proyectosRepository.finByEmail(email);
		for (Proyecto proyectos : proyectoss) {
			log.info("idproyecto : " + proyectos.getIdproyecto().toString());
			log.info("nombre : " + proyectos.getNombre());
			log.info("descripcion : " + proyectos.getDescripcion());

		}

		

	}

}
