package com.tesis.v1.rest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.tesis.v1.domain.grupo;
import com.tesis.v1.domain.proyectos;
import com.tesis.v1.domain.rolproyecto;
import com.tesis.v1.domain.subgrupo;
import com.tesis.v1.domain.usuarios;
import com.tesis.v1.repository.grupoRepository;
import com.tesis.v1.service.GrupoService;

@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
class GrupoServiceTest {

	private final static Logger log = LoggerFactory.getLogger(GrupoServiceTest.class);

	@Autowired
	GrupoService grupoService;

	@Test
	@Order(1)
	void save() throws Exception {
		// PARA CREAR UN GRUPO DEBE DE TENERSE LA INFORMACION DE
		// 1. PROYECTO QUE SE CREA
		// 2. USUARIOS

	}

	@Test
	@Order(2)
	void findById() throws Exception {
		Integer id = 1;
		grupoService.findById(id);
	}

	@Test
	@Order(3)
	void update() throws Exception {

	}

	@Test
	@Order(4)
	void findAll() throws Exception {
		List<grupo> gruposs = grupoService.findAll();
		for (grupo grupos : gruposs) {
			log.info("\n id proyecto " + grupos.getIdgrupo().toString());
			log.info("\n PROYECTOS " + grupos.getProyectos().getIdproyecto());

			//log.info("\n subgrupo " + grupos.getSubGrupos().toString() );

			log.info("ID usuario  " + grupos.getUsuarios().getNombre());

		}
	}

	@Test
	@Order(5)
	void delete() throws Exception {

	}

}
