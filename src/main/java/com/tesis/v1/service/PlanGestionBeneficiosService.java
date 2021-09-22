package com.tesis.v1.service;

import java.util.List;

import com.tesis.v1.domain.PlanGestionbeneficio;
import com.tesis.v1.dto.PlanDeGestionDeBeneficiosDelActaDTO;
import com.tesis.v1.dto.PlanGestionBeneficioDTO;

public interface PlanGestionBeneficiosService extends GenericService<PlanGestionbeneficio, Integer> {

    public List<PlanGestionbeneficio> planGestionDelActa(Integer idProyecto);
    
    public PlanGestionBeneficioDTO guardarPlanDeBeneficiosNuevo (PlanDeGestionDeBeneficiosDelActaDTO planDeGestionDeBeneficiosDelActaDTO) throws Exception;

    public PlanGestionBeneficioDTO updatePlanNuevo (PlanDeGestionDeBeneficiosDelActaDTO planDeGestionDeBeneficiosDelActaDTO) throws Exception;

}
