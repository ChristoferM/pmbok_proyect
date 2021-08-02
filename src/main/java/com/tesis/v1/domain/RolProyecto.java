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
@Table(name = "rolproyecto", schema = "public")
public class RolProyecto {

    private Integer id_rol_proyecto;
    // idrol int4 NOT NULL,
    // idgrupo int4 NOT NULL,
    private Grupo grupo;

    private Roles roles;

    @Id
    @Column(name = "id_rol_proyecto", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId_rol_proyecto() {
        return id_rol_proyecto;
    }

    public void setId_rol_proyecto(Integer id_rol_proyecto) {
        this.id_rol_proyecto = id_rol_proyecto;
    }

    // ----
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idgrupo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    //-- 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idrol")
    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

}
