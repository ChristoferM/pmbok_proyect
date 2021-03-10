package com.tesis.v1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subgrupo", schema = "public")
public class subgrupo {
	
	private Integer id_sub_grupo ;
	
	private grupo grupo;
	// idgrupo int4 NOT NULL  ,
	
	private faseproyecto faseproyecto; 
	// idfase int4 NOT NULL,
	 
	
	@Id
	@Column(name = "id_sub_grupo", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId_sub_grupo() {
		return id_sub_grupo;
	}

	public void setId_sub_grupo(Integer id_sub_grupo) {
		this.id_sub_grupo = id_sub_grupo;
	}

	
	
	//----------------------------- grupos
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idgrupo")
	public grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(grupo grupo) {
		this.grupo = grupo;
	}
	/// ------------------------------- fases del proyecto
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "idfase")
	public faseproyecto getFaseproyecto() {
		return faseproyecto;
	}

	public void setFaseproyecto(faseproyecto faseproyecto) {
		this.faseproyecto = faseproyecto;
	}
	
	
	
	

}
