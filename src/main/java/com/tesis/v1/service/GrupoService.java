package com.tesis.v1.service;

import java.util.List;

import com.tesis.v1.domain.Grupo;
import com.tesis.v1.domain.Reunion;
import com.tesis.v1.dto.ControlFasesDTO;
import com.tesis.v1.dto.CrearfaseConResponsablesDTO;
import com.tesis.v1.dto.GrupoDTO;
import com.tesis.v1.dto.ResponsablesDTO;
import com.tesis.v1.dto.RolesDTO;
import com.tesis.v1.dto.UsuariosDTO;
import com.tesis.v1.dto.controlFasesDTOs.ControlFase_01DTO;

public interface GrupoService  extends GenericService<Grupo,Integer>{
	
	 public Grupo saveAndrol(GrupoDTO entity,Integer idrol,String idNombrerol ) throws Exception;
	 
	 public Reunion CrearfaseConResponsables (CrearfaseConResponsablesDTO crearfaseConResponsablesDTO) throws Exception;
	 
	 public List<RolesDTO> rolesDisponibles() throws Exception;
	 
	 public List<GrupoDTO> grupoDeTrabajo(Integer idProyecto) throws Exception;
	 	 
	 // public List<ControlFasesDTO> controlPorFases(String Usuario) throws Exception;
	 public List<ControlFase_01DTO> controlPorFases(String Usuario) throws Exception;
	 public List<ControlFase_01DTO> controlPorFasesParaAdmin(String Usuario) throws Exception;
	 
	 	 
	 public List<ControlFase_01DTO> controlParticipacionesPorFases(Integer idProyecto,String Usuario) throws Exception;
	 
	 public List<ControlFasesDTO> controlParticipacionesPorFasesNOHABILITADO(Integer idProyecto,String Usuario) throws Exception;
	 
	 public List<GrupoDTO> buscarParticipaciones(String Usuario) throws Exception;
	 
	 public String elimiarUsuarioMatriculado(String Usuario,Integer idProyecto) throws Exception ;
	 
	 public String elimiarUsuarioPorRolenProyecto(String Usuario,Integer idProyecto,String Rol) throws Exception ;
	 
	 public List<UsuariosDTO> verGrupoDeTrabajoPorReunion() throws Exception;
	 
	 public List<ResponsablesDTO>  responsablesEnFaseoReunion(Integer idProyecto) throws Exception;
	 
	 
}
