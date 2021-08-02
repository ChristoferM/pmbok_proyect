package com.tesis.v1.dto;

public class NotificacionesDTO {
	  private Integer idnotificaciones ;
	  private String emisor ;
	  private String receptor;
	  private String mensaje;
	  private Boolean estado;
	  
	  
	  
	public NotificacionesDTO(Integer idnotificaciones, String emisor, String receptor, String mensaje, Boolean estado) {
		super();
		this.idnotificaciones = idnotificaciones;
		this.emisor = emisor;
		this.receptor = receptor;
		this.mensaje = mensaje;
		this.estado = estado;
	}



	public Integer getIdnotificaciones() {
		return idnotificaciones;
	}



	public void setIdnotificaciones(Integer idnotificaciones) {
		this.idnotificaciones = idnotificaciones;
	}



	public String getEmisor() {
		return emisor;
	}



	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}



	public String getReceptor() {
		return receptor;
	}



	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}



	public String getMensaje() {
		return mensaje;
	}



	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}



	public Boolean getEstado() {
		return estado;
	}



	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	  
	
}
