package com.tesis.v1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rolproyecto", schema = "public")
public class rolproyecto {
	private Integer id_rol_proyecto ;
	  // idrol int4 NOT NULL,
	  //idgrupo int4 NOT NULL,
	@Id
	@Column(name = "id_rol_proyecto", unique = true, nullable = false)
	public Integer getId_rol_proyecto() {
		return id_rol_proyecto;
	}

	public void setId_rol_proyecto(Integer id_rol_proyecto) {
		this.id_rol_proyecto = id_rol_proyecto;
	}
	
	
}
