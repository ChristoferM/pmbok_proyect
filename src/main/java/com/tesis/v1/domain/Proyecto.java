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
@Table(name = "proyectos", schema = "public")
public class Proyecto {
	private Integer idproyecto ;
	private String nombre ;
	private String descripcion ;
	private String  admin;
	
	private List<Grupo> grupo = new ArrayList<Grupo>(0);

	private List<Reunion> reuniones = new ArrayList<Reunion>(0);
	
	private Tipo_proyecto tipoProyecto;
	
	
	
	
	public Proyecto() {
		super();
	}
	
	@Id
	@Column(name = "idproyecto", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdproyecto() {
		return idproyecto;
	}
	public void setIdproyecto(Integer idproyecto) {
		this.idproyecto = idproyecto;
	}
	
	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "descripcion", nullable = false)
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "admin", nullable = false)
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	
	
	// ---------------------  GRUPOS HIJOS
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proyectos")
	public List<Grupo> getGrupo() {
		return grupo;
	}
	
	public void setGrupo(List<Grupo> grupo) {
		this.grupo = grupo;
	}
	
	
	//---------------------------
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proyectos")
	public List<Reunion> getReuniones() {
		return reuniones;
	}
	public void setReuniones(List<Reunion> reuniones) {
		this.reuniones = reuniones;
	}
	
	
        @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "tipo_id", referencedColumnName = "tipo_id")
        @JoinColumn(name = "tipo_id")

	public Tipo_proyecto getTipoProyecto() {
		return tipoProyecto;
	}
	public void setTipoProyecto(Tipo_proyecto tipoProyecto) {
		this.tipoProyecto = tipoProyecto;
	}
	
	
	
	
	
	

}
