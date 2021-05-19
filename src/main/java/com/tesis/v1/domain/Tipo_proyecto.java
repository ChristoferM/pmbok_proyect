package com.tesis.v1.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_proyecto", schema = "public")
public class Tipo_proyecto implements Serializable {

    private String tipo_id;
    private String clasificacion;
    private List<Proyecto> proyectos = new ArrayList<>(0);

    @Id
    @Column(name = "tipo_id", unique = true ,nullable = false)
    public String getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(String tipo_id) {
        this.tipo_id = tipo_id;
    }

    @Column(name = "clasificacion",nullable = false)
    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    // targetEntity = Proyecto.class
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoProyecto")
    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

}
