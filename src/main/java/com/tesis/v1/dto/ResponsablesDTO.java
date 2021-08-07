package com.tesis.v1.dto;

public class ResponsablesDTO {

	private Integer idfase;
	private Integer id_sub_grupo;
	private Integer idgrupo;
	private String email;
	private String nombrerol;
	public ResponsablesDTO() {
		super();

	}
	public ResponsablesDTO(Integer idfase, Integer id_sub_grupo, Integer idgrupo, String email, String nombrerol) {
		super();
		this.idfase = idfase;
		this.id_sub_grupo = id_sub_grupo;
		this.idgrupo = idgrupo;
		this.email = email;
		this.nombrerol = nombrerol;
	}
	public Integer getIdfase() {
		return idfase;
	}
	public void setIdfase(Integer idfase) {
		this.idfase = idfase;
	}
	public Integer getId_sub_grupo() {
		return id_sub_grupo;
	}
	public void setId_sub_grupo(Integer id_sub_grupo) {
		this.id_sub_grupo = id_sub_grupo;
	}
	public Integer getIdgrupo() {
		return idgrupo;
	}
	public void setIdgrupo(Integer idgrupo) {
		this.idgrupo = idgrupo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombrerol() {
		return nombrerol;
	}
	public void setNombrerol(String nombrerol) {
		this.nombrerol = nombrerol;
	}
	
	

}