package com.tesis.builder;

public class UsuarioColaboradorTestBuild {

	// private Integer idusuario;
	// ID ES EMAIL
	private String email;

	private String nombre;

	private String password;

	private String token;

	private String activo;

	public UsuarioColaboradorTestBuild() {
		super();
		// this.idusuario = idusuario;
		this.email = "usuario1@pmbok.com";
		this.nombre = "usuario 1";
		this.password = "123456789";
		this.token = "token test TMP";
		this.activo = "Y";

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

}
