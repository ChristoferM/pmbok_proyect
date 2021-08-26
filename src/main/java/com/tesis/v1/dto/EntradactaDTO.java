package com.tesis.v1.dto;

public class EntradactaDTO {

    private Integer idActa;
    private Integer identrada;
    private String acuerdos;
    private String factores;
    private String activosprocesos;
    private Boolean estado;
	private String participa ;
	
	public String getParticipa() {
		return participa;
	}
	public void setParticipa(String participa) {
		this.participa = participa;
	}

    
    public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

    //idactas int4 NOT NULL,
    public Integer getIdActa() {
        return idActa;
    }

    public void setIdActa(Integer idActa) {
        this.idActa = idActa;
    }

    public Integer getIdentrada() {
        return identrada;
    }

    public void setIdentrada(Integer identrada) {
        this.identrada = identrada;
    }

    public String getAcuerdos() {
        return acuerdos;
    }

    public void setAcuerdos(String acuerdos) {
        this.acuerdos = acuerdos;
    }

    public String getFactores() {
        return factores;
    }

    public void setFactores(String factores) {
        this.factores = factores;
    }

    public String getActivosprocesos() {
        return activosprocesos;
    }

    public void setActivosprocesos(String activosprocesos) {
        this.activosprocesos = activosprocesos;
    }

}
