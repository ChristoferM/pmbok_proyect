package com.tesis.v1.domain.pdp;

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
@Table(name = "entradapdp", schema = "public")
public class Entradas {

    private Integer identradapdp;
    private String otrosprocesos;
    private String factoresambientales;
    private String activosprocesos;

    private Pdp pdp;

    @Id
    @Column(name = "identradapdp", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdentradapdp() {
        return identradapdp;
    }

    public void setIdentradapdp(Integer identradapdp) {
        this.identradapdp = identradapdp;
    }

    @Column(name = "otrosprocesos", nullable = false)
    public String getOtrosprocesos() {
        return otrosprocesos;
    }

    public void setOtrosprocesos(String otrosprocesos) {
        this.otrosprocesos = otrosprocesos;
    }

    @Column(name = "factoresambientales", nullable = false)
    public String getFactoresambientales() {
        return factoresambientales;
    }

    public void setFactoresambientales(String factoresambientales) {
        this.factoresambientales = factoresambientales;
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
    @JoinColumn(name = "idpdp")
    public Pdp getPdp() {
        return pdp;
    }

    public void setPdp(Pdp pdp) {
        this.pdp = pdp;
    }

}
