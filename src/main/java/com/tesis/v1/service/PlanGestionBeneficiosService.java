package com.tesis.v1.service;

import java.util.List;

import com.tesis.v1.domain.planesgestionbeneficios;

public interface PlanGestionBeneficiosService extends GenericService<planesgestionbeneficios,Integer>{
	public List<planesgestionbeneficios> planGestionDelActa(Integer idProyecto);
    
}
