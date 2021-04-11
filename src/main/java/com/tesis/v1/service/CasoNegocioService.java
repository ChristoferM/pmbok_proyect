package com.tesis.v1.service;

import java.util.List;

import com.tesis.v1.domain.casonegocio;

public interface CasoNegocioService  extends GenericService<casonegocio,Integer>{

	casonegocio save(casonegocio entity, Integer idEntrada) throws Exception;
	
	
	public List<casonegocio> casoNegocioDelActa(Integer idProyecto);
    
}
