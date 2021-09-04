package com.tesis.v1.service;

import java.util.List;

import com.tesis.v1.domain.Herramientasacta;
import com.tesis.v1.dto.HerramientasDelActaDTO;

public interface HerramientasActasService extends GenericService<Herramientasacta,Integer> {
	
	public List<Herramientasacta> herramientaDelActa(Integer idProyecto);
	
	public Herramientasacta guardarHerramientasDelActa(HerramientasDelActaDTO herramientasDelActaDTO)  throws Exception;
    
}
