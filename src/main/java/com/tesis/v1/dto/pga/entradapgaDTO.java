package com.tesis.v1.dto.pga;

import com.tesis.v1.domain.pga.pga;

public class entradapgaDTO {
	private Integer identradapga;
	private String estandares;
	private String objetivocalidad;
	private String ciclo;
	private String enfoque;
	private String activosprocesos;    
	private Boolean estado;
	private String participa ;
	
	
	private Integer idfase;
	private Integer idproyecto;
	
	
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

    public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	private Integer idpga;

	public Integer getIdentradapga() {
		return identradapga;
	}

	public void setIdentradapga(Integer identradapga) {
		this.identradapga = identradapga;
	}

	public String getEstandares() {
		return estandares;
	}

	public void setEstandares(String estandares) {
		this.estandares = estandares;
	}

	public String getEnfoque() {
		return this.enfoque;
	}

	public void setEnfoque(String enfoque) {
		this.enfoque = enfoque;
	}

	public String getObjetivocalidad() {
		return objetivocalidad;
	}

	public void setObjetivocalidad(String objetivocalidad) {
		this.objetivocalidad = objetivocalidad;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

 

	public String getActivosprocesos() {
		return activosprocesos;
	}

	public void setActivosprocesos(String activosprocesos) {
		this.activosprocesos = activosprocesos;
	}

	public Integer getIdpga() {
		return idpga;
	}

	public void setIdpga(Integer idpga) {
		this.idpga = idpga;
	}

	

	

}
