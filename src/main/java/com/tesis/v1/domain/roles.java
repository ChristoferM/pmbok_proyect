	package com.tesis.v1.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles", schema = "public")
public class roles {
	
	private Integer idrol ;
	private String nombrerol ;
	
	private List<rolproyecto> rolProyectos = new ArrayList<rolproyecto>(0);
	
	@Id
	@Column(name = "idrol", unique = true, nullable = false)
	public Integer getIdrol() {
		return idrol;
	}
	public void setIdrol(Integer idrol) {
		this.idrol = idrol;
	}
	public String getNombrerol() {
		return nombrerol;
	}
	public void setNombrerol(String nombrerol) {
		this.nombrerol = nombrerol;
	}
	
	
	
	//---
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	public List<rolproyecto> getRolProyectos() {
		return rolProyectos;
	}
	public void setRolProyectos(List<rolproyecto> rolProyectos) {
		this.rolProyectos = rolProyectos;
	}
	
	
}
