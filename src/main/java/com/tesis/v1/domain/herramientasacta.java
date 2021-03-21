package com.tesis.v1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "herramientasacta", schema = "public")
public class herramientasacta {

	private Integer idherramienta;
	private String juicioexpertos;
	private String recopilaciondatos;
	private String habilidades;
	private String herramientareuniones;

	private actas actas ; // PADRE
	
	// idactas int4 NOT NULL,

	@Id
	@Column(name = "idherramienta", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdherramienta() {
		return idherramienta;
	}

	public void setIdherramienta(Integer idherramienta) {
		this.idherramienta = idherramienta;
	}

	@Column(name = "juicioexpertos", nullable = false)
	public String getJuicioexpertos() {
		return juicioexpertos;
	}

	public void setJuicioexpertos(String juicioexpertos) {
		this.juicioexpertos = juicioexpertos;
	}

	@Column(name = "recopilaciondatos", nullable = false)
	public String getRecopilaciondatos() {
		return recopilaciondatos;
	}

	public void setRecopilaciondatos(String recopilaciondatos) {
		this.recopilaciondatos = recopilaciondatos;
	}

	@Column(name = "habilidades", nullable = false)
	public String getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(String habilidades) {
		this.habilidades = habilidades;
	}

	@Column(name = "herramientareuniones", nullable = false)
	public String getHerramientareuniones() {
		return herramientareuniones;
	}

	public void setHerramientareuniones(String herramientareuniones) {
		this.herramientareuniones = herramientareuniones;
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
	
	

}
