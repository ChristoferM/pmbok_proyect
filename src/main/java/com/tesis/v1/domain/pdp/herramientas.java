package com.tesis.v1.domain.pdp;

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
@Table(name = "herramientaspdp", schema = "public")
public class herramientas {
	
	private Integer idherramienta;
	private String juicioexpertos;
	private String recopilaciondatos;
	private String habilidades;
	private String herramientareuniones;
	
	private pdp pdp;
	
	
	@Id
	@Column(name = "idherramienta", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	public Integer getIdherramienta() {
		return idherramienta;
	}

	public void setIdherramienta(Integer idherramienta) {
		this.idherramienta = idherramienta;
	}
	
	public String getJuicioexpertos() {
		return juicioexpertos;
	}
	
	@Column(name = "juicioexpertos", nullable = false)
	public void setJuicioexpertos(String juicioexpertos) {
		this.juicioexpertos = juicioexpertos;
	}
	
	@Column(name = "recopilaciondatos", nullable = false)
	public String getRecopilaciondatos() {
		return recopilaciondatos;
	}

	public void setRecopilaciondatos(String recopilaciondatos) {
		this.recopilaciondatos = recopilaciondatos;
	}

	@Column(name = "habilidades", nullable = false)
	public String getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(String habilidades) {
		this.habilidades = habilidades;
	}
	
	@Column(name = "herramientareuniones", nullable = false)
	public String getHerramientareuniones() {
		return herramientareuniones;
	}

	public void setHerramientareuniones(String herramientareuniones) {
		this.herramientareuniones = herramientareuniones;
	}
	// ------------------------- ENTIDAD PADRE

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "idpdp")
	public pdp getPdp() {
		return pdp;
	}

	public void setPdp(pdp pdp) {
		this.pdp = pdp;
	}
	
	
	
	
}
