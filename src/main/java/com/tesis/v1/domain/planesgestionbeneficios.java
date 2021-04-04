package com.tesis.v1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "planesgestionbeneficios", schema = "public")
public class planesgestionbeneficios {
	private Integer id_plan_gb;
	private String acciones;
	private String componentes;
	private String prodcutos;
	private String servicios;
	private String resultado;
	// identrada int4 NOT NULL,

	// Entidad padre
	private entradacta entradacta;

	@Id
	@Column(name = "id_plan_gb", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId_plan_gb() {
		return id_plan_gb;
	}

	public void setId_plan_gb(Integer id_plan_gb) {
		this.id_plan_gb = id_plan_gb;
	}

	@Column(name = "acciones", nullable = false)
	public String getAcciones() {
		return acciones;
	}

	public void setAcciones(String acciones) {
		this.acciones = acciones;
	}

	@Column(name = "componentes", nullable = false)
	public String getComponentes() {
		return componentes;
	}

	public void setComponentes(String componentes) {
		this.componentes = componentes;
	}

	@Column(name = "prodcutos", nullable = false)
	public String getProdcutos() {
		return prodcutos;
	}

	public void setProdcutos(String prodcutos) {
		this.prodcutos = prodcutos;
	}

	@Column(name = "servicios", nullable = false)
	public String getServicios() {
		return servicios;
	}

	public void setServicios(String servicios) {
		this.servicios = servicios;
	}

	@Column(name = "resultado", nullable = false)
	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	// ----------------------------------------------------- Entidad padre

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "identrada")
	public entradacta getEntradacta() {
		return entradacta;
	}

	public void setEntradacta(entradacta entradacta) {
		this.entradacta = entradacta;
	}

}
