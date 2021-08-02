package com.tesis.v1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notificaciones", schema = "public")
public class notificaciones {
	
	  private Integer idnotificaciones ;
	  private String emisor ;
	  private String receptor;
	  private String mensaje;
	  private Boolean estado;
	  
	  
	public notificaciones() {
		super();
	}


	public notificaciones(Integer idnotificaciones, String emisor, String receptor, String mensaje, Boolean estado) {
		super();
		this.idnotificaciones = idnotificaciones;
		this.emisor = emisor;
		this.receptor = receptor;
		this.mensaje = mensaje;
		this.estado = estado;
	}

	@Id
    @Column(name = "idnotificaciones", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdnotificaciones() {
		return idnotificaciones;
	}


	
	public void setIdnotificaciones(Integer idnotificaciones) {
		this.idnotificaciones = idnotificaciones;
	}

	@Column(name = "emisor")
	public String getEmisor() {
		return emisor;
	}


	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	@Column(name = "receptor")
	public String getReceptor() {
		return receptor;
	}


	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}

	@Column(name = "mensaje")
	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Column(name = "estado")
	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	  
	  
	  

}
