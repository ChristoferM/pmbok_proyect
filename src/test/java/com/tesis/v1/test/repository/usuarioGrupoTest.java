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

import com.tesis.v1.domain.Grupo;
import com.tesis.v1.domain.Usuario;
import com.tesis.v1.repository.GrupoRepository;
import com.tesis.v1.repository.UsuarioRepository;

@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
class usuarioGrupoTest {

	private final static Logger log = LoggerFactory.getLogger(usuarioGrupoTest.class);

	private final static String email = "email@test.com.co";


	private final static Integer idgrupo = 2;

	@Autowired
	UsuarioRepository usuariosRepository;

	@Autowired
	GrupoRepository grupoRepository;

	@Test
	@Transactional
	@Order(1)
	void findByIdUsuario() {
		log.info("----  -> findAll");
		Optional<Usuario> usuariOptinal = usuariosRepository.findById(email);

		assertTrue(usuariOptinal.isPresent(), "-> Id no encontrado");

		Usuario usuarios = usuariOptinal.get();

		log.info(usuarios.getEmail());

	}

	@Test
	@Transactional
	@Order(2)
	void findByIdGrupo() {
		log.info("----  -> findAll GRUPO");
		Optional<Grupo> grupoOptinal = grupoRepository.findById(idgrupo);

		assertTrue(grupoOptinal.isPresent(), "-> Id no encontrado");

		Grupo grupo = grupoOptinal.get();

		log.info("ID GRUPO " + grupo.getIdgrupo().toString());
		// log.info("ID id_sub_grupo "+Grupo.getId_sub_grupo().toString());
		// log.info("ID idproyecto "+Grupo.getIdproyecto().toString());
		// log.info("ID email "+Grupo.getEmail().toString());

	}

	@Test
	@Transactional
	@Order(3)
	void findAllUsuarios() {
		log.info("----  -> findAllUsuarios");
		List<Usuario> usuarioss = usuariosRepository.findAll();
		for(Usuario usuarios: usuarioss) {
			//log.info("idusuario: " +Usuario.getIdusuario().toString() );
			log.info("email: " +usuarios.getEmail() );
			log.info("nombre: " +usuarios.getNombre() );
			log.info("password: " +usuarios.getPassword() );
			log.info("token: " +usuarios.getToken() );
			log.info("activo: " +usuarios.getActivo() );
			
			
		}
	}

	@Test
	@Transactional
	@Order(4)
	void findAllGrupo() {
		log.info("----  -> findAllGrupo");
		List<Grupo> grupos = grupoRepository.findAll();
		for (Grupo grupo : grupos) {
			log.info("idGRUPO: " + grupo.getIdgrupo().toString());
			log.info("id_sub_grupo: " + grupo.getSubGrupos().toString());
			log.info("idproyecto: " + grupo.getProyectos().getIdproyecto().toString());
			log.info("email" + grupo.getUsuarios().getEmail());

		}
	}

}
