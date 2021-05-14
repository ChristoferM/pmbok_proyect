package com.tesis.v1.dto;

public class ValidarActaDTO {
	
	
	private Boolean acta;
	private Boolean entradactaValidate ;
	private Boolean herramientasValidate ;
	private Boolean planValidate ;
	private Boolean casoNegocioValidate ;
	
	
	
	public Boolean getCasoNegocioValidate() {
		return casoNegocioValidate;
	}
	public void setCasoNegocioValidate(Boolean casoNegocioValidate) {
		this.casoNegocioValidate = casoNegocioValidate;
	}
	public Boolean getActa() {
		return acta;
	}
	public void setActa(Boolean acta) {
		this.acta = acta;
	}
	
	public Boolean getEntradactaValidate() {
		return entradactaValidate;
	}
	public void setEntradactaValidate(Boolean entradactaValidate) {
		this.entradactaValidate = entradactaValidate;
	}
	public Boolean getHerramientasValidate() {
		return herramientasValidate;
	}
	public void setHerramientasValidate(Boolean herramientasValidate) {
		this.herramientasValidate = herramientasValidate;
	}
	public Boolean getPlanValidate() {
		return planValidate;
	}
	public void setPlanValidate(Boolean planValidate) {
		this.planValidate = planValidate;
	}
	
	

}
