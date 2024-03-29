package com.tesis.v1.dto.pdp;

public class EntradasDTO {

    private Integer identradapdp;
    private String otrosprocesos;
    private String factoresambientales;
    private String activosprocesos;
    private Integer idpdp;
    private Boolean estado;
	private String participa ;
	private Integer idfase;
	private Integer idproyecto;
	
	
	public Integer getIdproyecto() {
		return idproyecto;
	}
	public void setIdproyecto(Integer idproyecto) {
		this.idproyecto = idproyecto;
	}
	public Integer getIdfase() {
		return idfase;
	}
	public void setIdfase(Integer idfase) {
		this.idfase = idfase;
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



    public EntradasDTO() {
    }

   

    public EntradasDTO(Integer identradapdp, String otrosprocesos, String factoresambientales, String activosprocesos,
			Integer idpdp, Boolean estado) {
		super();
		this.identradapdp = identradapdp;
		this.otrosprocesos = otrosprocesos;
		this.factoresambientales = factoresambientales;
		this.activosprocesos = activosprocesos;
		this.idpdp = idpdp;
		this.estado = estado;
	}

	public Integer getIdpdp() {
        return idpdp;
    }

    public void setIdpdp(Integer idpdp) {
        this.idpdp = idpdp;
    }

    public Integer getIdentradapdp() {
        return identradapdp;
    }

    public void setIdentradapdp(Integer identradapdp) {
        this.identradapdp = identradapdp;
    }

    public String getOtrosprocesos() {
        return otrosprocesos;
    }

    public void setOtrosprocesos(String otrosprocesos) {
        this.otrosprocesos = otrosprocesos;
    }

    public String getFactoresambientales() {
        return factoresambientales;
    }

    public void setFactoresambientales(String factoresambientales) {
        this.factoresambientales = factoresambientales;
    }

    public String getActivosprocesos() {
        return activosprocesos;
    }

    public void setActivosprocesos(String activosprocesos) {
        this.activosprocesos = activosprocesos;
    }

}
