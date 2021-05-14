package com.tesis.v1.dto.pdp;


public class PdpDTO{
	
	private Integer idpdp;
	private  Integer idreuniones;
	
	public PdpDTO() {}
	
	public PdpDTO(Integer idpdp, Integer idreuniones) {
		this.idpdp = idpdp;
		this.idreuniones = idreuniones;
	}

	public Integer getIdpdp() {
		return idpdp;
	}
	public void setIdpdp(Integer idpdp) {
		this.idpdp = idpdp;
	}
	public Integer getIdreuniones() {
		return idreuniones;
	}
	public void setIdreuniones(Integer idreuniones) {
		this.idreuniones = idreuniones;
	}
	

	

}
