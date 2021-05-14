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

import com.tesis.v1.domain.Reunion;
import com.tesis.v1.service.FaseProyectoService;
import com.tesis.v1.service.ProyectoService;
import com.tesis.v1.service.ReunionesService;

@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
class ReunionesServiceTest {

	private final static Logger log=LoggerFactory.getLogger(ReunionesServiceTest.class);
	
	@Autowired
	ReunionesService ReunionesService;
	@Autowired
	ProyectoService ProyectoService;
	@Autowired
	FaseProyectoService FaseProyectoService;
	
	@Test
 	@Order(1)
	void save() throws Exception {
		Reunion reunion = new Reunion();
		reunion.setNombrereunion("Test Reunion Spring");
		reunion.setDescripcionreunion("Test Descripcion Spring");
		//reunion.setProyectos(proyecto);  // proyecto "Test update Proyecto Srping2
		//reunion.setFaseproyecto(FaseProyecto);
		
	}
	
	@Test
	@Order(2)
	void findById() throws Exception {
		Optional<Reunion> proyectosOp = ReunionesService.findById(2);
		if (proyectosOp.isEmpty()) {
			fail("No hay registros asi que paila");

		} else {
			Reunion reuniones = proyectosOp.get();
			log.info("Id FASE PROYECTO : " + reuniones.getIdreuniones().toString());
			log.info("Nombre del proyecto : " + reuniones.getNombrereunion());
			log.info("Descripcion del proyecto: " + reuniones.getDescripcionreunion());
			log.info("ID DEL PROYECTO AL QUE PERETENECE: " + reuniones.getProyectos().getIdproyecto().toString());
			//log.info("nOMBRE DEL PROYECTO AL QUE PERETENECE: " + Reunion.getProyectos().getNombre());
			log.info("ID DEL FASE AL QUE PERETENECE: " + reuniones.getFaseproyecto().getIdfase().toString());
			//log.info("nOMBRE DEL FASE AL QUE PERETENECE: " + Reunion.getFaseproyecto().getNombrefase());


		}
	}
	
	
	@Test 
	@Order(3)
	void update() throws Exception {}
	
	@Test
	@Order(4)
	void findAll() throws Exception {
		for (Reunion reuniones : ReunionesService.findAll()) {
			log.info("Id FASE PROYECTO : " + reuniones.getIdreuniones().toString());
			log.info("Nombre del proyecto : " + reuniones.getNombrereunion());
			log.info("Descripcion del proyecto: " + reuniones.getDescripcionreunion());
			log.info("ID DEL PROYECTO AL QUE PERETENECE: " + reuniones.getProyectos().getIdproyecto().toString());
			//log.info("nOMBRE DEL PROYECTO AL QUE PERETENECE: " + Reunion.getProyectos().getNombre());
			log.info("ID DEL FASE AL QUE PERETENECE: " + reuniones.getFaseproyecto().getIdfase().toString());
			//log.info("nOMBRE DEL FASE AL QUE PERETENECE: " + Reunion.getFaseproyecto().getNombrefase());

		}
	}
	
	@Test
	@Order(5)
	void delete() throws Exception {
		
	}
	
}
