package com.tesis.v1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subgrupo", schema = "public")
public class SubGrupo {

    private Integer id_sub_grupo;

    private Grupo grupo;
    // idgrupo int4 NOT NULL  ,

    private FaseProyecto faseproyecto;
    // idfase int4 NOT NULL,
    
    /*
     * 15 de agosto: Se agrega la variable estado con sus respectivos Getter y setter*/
    private Boolean estado;

    @Id
    @Column(name = "id_sub_grupo", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId_sub_grupo() {
        return id_sub_grupo;
    }

    public void setId_sub_grupo(Integer id_sub_grupo) {
        this.id_sub_grupo = id_sub_grupo;
    }

    //----------------------------- grupos
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idgrupo")
    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    /// ------------------------------- fases del proyecto

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idfase")
    public FaseProyecto getFaseproyecto() {
        return faseproyecto;
    }

    public void setFaseproyecto(FaseProyecto faseproyecto) {
        this.faseproyecto = faseproyecto;
    }
    
	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

}
