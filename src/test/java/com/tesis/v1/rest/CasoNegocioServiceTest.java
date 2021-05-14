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

import com.tesis.v1.domain.CasoNegocio;
import com.tesis.v1.domain.Entradacta;
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
	EntradaActaService entradaActaService;

	@Test
	@Order(1)
	void save() throws Exception {
		CasoNegocio casonegocio = new CasoNegocio();
		casonegocio.setMetas("metas test spring");
		// CasoNegocio.set("metas test spring");
		casonegocio.setObjetivos("objetivos test spring");
		casonegocio.setIncidentes("incidentes test Spring");
		casonegocio.setOportunidades("oportunidades TEst Spring");
		//Optional<entradacta> Entradacta = EntradaActaService.findById(1);
		casoNegocioService.save(casonegocio,1);
	}

	@Test
	@Order(2)
	void findById() throws Exception {
		
		Optional<CasoNegocio> casonegocioOPC = casoNegocioService.findById(2);
		CasoNegocio casonegocio = casonegocioOPC.get();
		log.info("--------------------");
		log.info("IDE DEL CASO DE NEGOCIO: "+casonegocio.getId_caso_negocio().toString());
		log.info("METAS DEL CASO: "+casonegocio.getMetas());
		log.info("OBJETIVOS DEL CASO: "+casonegocio.getObjetivos());
		log.info("INCIDENTES DEL CASO: "+casonegocio.getIncidentes());
		log.info("OPORTUNIDADES DEL CASO: "+casonegocio.getOportunidades());
		log.info("ID ENTRADAS DEL CASO: "+casonegocio.getEntradacta().getIdentrada().toString());
		
		log.info("--------------------");
	}

	@Test
	@Order(3)
	void update() throws Exception {
		Optional<Entradacta> actaOPC = entradaActaService.findById(2);
		if(actaOPC.isEmpty()) {
			fail("\n \nError acta no encontrada \n \n");
		}else {
		CasoNegocio casonegocio = new CasoNegocio();
		Entradacta entradacta= actaOPC.get();
		casonegocio.setEntradacta(entradacta);
		casonegocio.setId_caso_negocio(2);
		casonegocio.setMetas("UPDATE metas test spring");
		casonegocio.setObjetivos("UPDATE metas test spring objetivos test spring");
		casonegocio.setIncidentes(" UPDATE metas test spring incidentes test Spring");
		casonegocio.setOportunidades("UPDATE metas test spring oportunidades TEst Spring");
		casoNegocioService.update(casonegocio);
		}
	}

	@Test
	@Order(4)
	void findAll() throws Exception {
		for (CasoNegocio casonegocio : casoNegocioService.findAll()) {
			log.info("--------------------");
			log.info("IDE DEL CASO DE NEGOCIO: "+casonegocio.getId_caso_negocio().toString());
			log.info("METAS DEL CASO: "+casonegocio.getMetas());
			log.info("OBJETIVOS DEL CASO: "+casonegocio.getObjetivos());
			log.info("INCIDENTES DEL CASO: "+casonegocio.getIncidentes());
			log.info("OPORTUNIDADES DEL CASO: "+casonegocio.getOportunidades());
			log.info("ID ENTRADAS DEL CASO: "+casonegocio.getEntradacta().getIdentrada().toString());
			
			log.info("--------------------");
		}
	}

	@Test
	@Order(5)
	void delete() throws Exception {
		casoNegocioService.deleteById(3);
	}

}
