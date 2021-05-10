package com.tesis.v1.rest;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
class FaseProyectoServiceTest {

	private final static Logger log=LoggerFactory.getLogger(FaseProyectoServiceTest.class);
	
	@Autowired
	
	
	
	@Test
 	@Order(1)
	void save() throws Exception {
		log.info("info");
	}
	
	@Test
	@Order(2)
	void findById() throws Exception {}
	
	
	@Test 
	@Order(3)
	void update() throws Exception {}
	
	@Test
	@Order(4)
	void findAll() throws Exception {}
	
	@Test
	@Order(5)
	void delete() throws Exception {}
	
}
