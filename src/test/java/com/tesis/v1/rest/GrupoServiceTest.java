package com.tesis.v1.rest;

import static org.junit.jupiter.api.Assertions.fail;

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

import com.tesis.v1.domain.Grupo;
import com.tesis.v1.domain.Proyecto;
import com.tesis.v1.domain.Usuario;
import com.tesis.v1.dto.GrupoDTO;
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
		
		GrupoDTO api = new GrupoDTO();
		
		// api.setIdgrupo(0);
		// api.setId_sub_grupo(0);
		api.setIdproyecto(21);
		api.setIdrol(4);
		api.setEmail("usuarioTest@test.com.co");
		// api.setIdrol(3);
		api.setIdNombrerol("supervisor  ");
		if(api.getIdrol() == null || api.getIdrol() ==0) {
			
			api.setIdrol(0);
			
		}else {
			Grupo ap = grupoService.saveAndrol(api, api.getIdrol(), api.getIdNombrerol());
		}
		
		Grupo ap = grupoService.saveAndrol(api, api.getIdrol(), api.getIdNombrerol());
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
		List<Grupo> gruposs = grupoService.findAll();
		for (Grupo grupos : gruposs) {
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
	
	@Test
	@Order(6)
	void CrearfaseConResponsables() throws Exception {

	}

}
