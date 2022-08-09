package com.tesis.v1.mapper;

import com.tesis.v1.domain.PlanGestionbeneficio;
import com.tesis.v1.dto.PlanGestionBeneficioDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.2 (Eclipse Adoptium)"
)
@Component
public class PlanGestionBeneficioMapperImpl implements PlanGestionBeneficioMapper {

    @Override
    public PlanGestionBeneficioDTO toplanesGestionBeneficiosDTO(PlanGestionbeneficio planesGestionBeneficios) {
        if ( planesGestionBeneficios == null ) {
            return null;
        }

        PlanGestionBeneficioDTO planGestionBeneficioDTO = new PlanGestionBeneficioDTO();

        planGestionBeneficioDTO.setParticipa( planesGestionBeneficios.getParticipa() );
        planGestionBeneficioDTO.setId_plan_gb( planesGestionBeneficios.getId_plan_gb() );
        planGestionBeneficioDTO.setAcciones( planesGestionBeneficios.getAcciones() );
        planGestionBeneficioDTO.setComponentes( planesGestionBeneficios.getComponentes() );
        planGestionBeneficioDTO.setProdcutos( planesGestionBeneficios.getProdcutos() );
        planGestionBeneficioDTO.setServicios( planesGestionBeneficios.getServicios() );
        planGestionBeneficioDTO.setResultado( planesGestionBeneficios.getResultado() );
        planGestionBeneficioDTO.setEstado( planesGestionBeneficios.getEstado() );

        return planGestionBeneficioDTO;
    }

    @Override
    public PlanGestionbeneficio toplanesGestionBeneficios(PlanGestionBeneficioDTO planesGestionBeneficiosDTO) {
        if ( planesGestionBeneficiosDTO == null ) {
            return null;
        }

        PlanGestionbeneficio planGestionbeneficio = new PlanGestionbeneficio();

        planGestionbeneficio.setId_plan_gb( planesGestionBeneficiosDTO.getId_plan_gb() );
        planGestionbeneficio.setAcciones( planesGestionBeneficiosDTO.getAcciones() );
        planGestionbeneficio.setComponentes( planesGestionBeneficiosDTO.getComponentes() );
        planGestionbeneficio.setProdcutos( planesGestionBeneficiosDTO.getProdcutos() );
        planGestionbeneficio.setServicios( planesGestionBeneficiosDTO.getServicios() );
        planGestionbeneficio.setResultado( planesGestionBeneficiosDTO.getResultado() );
        planGestionbeneficio.setEstado( planesGestionBeneficiosDTO.getEstado() );
        planGestionbeneficio.setParticipa( planesGestionBeneficiosDTO.getParticipa() );

        return planGestionbeneficio;
    }

    @Override
    public List<PlanGestionBeneficioDTO> toplanesGestionBeneficiosDTO(List<PlanGestionbeneficio> planesGestionBeneficios) {
        if ( planesGestionBeneficios == null ) {
            return null;
        }

        List<PlanGestionBeneficioDTO> list = new ArrayList<PlanGestionBeneficioDTO>( planesGestionBeneficios.size() );
        for ( PlanGestionbeneficio planGestionbeneficio : planesGestionBeneficios ) {
            list.add( toplanesGestionBeneficiosDTO( planGestionbeneficio ) );
        }

        return list;
    }

    @Override
    public List<PlanGestionbeneficio> toplanesGestionBeneficios(List<PlanGestionBeneficioDTO> planesGestionBeneficiosDTOs) {
        if ( planesGestionBeneficiosDTOs == null ) {
            return null;
        }

        List<PlanGestionbeneficio> list = new ArrayList<PlanGestionbeneficio>( planesGestionBeneficiosDTOs.size() );
        for ( PlanGestionBeneficioDTO planGestionBeneficioDTO : planesGestionBeneficiosDTOs ) {
            list.add( toplanesGestionBeneficios( planGestionBeneficioDTO ) );
        }

        return list;
    }
}
