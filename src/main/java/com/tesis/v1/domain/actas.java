package com.tesis.v1.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.websocket.OnOpen;

@Entity
@Table(name = "actas", schema = "public")
public class actas {

	private Integer idactas;

	private reuniones reuniones;// PADRE

	
	private List<herramientasacta>  herramientasacta= new ArrayList<herramientasacta	>(0);

	private List<entradacta>  entradacta= new ArrayList<entradacta>(0);
	
	
	
	@Id
	@Column(name = "idactas", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdactas() {
		return idactas;
	}

	public void setIdactas(Integer idactas) {
		this.idactas = idactas;
	}

	// ----------------------------------------------------- ENTIDAD PADRE -> REUNION

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "idreuniones")
	public reuniones getReuniones() {
		return reuniones;
	}

	public void setReuniones(reuniones reuniones) {
		this.reuniones = reuniones;
	}

	// ----------------------------------------------------- ENTIDADES HIJAS

	//@OneToOne(mappedBy = "actas", cascade = CascadeType.ALL)
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "actas")
	public  List<entradacta> getEntradacta() {
		return entradacta;
	}
	
	public void setEntradacta( List<entradacta> entradacta) {
		this.entradacta = entradacta;
	}


	//@OneToOne(mappedBy = "actas", cascade = CascadeType.ALL)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "actas")
	public List<herramientasacta> getHerramientasacta() {
		return herramientasacta;
	}

	public void setHerramientasacta(List<herramientasacta> herramientasacta) {
		this.herramientasacta = herramientasacta;
	}

	
}
