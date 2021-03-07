package com.tesis.v1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entradacta", schema = "public")
public class entradacta {
	private Integer identrada ;
	private String acuerdos ;
	private String factores;
	private String activosprocesos ;
	
	//idactas int4 NOT NULL,
	
	
	@Id
	@Column(name = "identrada", unique = true, nullable = false)
	public Integer getIdentrada() {
		return identrada;
	}
	public void setIdentrada(Integer identrada) {
		this.identrada = identrada;
	}
	public String getAcuerdos() {
		return acuerdos;
	}
	public void setAcuerdos(String acuerdos) {
		this.acuerdos = acuerdos;
	}
	public String getFactores() {
		return factores;
	}
	public void setFactores(String factores) {
		this.factores = factores;
	}
	public String getActivosprocesos() {
		return activosprocesos;
	}
	public void setActivosprocesos(String activosprocesos) {
		this.activosprocesos = activosprocesos;
	}

	
	

}
