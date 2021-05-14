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

import com.tesis.v1.domain.Acta;
import com.tesis.v1.domain.Entradacta;
import com.tesis.v1.domain.Herramientasacta;
import com.tesis.v1.repository.ActaRepository;
import com.tesis.v1.repository.HerramientasactaRepository;
import com.tesis.v1.repository.EntradactaRepository;

@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
class actasEntradasActaHerramientasTest {

	private final static Logger log = LoggerFactory.getLogger(actasEntradasActaHerramientasTest.class);

	private final static Integer idusuario = 1;

	private final static Integer idgrupo = 2;

	@Autowired
	EntradactaRepository entradactaRepository;

	@Autowired
	HerramientasactaRepository herramientasactaRepository;

	@Autowired
	ActaRepository actasRepository;

	// ------------------------ ENTRADA ACTA
	@Test
	@Transactional
	@Order(1)
	void findByIdEntrada() {
		log.info("-> buscar ID de Reuniones");
		Optional<Entradacta> entradaactaOpcioan = entradactaRepository.findById(idgrupo);

		assertTrue(entradaactaOpcioan.isPresent(), "No existe una entreada de acta con ese ID");

		Entradacta entradacta = entradaactaOpcioan.get();

		log.info("ID DE ENTRADA : " + entradacta.getIdentrada().toString());
		log.info(" acuerdos DE ENTRADA : " + entradacta.getAcuerdos());
		log.info(" factores DE ENTRADA : " + entradacta.getFactores());
		log.info(" activosprocesos DE ENTRADA : " + entradacta.getActivosprocesos());

	}

	@Test
	@Transactional
	@Order(2)
	void findAllEntrada() {
		log.info("-> buscar ID de Reuniones");
		List<Entradacta> entradactas = entradactaRepository.findAll();

		for (Entradacta entradacta : entradactas) {
			log.info("ID DE ENTRADA : " + entradacta.getIdentrada().toString());
			log.info(" acuerdos DE ENTRADA : " + entradacta.getAcuerdos());
			log.info(" factores DE ENTRADA : " + entradacta.getFactores());
			log.info(" activosprocesos DE ENTRADA : " + entradacta.getActivosprocesos());
			log.info(" ACTA A LA QUE PERTENECE DE ENTRADA : " + entradacta.getActas().getIdactas().toString() );
		}

	}

	// -------------------------- ACTAS
	@Test
	@Transactional
	@Order(3)
	void findByIdACTAS() {
		log.info("-> buscar ID de Reuniones");
		Optional<Acta> actasOpcional = actasRepository.findById(idgrupo);

		assertTrue(actasOpcional.isPresent(), "No existe una entreada de acta con ese ID");

		Acta actas = actasOpcional.get();
		log.info("ID DE ACTA:  " + actas.getIdactas().toString());
		// log.info("idreuniones DE ACTA" + Acta.);

	}

	@Test
	@Transactional
	@Order(4)
	void findAllCasoACTA() {
		log.info("-> buscar ID de Reuniones");
		List<Acta> actasOpcioan = actasRepository.findAll();

		for (Acta actas : actasOpcioan) {
			log.info("ID DE ACTA: " + actas.getIdactas().toString());
			log.info("idreuniones DE ACTA" + actas.getEntradacta());
		}

	}

	// -------------------------- HERRAMIENTAS DE ACTAS
	// ACTA

	@Test
	@Transactional
	@Order(5)
	void findByIdHerramientasDeActas() {
		log.info("-> buscar ID de Reuniones");

		Optional<Herramientasacta> herramientasactaOpcioan = herramientasactaRepository.findById(idusuario);

		assertTrue(herramientasactaOpcioan.isPresent(), "No existe una entreada de acta con ese ID");

		Herramientasacta herramientasacta = herramientasactaOpcioan.get();

		log.info("ID DE HERRAMIENTAS DE ACTAS" + herramientasacta.getIdherramienta().toString());
		log.info("juicioexpertos DE HERRAMIENTAS DE ACTAS" + herramientasacta.getJuicioexpertos());
		log.info("recopilaciondatos DE HERRAMIENTAS DE ACTAS" + herramientasacta.getHerramientareuniones());
		log.info("habilidades DE HERRAMIENTAS DE ACTAS" + herramientasacta.getHabilidades());
		log.info("herramientareuniones DE HERRAMIENTAS DE ACTAS" + herramientasacta.getHerramientareuniones());
		log.info(
				"ID DE LA ACTA A LA QUE PERTENCE LA HERRAMIENTA:    " + herramientasacta.getActas().getIdactas().toString());

	}

	@Test
	@Transactional
	@Order(6)
	void findAllHerramientasDeActas() {
		log.info("-> buscar ID de Reuniones");
		List<Herramientasacta> herramientasactaOptinal = herramientasactaRepository.findAll();

		for (Herramientasacta herramientasacta : herramientasactaOptinal) {

			log.info("ID DE HERRAMIENTAS DE ACTAS" + herramientasacta.getIdherramienta().toString());
			log.info("juicioexpertos DE HERRAMIENTAS DE ACTAS" + herramientasacta.getJuicioexpertos());
			log.info("recopilaciondatos DE HERRAMIENTAS DE ACTAS" + herramientasacta.getHerramientareuniones());
			log.info("habilidades DE HERRAMIENTAS DE ACTAS" + herramientasacta.getHabilidades());
			log.info("herramientareuniones DE HERRAMIENTAS DE ACTAS" + herramientasacta.getHerramientareuniones());
			log.info("ID DE LA ACTA A LA QUE PERTENCE LA HERRAMIENTA:    "
					+ herramientasacta.getActas().getIdactas().toString());
		}
	}

}
