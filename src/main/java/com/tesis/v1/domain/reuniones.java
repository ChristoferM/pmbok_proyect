package com.tesis.v1.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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

	private List<actas> actas = new ArrayList<actas>(0); //HIJA
	
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
	
	//--------------------------- PROYECTOS PADRE
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "idproyecto")
	public proyectos getProyectos() {
		return proyectos;
	}
	
	public void setProyectos(proyectos proyecto) {
		this.proyectos = proyecto;
	}
	// ---------------------------------- FASE PROYECTO PADRE

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "idfase")
	public faseproyecto getFaseproyecto() {
		return faseproyecto;
	}


	public void setFaseproyecto(faseproyecto faseproyecto) {
		this.faseproyecto = faseproyecto;
	}
	// ----------------------------------  ACTAS HIJO
	

	//@OneToOne(mappedBy = "reuniones", cascade = CascadeType.ALL)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "reuniones")
	public List<actas> getActas() {
		return actas;
	}


	public void setActas(List<actas> actas) {
		this.actas = actas;
	}
	
	
	
	
	

	
}
