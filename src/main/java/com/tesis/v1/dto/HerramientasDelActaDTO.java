package com.tesis.v1.dto;

public class HerramientasDelActaDTO {
	
	private Boolean estado;
	private Integer idfase;
	private Integer idproyecto;
	private String participa;

    private String juicioexpertos;
    private String recopilaciondatos;
    private String habilidades;
    private String herramientareuniones;

	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public Integer getIdfase() {
		return idfase;
	}
	public void setIdfase(Integer idfase) {
		this.idfase = idfase;
	}
	public Integer getIdproyecto() {
		return idproyecto;
	}
	public void setIdproyecto(Integer idproyecto) {
		this.idproyecto = idproyecto;
	}
	public String getParticipa() {
		return participa;
	}
	public void setParticipa(String participa) {
		this.participa = participa;
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
