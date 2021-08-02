package com.tesis.v1.dto;


import java.util.List;
import com.tesis.v1.dto.idresponsable;


public class CrearfaseConResponsablesDTO {


	private  Integer idproyecto;
	private  Integer idtipofase;
	private  String descripcionfase;
	private  List<idresponsable> idresponsable;
	private  String  tiempoinicio;
	private  String  tiempofin;
	private  String nombrereunion;
	private  String descripcionreunion;
	
	
	
	public CrearfaseConResponsablesDTO() {
		super();
	}

	public CrearfaseConResponsablesDTO(Integer idproyecto, Integer idtipofase, String descripcionfase,
			List<com.tesis.v1.dto.idresponsable> idresponsable, String tiempoinicio, String tiempofin,
			String nombrereunion, String descripcionreunion) {
		super();
		this.idproyecto = idproyecto;
		this.idtipofase = idtipofase;
		this.descripcionfase = descripcionfase;
		this.idresponsable = idresponsable;
		this.tiempoinicio = tiempoinicio;
		this.tiempofin = tiempofin;
		this.nombrereunion = nombrereunion;
		this.descripcionreunion = descripcionreunion;
	}

	public Integer getIdproyecto() {
		return idproyecto;
	}

	public void setIdproyecto(Integer idproyecto) {
		this.idproyecto = idproyecto;
	}

	public Integer getIdtipofase() {
		return idtipofase;
	}

	public void setIdtipofase(Integer idtipofase) {
		this.idtipofase = idtipofase;
	}

	public String getDescripcionfase() {
		return descripcionfase;
	}

	public void setDescripcionfase(String descripcionfase) {
		this.descripcionfase = descripcionfase;
	}

	public List<idresponsable> getIdresponsable() {
		return idresponsable;
	}

	public void setIdresponsable(List<idresponsable> idresponsable) {
		this.idresponsable = idresponsable;
	}

	public String getTiempoinicio() {
		return tiempoinicio;
	}

	public void setTiempoinicio(String tiempoinicio) {
		this.tiempoinicio = tiempoinicio;
	}

	public String getTiempofin() {
		return tiempofin;
	}

	public void setTiempofin(String tiempofin) {
		this.tiempofin = tiempofin;
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
	
	
	


}