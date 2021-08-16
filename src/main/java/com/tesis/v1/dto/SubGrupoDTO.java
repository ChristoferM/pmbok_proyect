package com.tesis.v1.dto;

public class SubGrupoDTO {

    private Integer id_sub_grupo;

    // idfase int4 NOT NULL,
    // idgrupo int4 NOT NULL  ,
    
    /*
     * 15 de agosto: Se agrega la variable estado con sus respectivos Getter y setter*/
    private Boolean estado;
    
    
    public Integer getId_sub_grupo() {
        return id_sub_grupo;
    }

    public void setId_sub_grupo(Integer id_sub_grupo) {
        this.id_sub_grupo = id_sub_grupo;
    }
	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

}
