package com.tesis.v1.service;

import java.util.List;

import com.tesis.v1.domain.Herramientasacta;

public interface HerramientasActasService extends GenericService<Herramientasacta,Integer> {
	
	public List<Herramientasacta> herramientaDelActa(Integer idProyecto);
    
}
