package com.tesis.v1.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipofases", schema = "public")
public class tipofases implements Serializable{
	
	Integer idtipofase;
	String nombrefase;
	public tipofases() {
	}
	public tipofases(Integer idtipofase, String nombrefase) {
		super();
		this.idtipofase = idtipofase;
		this.nombrefase = nombrefase;
	}
	
	@Id
	@Column(name = "idtipofase", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdtipofase() {
		return idtipofase;
	}
	public void setIdtipofase(Integer idtipofase) {
		this.idtipofase = idtipofase;
	}
	
	@Column(name = "nombrefase", unique = true, nullable = false)
	public String getNombrefase() {
		return nombrefase;
	}
	public void setNombrefase(String nombrefase) {
		this.nombrefase = nombrefase;
	}
	
	
	

}
