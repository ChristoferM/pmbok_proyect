package com.tesis.v1.dto.controlFasesDTOs;

import java.util.List;

import com.tesis.v1.dto.controlFasesDTOs.*;

public class ControlFase_02DTO {

    private Integer idreuniones;
    private String nombrereunion;
    private String descripcionreunion;
    private Integer idproyecto;
    private Integer idfase;
    
    private  List<ControlFase_03DTO> fases;

	public Integer getIdreuniones() {
		return idreuniones;
	}

	public void setIdreuniones(Integer idreuniones) {
		this.idreuniones = idreuniones;
	}

	public String getNombrereunion() {
		return nombrereunion;
	}

	public void setNombrereunion(String nombrereunion) {
		this.nombrereunion = nombrereunion;
	}

	public String getDescripcionreunion() {
		return descripcionreunion;
	}

	public void setDescripcionreunion(String descripcionreunion) {
		this.descripcionreunion = descripcionreunion;
	}

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

	public List<ControlFase_03DTO> getFases() {
		return fases;
	}

	public void setFases(List<ControlFase_03DTO> fases) {
		this.fases = fases;
	}
    
    
    
}
