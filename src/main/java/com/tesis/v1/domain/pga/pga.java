package com.tesis.v1.domain.pga;

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
import com.tesis.v1.domain.pga.entradapga;
import com.tesis.v1.domain.pga.herramientaspga;

@Entity
@Table(name = "pga", schema = "public")
public class pga {
	
	
	private Integer idpga;
	private Reunion reuniones;
	
	private List<herramientaspga> herramientaspga = new ArrayList<herramientaspga>(0);
	private List<entradapga> entradapga = new ArrayList<entradapga>(0);
	
	
	
	@Id
	@Column(name = "idpga", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdpga() {
		return idpga;
	}
	public void setIdpga(Integer idpga) {
		this.idpga = idpga;
	}
	
	
	 // Entidades Padre -> reuniones
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "idreuniones")
	public Reunion getReuniones() {
		return reuniones;
	}
	public void setReuniones(Reunion reuniones) {
		this.reuniones = reuniones;
	}
	
	
	// ------------entidades Hijas 
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pga")
	public List<entradapga> getEntradapga() {
		return entradapga;
	}
	public void setEntradapga(List<entradapga> entradapga) {
		this.entradapga = entradapga;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pga")		
	public List<herramientaspga> getHerramientaspga() {
		return herramientaspga;
	}
	public void setHerramientaspga(List<herramientaspga> herramientaspga) {
		this.herramientaspga = herramientaspga;
	}
	
	
	
	
	
	
	
	
}
