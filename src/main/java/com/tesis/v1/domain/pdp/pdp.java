package com.tesis.v1.domain.pdp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tesis.v1.domain.reuniones;
import com.tesis.v1.domain.pdp.*;

@Entity
@Table(name = "pdp", schema = "public")
public class pdp {
	
	private Integer idpdp;
	private reuniones reuniones;
	
	private List<herramientas> herramientaPdp = new ArrayList<herramientas>(0);
	private List<entradas> entradas = new ArrayList<entradas>(0);
	
	
	public pdp(Integer idpdp, com.tesis.v1.domain.reuniones reuniones) {
		this.idpdp = idpdp;
		this.reuniones = reuniones;
	}

	@Id
	@Column(name = "idpdp", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdpdp() {
		return idpdp;
	}

	public void setIdpdp(Integer idpdp) {
		this.idpdp = idpdp;
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
	
	//----------------- hijos
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "herramientaspdp")
	public List<herramientas> getHerramientaPdp() {
		return herramientaPdp;
	}

	public void setHerramientaPdp(List<herramientas> herramientaPdp) {
		this.herramientaPdp = herramientaPdp;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "entradapdp")	
	public List<entradas> getEntradas() {
		return entradas;
	}

	public void setEntradas(List<entradas> entradas) {
		this.entradas = entradas;
	}
	

}
