package com.tesis.v1.dto.pga;

import javax.persistence.Column;

public class herramientaspgaDTO {
	
	private Integer idherramientapga;
	
	private String juicioexpertos ;
	private String analisis ;
	private Integer idpga;
	
    private Boolean estado;
    private String participa ;
	private Integer idfase;
	private Integer idproyecto;
	
	
    
    
    
    public Integer getIdpga() {
		return idpga;
	}

	public void setIdpga(Integer idpga) {
		this.idpga = idpga;
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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	public Integer getIdherramientapga() {
		return idherramientapga;
	}

	public void setIdherramientapga(Integer idherramientapga) {
		this.idherramientapga = idherramientapga;
	}

	public String getJuicioexpertos() {
		return juicioexpertos;
	}

	public void setJuicioexpertos(String juicioexpertos) {
		this.juicioexpertos = juicioexpertos;
	}

	public String getAnalisis() {
		return analisis;
	}

	public void setAnalisis(String analisis) {
		this.analisis = analisis;
	}

	public Integer getIdpdp() {
		return idpga;
	}

	public void setIdpdp(Integer idpga) {
		this.idpga = idpga;
	}
	
	public String getParticipa() {
		return participa;
	}
	public void setParticipa(String participa) {
		this.participa = participa;
	}

	
	

}
