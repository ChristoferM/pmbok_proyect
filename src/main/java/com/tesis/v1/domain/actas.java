package com.tesis.v1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "actas", schema = "public")
public class actas {

	private Integer idactas ;
	private  Integer idreuniones ;
	
	@Id
	@Column(name = "idactas", unique = true, nullable = false)
	public Integer getIdactas() {
		return idactas;
	}
	public void setIdactas(Integer idactas) {
		this.idactas = idactas;
	}
	public Integer getIdreuniones() {
		return idreuniones;
	}
	public void setIdreuniones(Integer idreuniones) {
		this.idreuniones = idreuniones;
	}
	
	
	
	
}
