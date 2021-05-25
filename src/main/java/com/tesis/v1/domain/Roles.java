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

@Entity
@Table(name = "roles", schema = "public")
public class Roles {

    private Integer idrol;
    private String nombrerol;

    private List<RolProyecto> rolProyectos = new ArrayList<RolProyecto>(0);

    @Id
    @Column(name = "idrol", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdrol() {
        return idrol;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }

    @Column(name = "nombrerol", nullable = false)
    public String getNombrerol() {
        return nombrerol;
    }

    public void setNombrerol(String nombrerol) {
        this.nombrerol = nombrerol;
    }

    //---
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    public List<RolProyecto> getRolProyectos() {
        return rolProyectos;
    }

    public void setRolProyectos(List<RolProyecto> rolProyectos) {
        this.rolProyectos = rolProyectos;
    }

}
