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
@Table(name = "casonegocio", schema = "public")
public class CasoNegocio {

    private Integer id_caso_negocio;
    private String metas;
    private String objetivos;
    private String incidentes;
    private String oportunidades;
    // identrada int4 NOT NULL,

    // Entidad padre
    private Entradacta entradacta;

    @Id
    @Column(name = "id_caso_negocio", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId_caso_negocio() {
        return id_caso_negocio;
    }

    public void setId_caso_negocio(Integer id_caso_negocio) {
        this.id_caso_negocio = id_caso_negocio;
    }

    @Column(name = "metas", nullable = false)
    public String getMetas() {
        return metas;
    }

    public void setMetas(String metas) {
        this.metas = metas;
    }

    @Column(name = "objetivos", nullable = false)
    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    @Column(name = "incidentes", nullable = false)
    public String getIncidentes() {
        return incidentes;
    }

    public void setIncidentes(String incidentes) {
        this.incidentes = incidentes;
    }

    @Column(name = "oportunidades", nullable = false)
    public String getOportunidades() {
        return oportunidades;
    }

    public void setOportunidades(String oportunidades) {
        this.oportunidades = oportunidades;
    }
    // ----------------------------------------------------- Entidad padre

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identrada")
    public Entradacta getEntradacta() {
        return entradacta;
    }

    public void setEntradacta(Entradacta entradacta) {
        this.entradacta = entradacta;
    }

}
