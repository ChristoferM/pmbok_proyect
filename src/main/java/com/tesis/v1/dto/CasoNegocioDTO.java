package com.tesis.v1.dto;

public class CasoNegocioDTO {

    private Integer id_caso_negocio;
    private String metas;
    private String objetivos;
    private String incidentes;
    private String oportunidades;
    private Integer idEntradaActa;
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
    public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
}
