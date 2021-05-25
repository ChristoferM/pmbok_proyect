package com.tesis.v1.dto;

public class ReunionesDTO {

    private Integer idreuniones;
    private String nombrereunion;
    private String descripcionreunion;
    private Integer idproyecto;
    private Integer idfase;
    // idproyecto int4 NOT NULL,
    // idfase int4 NOT NULL,

    public Integer getIdreuniones() {
        return idreuniones;
    }

    public Integer getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(Integer idproyecto) {
        this.idproyecto = idproyecto;
    }

    public Integer getIdfase() {
        return idfase;
    }

    public void setIdfase(Integer idfase) {
        this.idfase = idfase;
    }

    public void setIdreuniones(Integer idreuniones) {
        this.idreuniones = idreuniones;
    }

    public String getNombrereunion() {
        return nombrereunion;
    }

    public void setNombrereunion(String nombrereunion) {
        this.nombrereunion = nombrereunion;
    }

    public String getDescripcionreunion() {
        return descripcionreunion;
    }

    public void setDescripcionreunion(String descripcionreunion) {
        this.descripcionreunion = descripcionreunion;
    }

}
