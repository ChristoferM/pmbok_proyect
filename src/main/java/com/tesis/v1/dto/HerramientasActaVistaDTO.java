package com.tesis.v1.dto;

public class HerramientasActaVistaDTO {

    private String juicioexpertos;
    private String recopilaciondatos;
    private String habilidades;
    private String herramientareuniones;
    private Boolean estado;
    //idactas int4 NOT NULL,
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

    public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
}
