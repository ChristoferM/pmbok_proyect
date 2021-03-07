package com.tesis.v1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reuniones", schema = "public")
public class reuniones {

	private Integer idreuniones ;
	private String nombrereunion ;
	private String descripcionreunion ;
	
  	// idproyecto int4 NOT NULL,
  	// idfase int4 NOT NULL,
	
	@Id
	@Column(name = "idreuniones", unique = true, nullable = false)
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
