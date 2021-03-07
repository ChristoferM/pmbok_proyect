package com.tesis.v1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "herramientasacta", schema = "public")
public class herramientasacta {
	
	private Integer idherramienta ;
	private String juicioexpertos;
	private String recopilaciondatos ;
	private String habilidades ;
	private String herramientareuniones ;
	
	   //idactas int4 NOT NULL,
	
	
	@Id
	@Column(name = "idherramienta", unique = true, nullable = false)
	public Integer getIdherramienta() {
		return idherramienta;
	}
	public void setIdherramienta(Integer idherramienta) {
		this.idherramienta = idherramienta;
	}
	public String getJuicioexpertos() {
		return juicioexpertos;
	}
	public void setJuicioexpertos(String juicioexpertos) {
		this.juicioexpertos = juicioexpertos;
	}
	public String getRecopilaciondatos() {
		return recopilaciondatos;
	}
	public void setRecopilaciondatos(String recopilaciondatos) {
		this.recopilaciondatos = recopilaciondatos;
	}
	public String getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(String habilidades) {
		this.habilidades = habilidades;
	}
	public String getHerramientareuniones() {
		return herramientareuniones;
	}
	public void setHerramientareuniones(String herramientareuniones) {
		this.herramientareuniones = herramientareuniones;
	}

	
	
	
	

}
