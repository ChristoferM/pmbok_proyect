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
@Table(name = "proyectos", schema = "public")
public class proyectos {
	private Integer idproyecto ;
	private String nombre ;
	private String descripcion ;
	private String  admin;
	
	private List<grupo> grupo = new ArrayList<	grupo>(0);
	
	
	private List<reuniones> reuniones = new ArrayList<reuniones>(0);
	
	
	@Id
	@Column(name = "idproyecto", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdproyecto() {
		return idproyecto;
	}
	public void setIdproyecto(Integer idproyecto) {
		this.idproyecto = idproyecto;
	}
	
	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "descripcion", nullable = false)
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "admin", nullable = false)
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	
	
	// ---------------------
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proyectos")
	public List<grupo> getGrupo() {
		return grupo;
	}
	public void setGrupo(List<grupo> grupo) {
		this.grupo = grupo;
	}
	
	
	//---------------------------
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proyectos")
	public List<reuniones> getReuniones() {
		return reuniones;
	}
	public void setReuniones(List<reuniones> reuniones) {
		this.reuniones = reuniones;
	}
	
	
	
	

}
