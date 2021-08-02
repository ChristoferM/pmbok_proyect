package com.tesis.v1.service;

import java.util.List;

import com.tesis.v1.domain.Grupo;
import com.tesis.v1.dto.ControlFasesDTO;
import com.tesis.v1.dto.CrearfaseConResponsablesDTO;
import com.tesis.v1.dto.GrupoDTO;
import com.tesis.v1.dto.RolesDTO;
import com.tesis.v1.dto.UsuariosDTO;

public interface GrupoService  extends GenericService<Grupo,Integer>{
	
	 public Grupo saveAndrol(GrupoDTO entity,Integer idrol,String idNombrerol ) throws Exception;
	 
	 public String CrearfaseConResponsables (CrearfaseConResponsablesDTO crearfaseConResponsablesDTO) throws Exception;
	 
	 public List<RolesDTO> rolesDisponibles() throws Exception;
	 
	 public List<GrupoDTO> grupoDeTrabajo(Integer idProyecto) throws Exception;
	 
	 public List<UsuariosDTO> consultarIdsUser(List<UsuariosDTO> Usuarios) throws Exception;
	 
	 public List<ControlFasesDTO> controlPorFases(String Usuario) throws Exception;
}
