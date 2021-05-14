package com.tesis.v1.service;

import java.util.List;

import com.tesis.v1.domain.CasoNegocio;

public interface CasoNegocioService  extends GenericService<CasoNegocio,Integer>{

	CasoNegocio save(CasoNegocio entity, Integer idEntrada) throws Exception;
	
	
	public List<CasoNegocio> casoNegocioDelActa(Integer idProyecto);
    
}
