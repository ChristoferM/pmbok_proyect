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
public class Grupo {
	
	private Integer idgrupo ;
	// -- idusuario int4 NOT NULL,
	
	
	//private String email ;
	
	private Usuario usuarios;
	
	private  List<SubGrupo> subGrupos = new ArrayList<SubGrupo>(0);   
	
	private  List<RolProyecto> rolProyectos = new ArrayList<RolProyecto>(0);
	
	private Proyecto proyectos;
	
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "email")
	public Usuario getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Usuario usuarios) {
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
	public List<SubGrupo> getSubGrupos() {
		return subGrupos;
	}
	public void setSubGrupos(List<SubGrupo> subGrupos) {
		this.subGrupos = subGrupos;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "grupo")
	public List<RolProyecto> getRolProyectos() {
		return rolProyectos;
	}
	public void setRolProyectos(List<RolProyecto> rolProyectos) {
		this.rolProyectos = rolProyectos;
	}
		
	//-------- recibe llave foranea de PROYECTOS
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idproyecto")
	public Proyecto getProyectos() {
		return proyectos;
	}
	public void setProyectos(Proyecto proyectos) {
		this.proyectos = proyectos;
	}
	

	
	
}
