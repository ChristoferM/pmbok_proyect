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

@Entity
@Table(name = "herramientaspga", schema = "public")
public class herramientaspga {

	private Integer idherramientapga;
	private String juicioexpertos ;
	private String analisis ;
	
	
	private pga pga;
	
	
	@Id
	@Column(name = "idherramientapga", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	public Integer getIdherramientapga() {
		return idherramientapga;
	}
	public void setIdherramientapga(Integer idherramientapga) {
		this.idherramientapga = idherramientapga;
	}
	
	@Column(name = "juicioexpertos", nullable = false)
	public String getJuicioexpertos() {
		return juicioexpertos;
	}
	public void setJuicioexpertos(String juicioexpertos) {
		this.juicioexpertos = juicioexpertos;
	}
	@Column(name = "analisis", nullable = false)
	public String getAnalisis() {
		return analisis;
	}
	public void setAnalisis(String analisis) {
		this.analisis = analisis;
	}
	
	private String participa ;
	@Column(name = "participa", nullable = false)
	public String getParticipa() {
		return participa;
	}
	public void setParticipa(String participa) {
		this.participa = participa;
	}
	private Boolean estado;
    @Column(name = "estado", nullable = false)
    public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
    
	// --------------- entidad padre PGA
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "idpga")
	public pga getPga() {
		return pga;
	}
	public void setPga(pga pga) {
		this.pga = pga;
	}
	
	
}
