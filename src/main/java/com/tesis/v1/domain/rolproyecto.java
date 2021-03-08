package com.tesis.v1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rolproyecto", schema = "public")
public class rolproyecto {

	private Integer id_rol_proyecto;
	// idrol int4 NOT NULL,
	// idgrupo int4 NOT NULL,
	private grupo grupo;
	
	private roles roles;

	@Id
	@Column(name = "id_rol_proyecto", unique = true, nullable = false)
	public Integer getId_rol_proyecto() {
		return id_rol_proyecto;
	}

	public void setId_rol_proyecto(Integer id_rol_proyecto) {
		this.id_rol_proyecto = id_rol_proyecto;
	}

	// ----

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idgrupo")
	public grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(grupo grupo) {
		this.grupo = grupo;
	}


	//-- 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idrol")
	public roles getRoles() {
		return roles;
	}

	public void setRoles(roles roles) {
		this.roles = roles;
	}

	
}
