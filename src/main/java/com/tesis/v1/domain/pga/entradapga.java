package com.tesis.v1.domain.pga;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.tesis.v1.domain.pga.pga;

@Entity
@Table(name = "entradapga", schema = "public")
public class entradapga {

	private Integer identradapga;
	private String estandares;
	private String objetivocalidad;
	private String ciclo;
	private String enfoque;
	private String activosprocesos;

	private pga pga;

	@Id
	@Column(name = "identradapga", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdentradapga() {
		return identradapga;
	}

	public void setIdentradapga(Integer identradapga) {
		this.identradapga = identradapga;
	}

	@Column(name = "estandares", nullable = false)
	public String getEstandares() {
		return estandares;
	}

	public void setEstandares(String estandares) {
		this.estandares = estandares;
	}

	@Column(name = "objetivocalidad", nullable = false)
	public String getObjetivocalidad() {
		return objetivocalidad;
	}

	public void setObjetivocalidad(String objetivocalidad) {
		this.objetivocalidad = objetivocalidad;
	}
	
	@Column(name = "ciclo", nullable = false)
	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	@Column(name = "enfoque", nullable = false)
	public String getEnfoque() {
		return enfoque;
	}

	public void setEnfoque(String enfoque) {
		this.enfoque = enfoque;
	}

	@Column(name = "activosprocesos", nullable = false)
	public String getActivosprocesos() {
		return activosprocesos;
	}

	public void setActivosprocesos(String activosprocesos) {
		this.activosprocesos = activosprocesos;
	}
	
	// ----------------------------------

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "idpga")
	public pga getPga() {
		return pga;
	}

	public void setPga(pga pga) {
		this.pga = pga;
	}

}
