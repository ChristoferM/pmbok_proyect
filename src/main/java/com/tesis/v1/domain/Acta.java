package com.tesis.v1.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "actas", schema = "public")
public class Acta {

    private Integer idactas;

    private Reunion reuniones;// PADRE

    private List<Herramientasacta> herramientasacta = new ArrayList<Herramientasacta>(0);

    private List<Entradacta> entradacta = new ArrayList<Entradacta>(0);

    @Id
    @Column(name = "idactas", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdactas() {
        return idactas;
    }

    public void setIdactas(Integer idactas) {
        this.idactas = idactas;
    }

    // ----------------------------------------------------- ENTIDAD PADRE -> REUNION
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idreuniones")
    public Reunion getReuniones() {
        return reuniones;
    }

    public void setReuniones(Reunion reuniones) {
        this.reuniones = reuniones;
    }

    // ----------------------------------------------------- ENTIDADES HIJAS
    //@OneToOne(mappedBy = "Acta", cascade = CascadeType.ALL)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "actas")
    public List<Entradacta> getEntradacta() {
        return entradacta;
    }

    public void setEntradacta(List<Entradacta> entradacta) {
        this.entradacta = entradacta;
    }

    //@OneToOne(mappedBy = "Acta", cascade = CascadeType.ALL)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "actas")
    public List<Herramientasacta> getHerramientasacta() {
        return herramientasacta;
    }

    public void setHerramientasacta(List<Herramientasacta> herramientasacta) {
        this.herramientasacta = herramientasacta;
    }

}
