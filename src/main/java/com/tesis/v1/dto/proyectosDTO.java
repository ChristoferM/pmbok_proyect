package com.tesis.v1.dto;

public class proyectosDTO {
	private Integer idproyecto ;
	private String nombre ;
	private String descripcion ;
	private String  admin;
	
	
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public Integer getIdproyecto() {
		return idproyecto;
	}
	public void setIdproyecto(Integer idproyecto) {
		this.idproyecto = idproyecto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	

}
