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
	
<<<<<<< HEAD:src/main/java/com/tesis/v1/dto/pdp/HerramientasDTO.java
	public HerramientasDTO(Integer idpdp, Integer idherramienta, String juicioexpertos, String recopilaciondatos,
=======
<<<<<<< HEAD
=======
	public herramientasDTO(Integer idpdp, Integer idherramienta, String juicioexpertos, String recopilaciondatos,
>>>>>>> 5e3e6b0e3444878d6173d307f9e7a5793ef6614b:src/main/java/com/tesis/v1/dto/pdp/herramientasDTO.java
			String habilidades, String herramientareuniones) {
		this.idpdp = idpdp;
		this.idherramienta = idherramienta;
		this.juicioexpertos = juicioexpertos;
		this.recopilaciondatos = recopilaciondatos;
		this.habilidades = habilidades;
		this.herramientareuniones = herramientareuniones;
	}
>>>>>>> 8355755ed4d8c95213239d015f4ed2fbb090e292


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
