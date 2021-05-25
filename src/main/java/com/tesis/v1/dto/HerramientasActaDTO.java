package com.tesis.v1.dto;

public class HerramientasActaDTO {

    private Integer idherramienta;
    private Integer idactas;
    private String juicioexpertos;
    private String recopilaciondatos;
    private String habilidades;
    private String herramientareuniones;

    //idactas int4 NOT NULL,
    public Integer getIdherramienta() {
        return idherramienta;
    }

    public Integer getIdactas() {
        return idactas;
    }

    public void setIdactas(Integer idactas) {
        this.idactas = idactas;
    }

    public void setIdherramienta(Integer idherramienta) {
        this.idherramienta = idherramienta;
    }

    public String getJuicioexpertos() {
        return juicioexpertos;
    }

    public void setJuicioexpertos(String juicioexpertos) {
        this.juicioexpertos = juicioexpertos;
    }

    public String getRecopilaciondatos() {
        return recopilaciondatos;
    }

    public void setRecopilaciondatos(String recopilaciondatos) {
        this.recopilaciondatos = recopilaciondatos;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public String getHerramientareuniones() {
        return herramientareuniones;
    }

    public void setHerramientareuniones(String herramientareuniones) {
        this.herramientareuniones = herramientareuniones;
    }

}
