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

import com.tesis.v1.domain.casonegocio;
import com.tesis.v1.domain.entradacta;
import com.tesis.v1.repository.casonegocioRepository;
import com.tesis.v1.service.CasoNegocioService;
import com.tesis.v1.service.EntradaActaService;

@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
class CasoNegocioServiceTest {

	private final static Logger log = LoggerFactory.getLogger(CasoNegocioServiceTest.class);

	@Autowired
	CasoNegocioService casoNegocioService;
	@Autowired
	EntradaActaService EntradaActaService;

	@Test
	@Order(1)
	void save() throws Exception {
		casonegocio casonegocio = new casonegocio();
		casonegocio.setMetas("metas test spring");
		// casonegocio.set("metas test spring");
		casonegocio.setObjetivos("objetivos test spring");
		casonegocio.setIncidentes("incidentes test Spring");
		casonegocio.setOportunidades("oportunidades TEst Spring");
		//Optional<entradacta> entradacta = EntradaActaService.findById(1);
		casoNegocioService.save(casonegocio,1);
	}

	@Test
	@Order(2)
	void findById() throws Exception {
		casoNegocioService.findById(1);
	}

	@Test
	@Order(3)
	void update() throws Exception {
		casonegocio casonegocio = new casonegocio();
		casonegocio.setMetas("UPDATE metas test spring");
		casonegocio.setObjetivos("UPDATE metas test spring objetivos test spring");
		casonegocio.setIncidentes(" UPDATE metas test spring incidentes test Spring");
		casonegocio.setOportunidades("UPDATE metas test spring oportunidades TEst Spring");
		casoNegocioService.update(casonegocio);
	}

	@Test
	@Order(4)
	void findAll() throws Exception {
		for (casonegocio caso : casoNegocioService.findAll()) {
			log.info(caso.getMetas());
			log.info(caso.getObjetivos());
			log.info(caso.getIncidentes());
			log.info(caso.getOportunidades());
		}
	}

	@Test
	@Order(5)
	void delete() throws Exception {
		casoNegocioService.deleteById(3);
	}

}
