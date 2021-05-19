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

import com.tesis.v1.domain.Usuario;
import com.tesis.v1.dto.UsuariosDTO;
import com.tesis.v1.service.UsuarioService;
import com.tesis.v1.mapper.UsuarioMapper;

@RestController // Servicio
@RequestMapping("/api/usuario") // Forma de llamar datos
@CrossOrigin
public class UsuarioController {

    private final static Logger log = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioMapper usuarioMapper;

    @RequestMapping("/finByAll")
    public ResponseEntity<?> finByAll() throws Exception {
        List<Usuario> usuariosLIST = usuarioService.findAll();
        List<UsuariosDTO> usuarioListDto = usuarioMapper.toUsuariosDTOs(usuariosLIST);

        return ResponseEntity.ok().body(usuarioListDto);
    }

    @RequestMapping("/finById/{usuarioId}")
    public ResponseEntity<?> finById(@PathVariable("usuarioId") String userId) throws Exception {
        log.info("Reconociendo usuario :  " + userId);
        Optional<Usuario> usuarioOpt = usuarioService.findById(userId);
        log.info("Cargando ...");
        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.ok().body("Error: No se encontro Usuario");

        }
        Usuario usuario = usuarioOpt.get();
        UsuariosDTO usuarioDTO = usuarioMapper.toUsuariosDTO(usuario);
        log.info("*");
        return ResponseEntity.ok().body(usuarioDTO);

    }

    @RequestMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody UsuariosDTO usuariosDto) throws Exception {

        Usuario usuario = usuarioMapper.toUsuarios(usuariosDto);

        usuario = usuarioService.save(usuario);

        usuariosDto = usuarioMapper.toUsuariosDTO(usuario);

        return ResponseEntity.ok().body(usuariosDto);
    }

}
