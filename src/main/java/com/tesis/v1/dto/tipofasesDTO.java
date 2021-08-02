package com.tesis.v1.dto;

public class tipofasesDTO {

	Integer idtipofase;
	String nombrefase;
	
	
	
	public tipofasesDTO() {
		super();
	}



	public tipofasesDTO(Integer idtipofase, String nombrefase) {
		super();
		this.idtipofase = idtipofase;
		this.nombrefase = nombrefase;
	}



	public Integer getIdtipofase() {
		return idtipofase;
	}



	public void setIdtipofase(Integer idtipofase) {
		this.idtipofase = idtipofase;
	}



	public String getNombrefase() {
		return nombrefase;
	}



	public void setNombrefase(String nombrefase) {
		this.nombrefase = nombrefase;
	}
	
	
}
