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

import com.tesis.v1.domain.Roles;
import com.tesis.v1.domain.RolProyecto;
import com.tesis.v1.repository.RolProyectoRepository;
import com.tesis.v1.repository.RolesRepository;

@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
class RolproyectoRolTest {

	private final static Logger log = LoggerFactory.getLogger(RolproyectoRolTest.class);

	private final static Integer idRol = 1;

	private final static Integer idRolProyecto = 1;

	@Autowired
	RolesRepository rolesRepository;

	@Autowired
	RolProyectoRepository rolProyectoRepository;

	@Test
	@Transactional
	@Order(1)
	void findByIdRol() {
		log.info("----  -> findByIdRol ");
		Optional<Roles> rolesOptional = rolesRepository.findById(idRol);

		assertTrue(rolesOptional.isPresent(), "-> NO HAY ROL CON ESE ID");

		Roles roles = rolesOptional.get();

		log.info("Nombre ID" + roles.getIdrol().toString());
		log.info("Nombre rol" + roles.getNombrerol());

	}

	@Test
	@Transactional
	@Order(2)
	void findByIdRolProyecto() {
		log.info("----  -> findByIdRolProyecto ");
		Optional<RolProyecto> rolProyectoOptional = rolProyectoRepository.findById(idRolProyecto);

		assertTrue(rolProyectoOptional.isPresent(), "-> NO HAY ROLES EN PROYECTO CON ESE ID");

		RolProyecto rolproyecto = rolProyectoOptional.get();

		log.info("id_rol_proyecto : " + rolproyecto.getId_rol_proyecto().toString());
		log.info("idrol : " + rolproyecto.getRoles().getIdrol().toString());
		log.info("idgrupo : " + rolproyecto.getGrupo().getIdgrupo().toString());

	}

	@Test
	@Transactional
	@Order(3)
	void findAllRol() {
		
		log.info("----  -> findAllRol");
		List<Roles> roles = rolesRepository.findAll();
		
		for (Roles rols: roles) {
			log.info("idRol : "+ rols.getIdrol().toString());
			log.info("NombreRol : "+ rols.getNombrerol());
			
		}
		

	}

	@Test
	@Transactional
	@Order(4)
	void findAllRolProyecto() {
		log.info("----  -> indAll Rol Proyecto");
		List<RolProyecto> rolesProyectos = rolProyectoRepository.findAll();
		
		for (RolProyecto rolproyectos: rolesProyectos) {
			log.info("id_rol_proyecto : "+ rolproyectos.getId_rol_proyecto().toString() );
			log.info("idgrupo : "+ rolproyectos.getGrupo().getIdgrupo().toString() );
			log.info("idrol : "+ rolproyectos.getId_rol_proyecto().toString() );
			
			
		}
	}

}
