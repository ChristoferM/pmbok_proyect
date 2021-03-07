package com.tesis.v1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subgrupo", schema = "public")
public class subgrupo {
	
	private Integer id_sub_grupo ;
	
	// idfase int4 NOT NULL,
	// idgrupo int4 NOT NULL  , 
	
	@Id
	@Column(name = "id_sub_grupo", unique = true, nullable = false)
	public Integer getId_sub_grupo() {
		return id_sub_grupo;
	}

	public void setId_sub_grupo(Integer id_sub_grupo) {
		this.id_sub_grupo = id_sub_grupo;
	}

	
	
	

}
