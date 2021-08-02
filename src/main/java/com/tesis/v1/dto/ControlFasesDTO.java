package com.tesis.v1.dto;



public class ControlFasesDTO {

	private String nombreProyecto;
	private String descripcionProyecto;
	private String nombreReunion;
	private String descripcionReunion;
	private String descripcionFase;
	private String inicio;
	private String fin;
	private String estado;
	private String nombre;
	
	
	
	
	public ControlFasesDTO() {
		super();
	}
	public ControlFasesDTO(String nombreProyecto, String descripcionProyecto, String nombreReunion,
			String descripcionReunion, String descripcionFase, String inicio, String fin, String estado, String nombre) {
		super();
		this.nombreProyecto = nombreProyecto;
		this.descripcionProyecto = descripcionProyecto;
		this.nombreReunion = nombreReunion;
		this.descripcionReunion = descripcionReunion;
		this.descripcionFase = descripcionFase;
		this.inicio = inicio;
		this.fin = fin;
		this.estado = estado;
		this.nombre = nombre;
	}
	public String getNombreProyecto() {
		return nombreProyecto;
	}
	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}
	public String getDescripcionProyecto() {
		return descripcionProyecto;
	}
	public void setDescripcionProyecto(String descripcionProyecto) {
		this.descripcionProyecto = descripcionProyecto;
	}
	public String getNombreReunion() {
		return nombreReunion;
	}
	public void setNombreReunion(String nombreReunion) {
		this.nombreReunion = nombreReunion;
	}
	public String getDescripcionReunion() {
		return descripcionReunion;
	}
	public void setDescripcionReunion(String descripcionReunion) {
		this.descripcionReunion = descripcionReunion;
	}
	public String getDescripcionFase() {
		return descripcionFase;
	}
	public void setDescripcionFase(String descripcionFase) {
		this.descripcionFase = descripcionFase;
	}
	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
/*
 SELECT 
proyectos.nombre as nombreProyecto,
proyectos.descripcion as descripcionProyecto,
reuniones.nombrereunion as nombreReunion,
reuniones.descripcionreunion as descripcionReunion,
faseproyecto.descripcionfase as descripcionFase,
faseproyecto.tiempoinicio as inicio,
faseproyecto.tiempofin as fin,
(CASE WHEN faseproyecto.tiempofin < CURRENT_String THEN 'Finalizado' ELSE 'En Proceso' END),
tipofases.nombrefase as nombre
FROM
proyectos, reuniones,faseproyecto,tipofases
WHERE
proyectos.idproyecto=  reuniones.idproyecto AND
reuniones.idfase = faseproyecto.idfase AND
faseproyecto.idtipofase  = tipofases.idtipofase AND
proyectos."admin" = 'userNew1@test.com.co';  
  
 */
