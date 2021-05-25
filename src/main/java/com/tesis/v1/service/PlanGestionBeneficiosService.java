package com.tesis.v1.service;

import java.util.List;

import com.tesis.v1.domain.PlanGestionbeneficio;

public interface PlanGestionBeneficiosService extends GenericService<PlanGestionbeneficio, Integer> {

    public List<PlanGestionbeneficio> planGestionDelActa(Integer idProyecto);

}
