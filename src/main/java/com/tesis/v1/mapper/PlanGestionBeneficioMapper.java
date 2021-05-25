package com.tesis.v1.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.tesis.v1.domain.PlanGestionbeneficio;
import com.tesis.v1.dto.PlanGestionBeneficioDTO;

@Mapper
public interface PlanGestionBeneficioMapper {

    public PlanGestionBeneficioDTO toplanesGestionBeneficiosDTO(PlanGestionbeneficio planesGestionBeneficios);

    public PlanGestionbeneficio toplanesGestionBeneficios(PlanGestionBeneficioDTO planesGestionBeneficiosDTO);

    public List<PlanGestionBeneficioDTO> toplanesGestionBeneficiosDTO(List<PlanGestionbeneficio> planesGestionBeneficios);

    public List<PlanGestionbeneficio> toplanesGestionBeneficios(List<PlanGestionBeneficioDTO> planesGestionBeneficiosDTOs);
}
