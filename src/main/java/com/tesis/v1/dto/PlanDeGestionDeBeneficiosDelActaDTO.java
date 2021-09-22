package com.tesis.v1.dto;

public class PlanDeGestionDeBeneficiosDelActaDTO {

	private Integer id_plan_gb;
	private Integer identrada;
	private Boolean estado;
	private Integer idfase;
	private Integer idproyecto;
	private String participa;

	private String acciones;
	private String componentes;
	private String prodcutos;
	private String servicios;
	private String resultado;

	public Integer getId_plan_gb() {
		return id_plan_gb;
	}

	public void setId_plan_gb(Integer id_plan_gb) {
		this.id_plan_gb = id_plan_gb;
	}

	public Integer getIdentrada() {
		return identrada;
	}

	public String getAcciones() {
		return acciones;
	}

	public void setAcciones(String acciones) {
		this.acciones = acciones;
	}

	public void setIdentrada(Integer identrada) {
		this.identrada = identrada;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Integer getIdfase() {
		return idfase;
	}

	public void setIdfase(Integer idfase) {
		this.idfase = idfase;
	}

	public Integer getIdproyecto() {
		return idproyecto;
	}

	public void setIdproyecto(Integer idproyecto) {
		this.idproyecto = idproyecto;
	}

	public String getParticipa() {
		return participa;
	}

	public void setParticipa(String participa) {
		this.participa = participa;
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
