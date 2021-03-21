package com.tesis.v1.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reuniones", schema = "public")
public class reuniones {

	private Integer idreuniones ;
	private String nombrereunion ;
	private String descripcionreunion ;
	
	private proyectos proyectos;
  	// idproyecto int4 NOT NULL,
	
	private faseproyecto faseproyecto; 
	// idfase int4 NOT NULL,
	
	private actas actas;// HIJA
	
	@Id
	@Column(name = "idreuniones", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdreuniones() {
		return idreuniones;
	}
	
	
	public void setIdreuniones(Integer idreuniones) {
		this.idreuniones = idreuniones;
	}
	
	@Column(name = "nombrereunion")
	public String getNombrereunion() {
		return nombrereunion;
	}
	
	
	public void setNombrereunion(String nombrereunion) {
		this.nombrereunion = nombrereunion;
	}
	
	@Column(name = "descripcionreunion")
	public String getDescripcionreunion() {
		return descripcionreunion;
	}
	
	
	public void setDescripcionreunion(String descripcionreunion) {
		this.descripcionreunion = descripcionreunion;
	}
	
	//--------------------------- PROYECTOS
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "idproyecto")
	public proyectos getProyectos() {
		return proyectos;
	}
	
	public void setProyectos(proyectos proyecto) {
		this.proyectos = proyecto;
	}
	// ---------------------------------- FASE PROYECTO

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "idfase")
	public faseproyecto getFaseproyecto() {
		return faseproyecto;
	}


	public void setFaseproyecto(faseproyecto faseproyecto) {
		this.faseproyecto = faseproyecto;
	}
	// -- Relacion Con hijo ACTAS UNO A UNO

	@OneToOne(mappedBy = "reuniones", cascade = CascadeType.ALL)
	public actas getActas() {
		return actas;
	}


	public void setActas(actas actas) {
		this.actas = actas;
	}
	
	
	
	
	

	
}
