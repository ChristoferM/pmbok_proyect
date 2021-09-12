package com.tesis.v1.dto.controlFasesDTOs;

import java.util.List;



public class ControlFase_01DTO {

	
	private Integer idproyecto ;
	private String nombre ;
	private String descripcion ;
	private String  admin;
	private String tipo_id;
	
	private  List<ControlFase_02DTO> Reuniones;

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

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getTipo_id() {
		return tipo_id;
	}

	public void setTipo_id(String tipo_id) {
		this.tipo_id = tipo_id;
	}

	public List<ControlFase_02DTO> getReuniones() {
		return Reuniones;
	}

	public void setReuniones(List<ControlFase_02DTO> reuniones) {
		Reuniones = reuniones;
	}
	
	
	
}
