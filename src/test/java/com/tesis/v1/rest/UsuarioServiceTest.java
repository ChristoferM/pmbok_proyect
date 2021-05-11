package com.tesis.v1.rest;

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

import com.tesis.v1.domain.usuarios;
import com.tesis.v1.service.UsuarioService;

@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
class UsuarioServiceTest {

	private final static Logger log = LoggerFactory.getLogger(UsuarioServiceTest.class);

	@Autowired
	UsuarioService UsuarioService;

	@Test
	@Order(1)
	void save() throws Exception {
		usuarios usuario = new usuarios();
		usuario.setEmail("springTst1@test.com.co");
		usuario.setNombre("2 nombreTest UPDATE");
		usuario.setToken("2 token UPTDATE SDFNKSAND");
		usuario.setPassword("7895462551");
		usuario.setActivo("N");

		usuario = UsuarioService.save(usuario);
		usuario = new usuarios();
		log.info(usuario.getEmail());
		log.info(usuario.getNombre());
		log.info(usuario.getPassword());
		log.info(usuario.getToken());
		log.info(usuario.getActivo());

	}

	@Test
	@Order(2)
	void findAll() throws Exception {
		for (usuarios usuario : UsuarioService.findAll()) {
			log.info("--------------------");
			log.info(usuario.getEmail());
			log.info(usuario.getNombre());
			log.info(usuario.getPassword());
			log.info(usuario.getToken());
			log.info(usuario.getActivo());
			log.info("--------------------");

		}
	}

	@Test
	@Order(3)
	void finById() throws Exception {
		Optional<usuarios> usuarios = UsuarioService.findById("email@test.com.co");
		usuarios usuario = usuarios.get();
		log.info("--------------------");
		log.info(usuario.getEmail());
		log.info(usuario.getNombre());
		log.info(usuario.getPassword());
		log.info(usuario.getToken());
		log.info(usuario.getActivo());

		log.info("--------------------");
	}

	@Test
	@Order(4)
	void delete() throws Exception {
		String correo = "springTst1@test.com.co";
		UsuarioService.deleteById(correo);
	}

	@Test
	@Order(5)
	void update() throws Exception {
		usuarios usuario = new usuarios();
		usuario.setEmail("springTst1@test.com.co");
		usuario.setNombre("UPDATE nombreTest UPDATE");
		usuario.setToken("UPDATE token UPTDATE SDFNKSAND");
		usuario.setPassword("9	");
		usuario.setActivo("Y");
		UsuarioService.update(usuario);

	}

}
