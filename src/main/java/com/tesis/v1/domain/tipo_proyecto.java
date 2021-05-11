package com.tesis.v1.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_proyecto", schema = "public")
public class tipo_proyecto {
	
	private String tipo_id;
	private String clasificacion;
	
	private List<proyectos> proyectos = new ArrayList<proyectos>(0);

	
	
	
	@Id
	@Column(name = "tipo_id", nullable = false)
	public String getTipo_id() {
		return tipo_id;
	}
	public void setTipo_id(String tipo_id) {
		this.tipo_id = tipo_id;
	}
	
	@Column(name = "clasificacion")
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = proyectos.class)
	public List<proyectos> getProyectos() {
		return proyectos;
	}
	public void setProyectos(List<proyectos> proyectos) {
		this.proyectos = proyectos;
	}
	
	
	
	
}
