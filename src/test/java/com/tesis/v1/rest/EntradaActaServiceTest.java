package com.tesis.v1.rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.tesis.v1.domain.entradacta;
import com.tesis.v1.service.EntradaActaService;

@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
class EntradaActaServiceTest {

	private final static Logger log=LoggerFactory.getLogger(EntradaActaServiceTest.class);
	
	@Autowired
	EntradaActaService entradaActaService ; 
	
	
	@Test
 	@Order(1)
	void save() throws Exception {
		entradacta entradacta = new entradacta();
		entradacta.setAcuerdos(" TESTE SPRING");
		entradacta.setFactores(" TEST SPRING");
		entradacta.setActivosprocesos(" TEST SPRING");
		entradaActaService.save(entradacta);
		
	}
	
	@Test
	@Order(2)
	void findById() throws Exception {
		entradaActaService.findById(2);
	}
	
	
	@Test 
	@Order(3)
	void update() throws Exception {
		entradacta entradacta = new entradacta();
		entradacta.setAcuerdos("UPDATE TESTE SPRING");
		entradacta.setFactores("UPDATE TEST SPRING");
		entradacta.setActivosprocesos("UPDATE TEST SPRING");
		
		entradaActaService.update(entradacta);
	}
	
	@Test
	@Order(4)
	void findAll() throws Exception {
		entradaActaService.findAll();
	}
	
	@Test
	@Order(5)
	void delete() throws Exception {
		entradaActaService.deleteById(2);
		
	}
	

}
