package com.tesis.v1.rest;

import com.tesis.v1.domain.Tipo_proyecto;
import com.tesis.v1.domain.Usuario;
import com.tesis.v1.dto.tipo_proyectoDTO;
import com.tesis.v1.dto.UsuariosDTO;
import com.tesis.v1.service.Tipo_proyectoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tesis.v1.mapper.Tipo_proyectoMapper;

/**
 *
 * @author david
 */

@RestController // Servicio
@RequestMapping("/api/tipoProyecto") // Forma de llamar datos
@CrossOrigin
public class Tipo_proyectoController {
    
    @Autowired
    Tipo_proyectoService tipo_proyectoService;
    
    @Autowired
    Tipo_proyectoMapper tipo_proyectoMapper1;
    
    @RequestMapping("/findAll")
    public ResponseEntity<?> finByAll() throws Exception{
            List<Tipo_proyecto> usuariosLIST= tipo_proyectoService.findAll();
            List<tipo_proyectoDTO> usuarioListDto = tipo_proyectoMapper1.toTipo_proyectosDTOs(usuariosLIST);
            return ResponseEntity.ok().body(usuarioListDto);
    }
    
    @GetMapping("/findById/{tipoId}")
    public ResponseEntity<?> findById(@PathVariable("tipoId") String tipoId) throws Exception {
        
        Optional<Tipo_proyecto> tipo_proyectoOptional = tipo_proyectoService.findById(tipoId);
        if(tipo_proyectoOptional.isPresent()==false) {
                return ResponseEntity.ok().body("tipo de proyecto no encontrado");
        }

        Tipo_proyecto tipo  = tipo_proyectoOptional.get();

        tipo_proyectoDTO tipo_proyectoDTO = tipo_proyectoMapper1.toTipo_proyectoDTO(tipo);
        
        return ResponseEntity.ok().body(tipo_proyectoDTO);
    }
    
    
}
