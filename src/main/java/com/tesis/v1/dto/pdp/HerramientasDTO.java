package com.tesis.v1.dto.pdp;



public class HerramientasDTO {
	
	private Integer idpdp;
	private Integer idherramienta;
	private String juicioexpertos;
	private String recopilaciondatos;
	private String habilidades;
	private String herramientareuniones;


	public HerramientasDTO(){

	}
	
	public HerramientasDTO(Integer idpdp, Integer idherramienta, String juicioexpertos, String recopilaciondatos,
			String habilidades, String herramientareuniones) {
		this.idpdp = idpdp;
		this.idherramienta = idherramienta;
		this.juicioexpertos = juicioexpertos;
		this.recopilaciondatos = recopilaciondatos;
		this.habilidades = habilidades;
		this.herramientareuniones = herramientareuniones;
	}


	public Integer getIdpdp() {
		return idpdp;
	}

	public void setIdpdp(Integer idpdp) {
		this.idpdp = idpdp;
	}

	public Integer getIdherramienta() {
		return idherramienta;
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
