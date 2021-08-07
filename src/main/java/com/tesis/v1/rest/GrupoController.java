package com.tesis.v1.rest;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tesis.v1.domain.Acta;
import com.tesis.v1.domain.Grupo;
import com.tesis.v1.domain.Reunion;
import com.tesis.v1.domain.RolProyecto;
import com.tesis.v1.domain.SubGrupo;
import com.tesis.v1.dto.ActasDTO;
import com.tesis.v1.dto.GrupoDTO;
import com.tesis.v1.dto.RolesDTO;
import com.tesis.v1.dto.UsuariosDTO;
import com.tesis.v1.dto.CrearfaseConResponsablesDTO; 
import com.tesis.v1.service.GrupoService;
import com.tesis.v1.service.tipofasesService;

@RestController // Servicio
@RequestMapping("/api/grupo") // Forma de llamar datos
@CrossOrigin
public class GrupoController {

	private final static Logger log = LoggerFactory.getLogger(GrupoController.class);
	
	@Autowired
	GrupoService grupoService;
	
	
	@Autowired
	tipofasesService ttipofasesService;
	
	 @RequestMapping("/fasesDelProyecto")
	 public ResponseEntity<?> fasesDelProyectoInteger() throws Exception {
	 
		  return ResponseEntity.ok().body(ttipofasesService.findAll());
	 }
	 
	 @RequestMapping("/tipoDeRoles")
	 public ResponseEntity<?> rolesDisponibles() throws Exception {
	 
		  return ResponseEntity.ok().body(grupoService.rolesDisponibles());
	 }
    @RequestMapping("/matricular")
    public ResponseEntity<?> save(@Valid @RequestBody GrupoDTO dto) throws Exception {
        // log.info("************************************ 1");
		if(dto.getIdrol() == null || dto.getIdrol() ==0) {
			
			dto.setIdrol(0);
		}
		
		Grupo ap = grupoService.saveAndrol(dto, dto.getIdrol(), dto.getIdNombrerol());
		
		dto.setIdgrupo(ap.getIdgrupo());
		dto.setEmail(ap.getUsuarios().getEmail());
		for (SubGrupo sub :ap.getSubGrupos()) {
			dto.setId_sub_grupo(sub.getId_sub_grupo());
		}
		
		dto.setIdproyecto(ap.getProyectos().getIdproyecto());
		log.info("rol.getId_rol_proyecto().toString()");
		for (RolProyecto rol :ap.getRolProyectos()) {
			log.info("rol.getId_rol_proyecto().toString()");
			log.info(rol.getId_rol_proyecto().toString());
			log.info("vrol.getId_rol_proyecto().toString()");
			dto.setIdrol(rol.getId_rol_proyecto());	
		}
		
		
        return ResponseEntity.ok(dto);
    }

    @RequestMapping("/faseResponsables")
    @ResponseBody
    public ResponseEntity<?> CrearfaseConResponsables(@Valid @RequestBody CrearfaseConResponsablesDTO crearfaseConResponsablesDTO) throws Exception {
    	
    	String salida =grupoService.CrearfaseConResponsables(crearfaseConResponsablesDTO);
    	
    	return ResponseEntity.ok(salida);
    	//return new  ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/grupoDeTrabajo/{idProyecto}")
    @ResponseBody
    public ResponseEntity<?> grupoDeTrabajo(@PathVariable("idProyecto") Integer idProyecto) throws Exception {
    	if( idProyecto == null) {
    		throw new Exception("{\"success\":false,\"status\":Fail, \"message\": Error en el ID del proyecto; Es Nulo }");
    	}
    	if(idProyecto >0 ) {
    		List<GrupoDTO> DTOList = grupoService.grupoDeTrabajo(idProyecto);
    		if(DTOList.isEmpty() ) {
    			throw new Exception("{\"success\":false,\"status\":Fail, \"message\": No hay Usuarios Matriculados al proyecto "+idProyecto+"}");
    			
    		}else {
    			return ResponseEntity.ok(DTOList);	
    		}
    			
    	}else {
    		throw new Exception("{\"success\":false,\"status\":Fail, \"message\": Error en el ID del proyecto; el Id es menor a 1 }");
    	}
    	
    }
    
  
    
    @RequestMapping("/consultarIdsUser/{Usuario}")
    public ResponseEntity<?> controlPorFases(@PathVariable("Usuario") String Usuario) throws Exception {
    	
    	return ResponseEntity.ok(grupoService.controlPorFases(Usuario));
    };
    
    @RequestMapping("/eliminarUsuario/{Usuario}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable("Usuario") String Usuario) throws Exception {
    	
    	return ResponseEntity.ok(grupoService.controlPorFases(Usuario));
    };
    
    @RequestMapping("/responsablesEnFaseoReunion/{idFase}")
    public ResponseEntity<?> responsablesEnFaseoReunion(@PathVariable("idFase") Integer idFase) throws Exception {
    	
    	return ResponseEntity.ok(grupoService.responsablesEnFaseoReunion(idFase));
    };
    
	
}
