package com.tesis.v1.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.tesis.v1.domain.Reunion;
import com.tesis.v1.domain.pdp.Entradas;
import com.tesis.v1.domain.pdp.Herramientas;
import com.tesis.v1.domain.pdp.Pdp;
import com.tesis.v1.service.entradasPdpService;
import com.tesis.v1.service.herramientasServicePdp;
import com.tesis.v1.service.pdpService;


@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
class Pdps {

	private final static Logger log = LoggerFactory.getLogger(Pdps.class);
			
	@Autowired
	pdpService pdpService;
	
	
	@Autowired
	entradasPdpService entradasPdpService;
	
	@Autowired
	herramientasServicePdp herramientasServicePdp;
	
	@Test
	void savePdp() throws Exception {
		log.info("GUARDANDADO ");
		Pdp pdp = new Pdp();
		Reunion  reuniones0= new Reunion();
		reuniones0.setIdreuniones(1);
		pdp.setReuniones(reuniones0);
		pdpService.save(pdp);
		
		
		
		
	}
	
	@Test
	void saveHerramientaPdp() throws Exception {
		log.info("GUARDANDADO ");
		Pdp pdp = new Pdp();
		Herramientas herramientasPdp= new Herramientas();
		pdp.setIdpdp(1);
		herramientasPdp.setPdp(pdp);
		
		herramientasPdp.setJuicioexpertos("TEST spring");
		herramientasPdp.setRecopilaciondatos("TEST spring");
		herramientasPdp.setHabilidades("TEST spring");
		herramientasPdp.setHerramientareuniones("TEST spring");
		herramientasPdp.setPdp(pdp);
		herramientasServicePdp.save(herramientasPdp);
		
		
		
		
	}
	
	@Test
	void saveEntradaPdp() throws Exception {
		log.info("GUARDANDADO ");
		Pdp pdp = new Pdp();
	
		Entradas entradasPdp =new Entradas();
		pdp.setIdpdp(1);
		entradasPdp.setPdp(pdp);
		
		entradasPdp.setOtrosprocesos("Test Spring Otros servicios");
		entradasPdp.setFactoresambientales("Test Spring"); 
		entradasPdp.setActivosprocesos("Test Spring");
		entradasPdpService.save(entradasPdp);
		
		
		
	}
	
	
	@Test
	void buscarPdp() throws Exception {
		log.info("GUARDANDADO ");
		for (Pdp pdps : pdpService.findAll()) {
			log.info("ID  del PDP: " + pdps.getIdpdp().toString());
			log.info("Id reuniones : " + pdps.getReuniones().getIdreuniones().toString());
		}
		
		
		
	}
	
	@Test
	void buscarHerramientaPdp() throws Exception {
		log.info("GUARDANDADO ");
		log.info("GUARDANDADO ");
		for (Herramientas herramientasPdp : 		herramientasServicePdp.findAll()) {
			log.info("ID  del PDP: " + herramientasPdp.getIdherramienta().toString());
			log.info("Juicioexpertos : " + herramientasPdp.getJuicioexpertos());
			log.info(" REcopilaciones : " + herramientasPdp.getRecopilaciondatos());
			log.info("Habilidades 	 : " + herramientasPdp.getHabilidades());
			log.info("setHerramientareuniones : " + herramientasPdp.getHerramientareuniones());
			
			
			
		}
		
		
	}
	
	@Test
	void buscarEntradaPdp() throws Exception {
		log.info("GUARDANDADO ");
		log.info("GUARDANDADO ");
		for (Entradas entradasPdp : entradasPdpService.findAll()) {
			log.info("ID  del PDP: " + entradasPdp.getIdentradapdp().toString());
			log.info("OTROS PROCESOS: " + entradasPdp.getOtrosprocesos());
			log.info("setFactoresambientales: " + entradasPdp.getFactoresambientales());
			log.info("ACTIVOS pROCESOS: " + entradasPdp.getActivosprocesos());
			
			
		}
		
	}
	
	
}
