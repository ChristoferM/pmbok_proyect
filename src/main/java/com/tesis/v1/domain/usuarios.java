package com.tesis.v1.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuarios", schema = "public")
public class usuarios {
	
	//private Integer  idusuario;
	// ID ES EMAIL
 
	private String email;
 
	private String nombre;
 
	private String password;
	 
	private String token;
 
	private String activo;
	
	// lista de grupos donde puede estar el usuario
	private List<grupo> grupos = new ArrayList<grupo>(0);
	
	public usuarios() {
		super();
	}
	
	public usuarios(//Integer idusuario, 
			String email, 
			String nombre, 
			String password,
			String token, 
			String activo,
			List<grupo> grupos) {
		super();
		//this.idusuario = idusuario;
		this.email = email;
		this.nombre = nombre;
		this.password = password;
		this.token = token;
		this.activo = activo;
		this.grupos = grupos;
	}
	//----------------
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarios")
	public List<grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<grupo> grupos) {
		this.grupos = grupos;
	}
	
	//----------------
	
	/*@Column(name = "idusuario", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}*/
	
	@Id
	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Column(name = "token", nullable = false)
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	@Column(name = "activo", nullable = false)
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}
	
	
	
}
