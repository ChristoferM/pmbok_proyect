package com.tesis.v1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "casonegocio", schema = "public")
public class casonegocio {

	private Integer id_caso_negocio ;
	private String  metas ;
	private String  objetivos ;
	private String  incidentes ;
	private String  oportunidades ;
	//identrada int4 NOT NULL,
	 
	 
	 
	
	@Id
	@Column(name = "id_caso_negocio", unique = true, nullable = false)
	public Integer getId_caso_negocio() {
		return id_caso_negocio;
	}
	public void setId_caso_negocio(Integer id_caso_negocio) {
		this.id_caso_negocio = id_caso_negocio;
	}
	public String getMetas() {
		return metas;
	}
	public void setMetas(String metas) {
		this.metas = metas;
	}
	public String getObjetivos() {
		return objetivos;
	}
	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}
	public String getIncidentes() {
		return incidentes;
	}
	public void setIncidentes(String incidentes) {
		this.incidentes = incidentes;
	}
	public String getOportunidades() {
		return oportunidades;
	}
	public void setOportunidades(String oportunidades) {
		this.oportunidades = oportunidades;
	}
	  
	 
}
