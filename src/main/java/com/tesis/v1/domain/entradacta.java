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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "entradacta", schema = "public")
public class entradacta {

	private Integer identrada;
	private String acuerdos;
	private String factores;
	private String activosprocesos;

	// Entidades hijas

	private casonegocio casonegocio;

	private planesgestionbeneficios planesgestionbeneficios;

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
	@OneToOne
	@JoinColumn(name = "idactas", updatable = false, nullable = false)
	public actas getActas() {
		return actas;
	}

	public void setActas(actas actas) {
		this.actas = actas;
	}
	

	// ------------------------- Entidades hijas

	@OneToOne(mappedBy = "entradacta", cascade = CascadeType.ALL)
	public casonegocio getCasonegocio() {
		return casonegocio;
	}

	public void setCasonegocio(casonegocio casonegocio) {
		this.casonegocio = casonegocio;
	}

	@OneToOne(mappedBy = "entradacta", cascade = CascadeType.ALL)
	public planesgestionbeneficios getPlanesgestionbeneficios() {
		return planesgestionbeneficios;
	}

	public void setPlanesgestionbeneficios(planesgestionbeneficios planesgestionbeneficios) {
		this.planesgestionbeneficios = planesgestionbeneficios;
	}

}
