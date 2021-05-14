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

import com.tesis.v1.domain.Reunion;
 

@Entity
@Table(name = "pdp", schema = "public")
public class Pdp {
	
	private Integer idpdp;
	private Reunion reuniones;
	
	private List<Herramientas> herramientaPdp = new ArrayList<Herramientas>(0);
	private List<Entradas> entradas = new ArrayList<Entradas>(0);
	

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
	public Reunion getReuniones() {
		return reuniones;
	}

	public void setReuniones(Reunion reuniones) {
		this.reuniones = reuniones;
	}
	
	//----------------- hijos
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pdp")
	public List<Herramientas> getHerramientaPdp() {
		return herramientaPdp;
	}

	public void setHerramientaPdp(List<Herramientas> herramientaPdp) {
		this.herramientaPdp = herramientaPdp;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pdp")	
	public List<Entradas> getEntradas() {
		return entradas;
	}

	public void setEntradas(List<Entradas> entradas) {
		this.entradas = entradas;
	}
	

}
