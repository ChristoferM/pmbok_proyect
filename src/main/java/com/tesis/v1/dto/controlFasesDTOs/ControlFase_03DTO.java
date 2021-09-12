package com.tesis.v1.dto.controlFasesDTOs;

import java.util.Date;

public class ControlFase_03DTO {

    private Integer idfase;
    private String nombrefase;
    private String descripcionfase;
	private  Date  tiempoinicio;
	private  Date  tiempofin;
	public Integer getIdfase() {
		return idfase;
	}
	public void setIdfase(Integer idfase) {
		this.idfase = idfase;
	}
	public String getNombrefase() {
		return nombrefase;
	}
	public void setNombrefase(String nombrefase) {
		this.nombrefase = nombrefase;
	}
	public String getDescripcionfase() {
		return descripcionfase;
	}
	public void setDescripcionfase(String descripcionfase) {
		this.descripcionfase = descripcionfase;
	}
	public Date getTiempoinicio() {
		return tiempoinicio;
	}
	public void setTiempoinicio(Date tiempoinicio) {
		this.tiempoinicio = tiempoinicio;
	}
	public Date getTiempofin() {
		return tiempofin;
	}
	public void setTiempofin(Date tiempofin) {
		this.tiempofin = tiempofin;
	}
	
	
}
