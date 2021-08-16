package com.tesis.v1.dto;

public class GrupoDTO {

    private Integer idgrupo;
    // -- idusuario int4 NOT NULL,
    private Integer id_sub_grupo;
    private Integer idproyecto;
    private String email;
    
    private Integer idrol ;
    private String idNombrerol;
    /*
     * 15 de agosto: Se agrega la variable estado con sus respectivos Getter y setter*/
    private Boolean estado;

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

	public Integer getIdrol() {
		return idrol;
	}

	public void setIdrol(Integer idrol) {
		this.idrol = idrol;
	}

	public String getIdNombrerol() {
		return idNombrerol;
	}

	public void setIdNombrerol(String idNombrerol) {
		this.idNombrerol = idNombrerol;
	}
	
	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

}
