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
@Table(name = "entradacta", schema = "public")
public class entradacta {

	private Integer identrada;
	private String acuerdos;
	private String factores;
	private String activosprocesos;

	// Entidades hijas

	
	private List<casonegocio> casonegocio = new ArrayList<casonegocio>(0);

	
	private List<planesgestionbeneficios> planesgestionbeneficios = new ArrayList<planesgestionbeneficios>(0);

	private actas actas ; // PADRE
	// idactas int4 NOT NULL,

	
	@Id
	@Column(name = "identrada", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdentrada() {
		return identrada;
	}

	public void setIdentrada(Integer identrada) {
		this.identrada = identrada;
	}

	@Column(name = "acuerdos", nullable = false)
	public String getAcuerdos() {
		return acuerdos;
	}

	public void setAcuerdos(String acuerdos) {
		this.acuerdos = acuerdos;
	}

	@Column(name = "factores", nullable = false)
	public String getFactores() {
		return factores;
	}

	public void setFactores(String factores) {
		this.factores = factores;
	}

	@Column(name = "activosprocesos", nullable = false)
	public String getActivosprocesos() {
		return activosprocesos;
	}

	public void setActivosprocesos(String activosprocesos) {
		this.activosprocesos = activosprocesos;
	}

	// ------------------------- ENTIDAD PADRE
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "idactas")
	public actas getActas() {
		return actas;
	}

	public void setActas(actas actas) {
		this.actas = actas;
	}
	

	// ------------------------- Entidades hijas

	//@OneToOne(mappedBy = "entradacta", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "entradacta")
	public List<casonegocio>  getCasonegocio() {
		return casonegocio;
	}

	public void setCasonegocio(List<casonegocio>  casonegocio) {
		this.casonegocio = casonegocio;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "entradacta")
	public List<planesgestionbeneficios> getPlanesgestionbeneficios() {
		return planesgestionbeneficios;
	}

	public void setPlanesgestionbeneficios(List<planesgestionbeneficios> planesgestionbeneficios) {
		this.planesgestionbeneficios = planesgestionbeneficios;
	}

}
