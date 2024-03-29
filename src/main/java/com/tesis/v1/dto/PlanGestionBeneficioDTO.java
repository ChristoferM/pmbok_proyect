package com.tesis.v1.dto;

public class PlanGestionBeneficioDTO {

    private Integer idEntradaActa;
    private Integer id_plan_gb;
    private String acciones;
    private String componentes;
    private String prodcutos;
    private String servicios;
    private String resultado;
    private Boolean estado;
	private String participa ;

	public String getParticipa() {
		return participa;
	}
	public void setParticipa(String participa) {
		this.participa = participa;
	}
    // identrada int4 NOT NULL,
    public Integer getIdEntradaActa() {
        return idEntradaActa;
    }

    public void setIdEntradaActa(Integer idEntradaActa) {
        this.idEntradaActa = idEntradaActa;
    }

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
    public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
}
