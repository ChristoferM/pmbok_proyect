package com.tesis.v1.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tesis.v1.domain.CasoNegocio;
import com.tesis.v1.dto.CasoDeNegocioDelActaDTO;

public interface CasoNegocioService  extends GenericService<CasoNegocio,Integer>{

	CasoNegocio save(CasoNegocio entity, Integer idEntrada) throws Exception;
	
	
	public List<CasoNegocio> BuscarDatosDeCasonegocio (CasoDeNegocioDelActaDTO cCasoDeNegocioDelActaDTO) throws Exception;
	
	public List<CasoNegocio> casoNegocioDelActa(Integer idProyecto);
	
	public CasoNegocio guardarCasoNegocio(CasoDeNegocioDelActaDTO casoDeNegocioDelActaDTO) throws Exception;
	
	public CasoNegocio actualizarCasoNegocio(CasoDeNegocioDelActaDTO casoDeNegocioDelActaDTO) throws Exception;
    
}
