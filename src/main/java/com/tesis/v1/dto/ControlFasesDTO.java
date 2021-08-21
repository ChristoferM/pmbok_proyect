package com.tesis.v1.dto;

import java.util.List;

import com.tesis.v1.domain.FaseProyecto;

public class ControlFasesDTO {

	
	// Proyectos
	private  List<ProyectoDTO> proyectos;
	// Reuniones
	private  List<ReunionesDTO> reuniones;
	// Faseproyecto
	private  List<FaseProyectoDTO> fases;
	
	public List<ProyectoDTO> getProyectos() {
		return proyectos;
	}
	public void setProyectos(List<ProyectoDTO> proyectos) {
		this.proyectos = proyectos;
	}
	public List<ReunionesDTO> getReuniones() {
		return reuniones;
	}
	public void setReuniones(List<ReunionesDTO> reuniones) {
		this.reuniones = reuniones;
	}
	public List<FaseProyectoDTO> getFases() {
		return fases;
	}
	public void setFases(List<FaseProyectoDTO> fases) {
		this.fases = fases;
	}

	
}

/*
 * SELECT proyectos.nombre as nombreProyecto, proyectos.descripcion as
 * descripcionProyecto, reuniones.nombrereunion as nombreReunion,
 * reuniones.descripcionreunion as descripcionReunion,
 * faseproyecto.descripcionfase as descripcionFase, faseproyecto.tiempoinicio as
 * inicio, faseproyecto.tiempofin as fin, (CASE WHEN faseproyecto.tiempofin <
 * CURRENT_String THEN 'Finalizado' ELSE 'En Proceso' END), tipofases.nombrefase
 * as nombre FROM proyectos, reuniones,faseproyecto,tipofases WHERE
 * proyectos.idproyecto= reuniones.idproyecto AND reuniones.idfase =
 * faseproyecto.idfase AND faseproyecto.idtipofase = tipofases.idtipofase AND
 * proyectos."admin" = 'userNew1@test.com.co';
 * 
 */
