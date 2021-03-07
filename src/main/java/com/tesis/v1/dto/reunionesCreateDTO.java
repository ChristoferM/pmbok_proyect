package com.tesis.v1.dto;

public class reunionesCreateDTO {

	private Integer idreuniones ;
	private String nombrereunion ;
	private String descripcionreunion ;
	
  	// idproyecto int4 NOT NULL,
  	// idfase int4 NOT NULL,
	 
	public Integer getIdreuniones() {
		return idreuniones;
	}
	public void setIdreuniones(Integer idreuniones) {
		this.idreuniones = idreuniones;
	}
	public String getNombrereunion() {
		return nombrereunion;
	}
	public void setNombrereunion(String nombrereunion) {
		this.nombrereunion = nombrereunion;
	}
	public String getDescripcionreunion() {
		return descripcionreunion;
	}
	public void setDescripcionreunion(String descripcionreunion) {
		this.descripcionreunion = descripcionreunion;
	}

	
	
	
}
