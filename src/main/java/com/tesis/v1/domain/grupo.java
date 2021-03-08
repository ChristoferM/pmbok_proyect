package com.tesis.v1.domain;

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

@Entity
@Table(name = "grupo", schema = "public")
public class grupo {
	
	private Integer idgrupo ;
	// -- idusuario int4 NOT NULL,
	
	
	//private String email ;
	
	private usuarios usuarios;
	
	private  List<subgrupo> subGrupos = new ArrayList<subgrupo>(0);   
	
	private  List<rolproyecto> rolProyectos = new ArrayList<rolproyecto>(0);
	
	private proyectos proyectos;
	
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "email")
	public usuarios getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(usuarios usuarios) {
		this.usuarios = usuarios;
	}
	
	
	@Id
	@Column(name = "idgrupo", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdgrupo() {
		return idgrupo;
	}
	
	public void setIdgrupo(Integer idgrupo) {
		this.idgrupo = idgrupo;
	}
	//--------------------- ENTIDADES CON LAS QUE SE CONECTA

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "grupo")
	public List<subgrupo> getSubGrupos() {
		return subGrupos;
	}
	public void setSubGrupos(List<subgrupo> subGrupos) {
		this.subGrupos = subGrupos;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "grupo")
	public List<rolproyecto> getRolProyectos() {
		return rolProyectos;
	}
	public void setRolProyectos(List<rolproyecto> rolProyectos) {
		this.rolProyectos = rolProyectos;
	}
		
	//-------- recibe llave foranea de PROYECTOS
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idproyecto")
	public proyectos getProyectos() {
		return proyectos;
	}
	public void setProyectos(proyectos proyectos) {
		this.proyectos = proyectos;
	}
	

	
	
}
