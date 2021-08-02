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

import com.tesis.v1.domain.FaseProyecto;
import com.tesis.v1.domain.Reunion;
import com.tesis.v1.domain.SubGrupo;
import com.tesis.v1.repository.FaseProyectoRepository;
import com.tesis.v1.repository.SubGrupoRepository;
import com.tesis.v1.repository.ReunionRepository;


@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
class reunionesFaseProyectoSubGrupoTest {


	private final static Logger log = LoggerFactory.getLogger(reunionesFaseProyectoSubGrupoTest.class);

	private final static Integer idreuniones = 1;

	private final static Integer idproyectos = 1;

	@Autowired
	ReunionRepository reunionesRepository;

	@Autowired
	FaseProyectoRepository faseproyectoRepository;
	
	
	@Autowired
	SubGrupoRepository subgrupoRepository;

	
	//  PRUEBAS DE REUNIONES como hijo de fase Proyecto
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


	
	
	//    PRUEBAS DE FASE PROYECTO como padre de Reunion
	
	
	@Test
	@Transactional
	@Order(2)
	void findByIdFaseProyectos() {
		log.info("-> buscar ID de proyectos");
		Optional<FaseProyecto> faseproyectoOptional = faseproyectoRepository.findById(idproyectos);
		assertTrue(faseproyectoOptional.isPresent(), "No hay proyectos con ese ID");

		FaseProyecto faseproyecto = faseproyectoOptional.get();
		log.info("id Fase proyecto : " + faseproyecto.getIdfase().toString());
		//log.info("nombre : " + faseproyecto.getNombrefase());
		log.info("descripcion : " + faseproyecto.getDescripcionfase());

	}	


	@Test
	@Transactional
	@Order(4)
	void findAllFaseProyectos() {
		log.info("-> buscar todos los proyectos");
		List<FaseProyecto> faseproyectos = faseproyectoRepository.findAll();

		for (FaseProyecto faseproyecto : faseproyectos) {
			log.info("id Fase proyecto : " + faseproyecto.getIdfase().toString());
			//log.info("nombre : " + faseproyecto.getNombrefase());
			log.info("descripcion : " + faseproyecto.getDescripcionfase());

		}

	}
	
	
	// PRUEBAS DE SUBGRUPO COMO HIJO DE FASE DE PROYECTO Y GRUPOS
	
	
	@Test
	@Transactional
	@Order(5)
	void findByIdSubGrupo() {
		log.info("-> buscar ID de Reuniones");
		Optional<SubGrupo> subgrupoOptional = subgrupoRepository.findById(2);
		assertTrue(subgrupoOptional.isPresent(), "No hay reuniones ocn ese ID");

		SubGrupo subgrupo = subgrupoOptional.get();
		log.info("Id SubGrupo : " + subgrupo.getId_sub_grupo());
		log.info("Id de la grupo a la que pertenece: "+ subgrupo.getGrupo().getIdgrupo() ); // relacion 
		log.info("Id de la grupo a la que pertenece: "+ subgrupo.getFaseproyecto().getIdfase().toString() ); // relacion
		
		//log.info("idfase : " + Reunion.getFaseProyecto().getIdfase().toString());

	}

	@Test
	@Transactional
	@Order(6)
	void findAlldSubGrupo() {
		log.info("-> buscar ID de proyectos");
		Optional<SubGrupo> subgrupoOptional = subgrupoRepository.findById(2);
		assertTrue(subgrupoOptional.isPresent(), "No hay SUB GRUPOS con ese ID");

		SubGrupo subgrupo = subgrupoOptional.get();
		log.info("Id SubGrupo : " + subgrupo.getId_sub_grupo());
		log.info("Id de la grupo a la que pertenece: "+ subgrupo.getGrupo().getIdgrupo() ); // RELACION
		log.info("Id de la grupo a la que pertenece: "+ subgrupo.getFaseproyecto().getIdfase().toString() ); // relacion
	}

}
