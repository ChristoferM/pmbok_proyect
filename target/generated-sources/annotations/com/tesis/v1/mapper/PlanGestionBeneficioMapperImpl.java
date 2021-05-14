package com.tesis.v1.mapper;

import com.tesis.v1.domain.PlanGestionbeneficio;
import com.tesis.v1.dto.planesgestionbeneficiosDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class PlanGestionBeneficioMapperImpl implements PlanGestionBeneficioMapper {

    @Override
    public planesgestionbeneficiosDTO toplanesGestionBeneficiosDTO(PlanGestionbeneficio planesGestionBeneficios) {
        if ( planesGestionBeneficios == null ) {
            return null;
        }

        planesgestionbeneficiosDTO planesgestionbeneficiosDTO = new planesgestionbeneficiosDTO();

        planesgestionbeneficiosDTO.setId_plan_gb( planesGestionBeneficios.getId_plan_gb() );
        planesgestionbeneficiosDTO.setAcciones( planesGestionBeneficios.getAcciones() );
        planesgestionbeneficiosDTO.setComponentes( planesGestionBeneficios.getComponentes() );
        planesgestionbeneficiosDTO.setProdcutos( planesGestionBeneficios.getProdcutos() );
        planesgestionbeneficiosDTO.setServicios( planesGestionBeneficios.getServicios() );
        planesgestionbeneficiosDTO.setResultado( planesGestionBeneficios.getResultado() );

        return planesgestionbeneficiosDTO;
    }

    @Override
    public PlanGestionbeneficio toplanesGestionBeneficios(planesgestionbeneficiosDTO planesGestionBeneficiosDTO) {
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

        return planGestionbeneficio;
    }

    @Override
    public List<planesgestionbeneficiosDTO> toplanesGestionBeneficiosDTO(List<PlanGestionbeneficio> planesGestionBeneficios) {
        if ( planesGestionBeneficios == null ) {
            return null;
        }

        List<planesgestionbeneficiosDTO> list = new ArrayList<planesgestionbeneficiosDTO>( planesGestionBeneficios.size() );
        for ( PlanGestionbeneficio planGestionbeneficio : planesGestionBeneficios ) {
            list.add( toplanesGestionBeneficiosDTO( planGestionbeneficio ) );
        }

        return list;
    }

    @Override
    public List<PlanGestionbeneficio> toplanesGestionBeneficios(List<planesgestionbeneficiosDTO> planesGestionBeneficiosDTOs) {
        if ( planesGestionBeneficiosDTOs == null ) {
            return null;
        }

        List<PlanGestionbeneficio> list = new ArrayList<PlanGestionbeneficio>( planesGestionBeneficiosDTOs.size() );
        for ( planesgestionbeneficiosDTO planesgestionbeneficiosDTO : planesGestionBeneficiosDTOs ) {
            list.add( toplanesGestionBeneficios( planesgestionbeneficiosDTO ) );
        }

        return list;
    }
}
