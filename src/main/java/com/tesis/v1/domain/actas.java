package com.tesis.v1.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.websocket.OnOpen;

@Entity
@Table(name = "actas", schema = "public")
public class actas {

	private Integer idactas;

	private reuniones reuniones;// PADRE

	private herramientasacta herramientasacta;

	private entradacta entradacta;

	@Id
	@Column(name = "idactas", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdactas() {
		return idactas;
	}

	public void setIdactas(Integer idactas) {
		this.idactas = idactas;
	}

	// -- ENTIDAD PADRE -> REUNION

	@OneToOne
	@JoinColumn(name = "idreuniones", updatable = false, nullable = false)
	public reuniones getReuniones() {
		return reuniones;
	}

	public void setReuniones(reuniones reuniones) {
		this.reuniones = reuniones;
	}

	// ----------------------------------------------------- ENTIDADES HIJAS

	@OneToOne(mappedBy = "actas", cascade = CascadeType.ALL)
	public entradacta getEntradacta() {
		return entradacta;
	}
	
	public void setEntradacta(entradacta entradacta) {
		this.entradacta = entradacta;
	}


	@OneToOne(mappedBy = "actas", cascade = CascadeType.ALL)
	public herramientasacta getHerramientasacta() {
		return herramientasacta;
	}

	public void setHerramientasacta(herramientasacta herramientasacta) {
		this.herramientasacta = herramientasacta;
	}

	
}
