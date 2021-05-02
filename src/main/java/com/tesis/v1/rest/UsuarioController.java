package com.tesis.v1.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesis.v1.domain.usuarios;
import com.tesis.v1.dto.usuariosDTO;
import com.tesis.v1.mapper.usuariosMapper;
import com.tesis.v1.service.UsuarioService;

@RestController // Servicio
@RequestMapping("/api/usuario") // Forma de llamar datos
@CrossOrigin
public class UsuarioController {

	private final static Logger log = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	usuariosMapper usuarioMapper;
	
	@RequestMapping("/finByAll")
	public ResponseEntity<?> finByAll() throws Exception{
		List<usuarios> usuariosLIST= usuarioService.findAll();
		List<usuariosDTO> usuarioListDto = usuarioMapper.toUsuariosDTOs(usuariosLIST);
		
		return ResponseEntity.ok().body(usuarioListDto);
	}
	
	@RequestMapping("/finById/{usuarioId}")
	public ResponseEntity<?> finById(@PathVariable("usuarioId") String userId)throws Exception{
		log.info("Reconociendo usuario :  "+userId);
		Optional<usuarios> usuarioOpt = usuarioService.findById(userId);
		log.info("Cargando ...");
		if( usuarioOpt.isEmpty()) {
			return ResponseEntity.ok().body("Error: No se encontro Usuario");
			
		}
		usuarios usuario = usuarioOpt.get();
		usuariosDTO usuarioDTO = usuarioMapper.toUsuariosDTO(usuario);
		log.info("*");
		return ResponseEntity.ok().body(usuarioDTO);
		
	}

	
	@RequestMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody usuariosDTO usuariosDto)  throws Exception{
	
		usuarios usuario = usuarioMapper.toUsuarios(usuariosDto);
		
		usuario = usuarioService.save(usuario);
		
		usuariosDto = usuarioMapper.toUsuariosDTO(usuario);
		
		return ResponseEntity.ok().body(usuariosDto);
	}
	
	
	
	
	
	
	
	
	
}
