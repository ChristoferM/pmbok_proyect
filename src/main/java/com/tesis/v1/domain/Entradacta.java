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
@Table(name = "entradacta", schema = "public")
public class Entradacta {

    private Integer identrada;
    private Acta actas; // PADRE
    private String acuerdos;
    private String factores;
    private String activosprocesos;

    // Entidades hijas
    private List<CasoNegocio> casonegocio = new ArrayList<CasoNegocio>(0);

    private List<PlanGestionbeneficio> planesgestionbeneficios = new ArrayList<PlanGestionbeneficio>(0);

    // idactas int4 NOT NULL,

    @Id
    @Column(name = "identrada", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdentrada() {
        return identrada;
    }

    public void setIdentrada(Integer identrada) {
        this.identrada = identrada;
    }

    @Column(name = "acuerdos", nullable = false)
    public String getAcuerdos() {
        return acuerdos;
    }

    public void setAcuerdos(String acuerdos) {
        this.acuerdos = acuerdos;
    }

    @Column(name = "factores", nullable = false)
    public String getFactores() {
        return factores;
    }

    public void setFactores(String factores) {
        this.factores = factores;
    }

    @Column(name = "activosprocesos", nullable = false)
    public String getActivosprocesos() {
        return activosprocesos;
    }

    public void setActivosprocesos(String activosprocesos) {
        this.activosprocesos = activosprocesos;
    }

    // ------------------------- ENTIDAD PADRE
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idactas")
    public Acta getActas() {
        return actas;
    }

    public void setActas(Acta actas) {
        this.actas = actas;
    }

    // ------------------------- Entidades hijas
    //@OneToOne(mappedBy = "Entradacta", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "entradacta")
    public List<CasoNegocio> getCasonegocio() {
        return casonegocio;
    }

    public void setCasonegocio(List<CasoNegocio> casonegocio) {
        this.casonegocio = casonegocio;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "entradacta")
    public List<PlanGestionbeneficio> getPlanesgestionbeneficios() {
        return planesgestionbeneficios;
    }

    public void setPlanesgestionbeneficios(List<PlanGestionbeneficio> planesgestionbeneficios) {
        this.planesgestionbeneficios = planesgestionbeneficios;
    }

}
