package com.tesis.v1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faseproyecto", schema = "public")
public class faseproyecto {

	private Integer idfase ;
	private String nombrefase ;
	private String descripcionfase ;
	
	
	@Id
	@Column(name = "idfase", unique = true, nullable = false)
	public Integer getIdfase() {
		return idfase;
	}
	public void setIdfase(Integer idfase) {
		this.idfase = idfase;
	}
	public String getNombrefase() {
		return nombrefase;
	}
	public void setNombrefase(String nombrefase) {
		this.nombrefase = nombrefase;
	}
	public String getDescripcionfase() {
		return descripcionfase;
	}
	public void setDescripcionfase(String descripcionfase) {
		this.descripcionfase = descripcionfase;
	}
	
	
	
	
	
}
