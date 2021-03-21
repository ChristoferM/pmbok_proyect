package com.tesis.v1.service;

import com.tesis.v1.domain.casonegocio;

public interface CasoNegocioService  extends GenericService<casonegocio,Integer>{

	casonegocio save(casonegocio entity, Integer idEntrada) throws Exception;
    
}
