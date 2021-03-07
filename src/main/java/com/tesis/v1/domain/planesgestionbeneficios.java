package com.tesis.v1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "planesgestionbeneficios", schema = "public")
public class planesgestionbeneficios {
	private Integer id_plan_gb ;
	private String acciones ;
	private String componentes ;
	private String prodcutos ;
	private String servicios ;
	private String resultado ;
	
	
	// identrada int4 NOT NULL,
	
	@Id
	@Column(name = "id_plan_gb", unique = true, nullable = false)
	public Integer getId_plan_gb() {
		return id_plan_gb;
	}
	public void setId_plan_gb(Integer id_plan_gb) {
		this.id_plan_gb = id_plan_gb;
	}
	public String getAcciones() {
		return acciones;
	}
	public void setAcciones(String acciones) {
		this.acciones = acciones;
	}
	public String getComponentes() {
		return componentes;
	}
	public void setComponentes(String componentes) {
		this.componentes = componentes;
	}
	public String getProdcutos() {
		return prodcutos;
	}
	public void setProdcutos(String prodcutos) {
		this.prodcutos = prodcutos;
	}
	public String getServicios() {
		return servicios;
	}
	public void setServicios(String servicios) {
		this.servicios = servicios;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	
	
	

}
