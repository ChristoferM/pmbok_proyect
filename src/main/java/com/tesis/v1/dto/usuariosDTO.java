package com.tesis.v1.dto;

import javax.validation.constraints.Email;

public class usuariosDTO {
	
	//private Integer  idusuario;
	
	@Email
	private String  email  ;
	
	private String  nombre   ;
	
	private String  password ;
	
	private String  token   ;
	
	private String  activo ;
	
	
	/*
	public Integer getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}*/
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}
	
	
	
}
