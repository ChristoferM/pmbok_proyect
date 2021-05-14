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
public class Reunion {

	private Integer idreuniones ;
	private String nombrereunion ;
	private String descripcionreunion ;
	
	private Proyecto proyectos;
  	// idproyecto int4 NOT NULL,
	
	private FaseProyecto faseproyecto; 
	// idfase int4 NOT NULL,

	private List<Acta> actas = new ArrayList<Acta>(0); //HIJA
	
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
	public Proyecto getProyectos() {
		return proyectos;
	}
	
	public void setProyectos(Proyecto proyecto) {
		this.proyectos = proyecto;
	}
	// ---------------------------------- FASE PROYECTO PADRE

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "idfase")
	public FaseProyecto getFaseproyecto() {
		return faseproyecto;
	}


	public void setFaseproyecto(FaseProyecto faseproyecto) {
		this.faseproyecto = faseproyecto;
	}
	// ----------------------------------  ACTAS HIJO
	

	//@OneToOne(mappedBy = "Reunion", cascade = CascadeType.ALL)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "reuniones")
	public List<Acta> getActas() {
		return actas;
	}


	public void setActas(List<Acta> actas) {
		this.actas = actas;
	}
	
	
	
	
	

	
}
