package com.tesis.v1.service;

import java.util.List;

import com.tesis.v1.domain.herramientasacta;

public interface HerramientasActasService extends GenericService<herramientasacta,Integer> {
	
	public List<herramientasacta> herramientaDelActa(Integer idProyecto);
    
}
