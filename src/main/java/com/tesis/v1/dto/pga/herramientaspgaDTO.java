package com.tesis.v1.dto.pga;

public class herramientaspgaDTO {
	
	private Integer idherramientapga;
	private String juicioexpertos ;
	private String analisis ;
	
	private Integer idpga;
    private Boolean estado;
    
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
	
	
	

}
