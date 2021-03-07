package com.tesis.v1.dto;

public class grupoCreateDTO {
	
	private Integer idgrupo ;
	// -- idusuario int4 NOT NULL,
	private Integer id_sub_grupo ;
	private Integer idproyecto;
	private String email ;
	
	
	
	public Integer getIdgrupo() {
		return idgrupo;
	}
	public void setIdgrupo(Integer idgrupo) {
		this.idgrupo = idgrupo;
	}
	public Integer getId_sub_grupo() {
		return id_sub_grupo;
	}
	public void setId_sub_grupo(Integer id_sub_grupo) {
		this.id_sub_grupo = id_sub_grupo;
	}
	public Integer getIdproyecto() {
		return idproyecto;
	}
	public void setIdproyecto(Integer idproyecto) {
		this.idproyecto = idproyecto;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
  	
	
	
	
}
