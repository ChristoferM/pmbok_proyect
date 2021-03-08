package com.tesis.v1.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "faseproyecto", schema = "public")
public class faseproyecto {

	private Integer idfase ;
	private String nombrefase ;
	private String descripcionfase ;
	
	/*private List<reuniones> reuniones = new ArrayList<reuniones>(0);
	
	private  List<subgrupo> subGrupos = new ArrayList<subgrupo>(0);*/ 
	
	@Id
	@Column(name = "idfase", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdfase() {
		return idfase;
	}
	public void setIdfase(Integer idfase) {
		this.idfase = idfase;
	}
	
	@Column(name = "nombrefase")
	public String getNombrefase() {
		return nombrefase;
	}
	public void setNombrefase(String nombrefase) {
		this.nombrefase = nombrefase;
	}
	
	@Column(name = "descripcionfase")
	public String getDescripcionfase() {
		return descripcionfase;
	}
	public void setDescripcionfase(String descripcionfase) {
		this.descripcionfase = descripcionfase;
	}

	
	//-- ---------------------------  CLASES CON LAS QUE SE CONECTA
	/*
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "faseproyecto")
	public List<reuniones> getReuniones() {
		return reuniones;
	}
	public void setReuniones(List<reuniones> reuniones) {
		this.reuniones = reuniones;
	}
	
	// ------------------
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "faseproyecto")
	public List<subgrupo> getSubGrupos() {
		return subGrupos;
	}
	public void setSubGrupos(List<subgrupo> subGrupos) {
		this.subGrupos = subGrupos;
	}*/
	
	
}
