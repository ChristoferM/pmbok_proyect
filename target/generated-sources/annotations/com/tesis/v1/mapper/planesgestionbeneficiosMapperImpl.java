package com.tesis.v1.mapper;

import com.tesis.v1.domain.planesgestionbeneficios;
import com.tesis.v1.dto.planesgestionbeneficiosDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 14.0.2 (Private Build)"
)
@Component
public class planesgestionbeneficiosMapperImpl implements planesgestionbeneficiosMapper {

    @Override
    public planesgestionbeneficiosDTO toplanesGestionBeneficiosDTO(planesgestionbeneficios planesGestionBeneficios) {
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
    public planesgestionbeneficios toplanesGestionBeneficios(planesgestionbeneficiosDTO planesGestionBeneficiosDTO) {
        if ( planesGestionBeneficiosDTO == null ) {
            return null;
        }

        planesgestionbeneficios planesgestionbeneficios = new planesgestionbeneficios();

        planesgestionbeneficios.setId_plan_gb( planesGestionBeneficiosDTO.getId_plan_gb() );
        planesgestionbeneficios.setAcciones( planesGestionBeneficiosDTO.getAcciones() );
        planesgestionbeneficios.setComponentes( planesGestionBeneficiosDTO.getComponentes() );
        planesgestionbeneficios.setProdcutos( planesGestionBeneficiosDTO.getProdcutos() );
        planesgestionbeneficios.setServicios( planesGestionBeneficiosDTO.getServicios() );
        planesgestionbeneficios.setResultado( planesGestionBeneficiosDTO.getResultado() );

        return planesgestionbeneficios;
    }

    @Override
    public List<planesgestionbeneficiosDTO> toplanesGestionBeneficiosDTO(List<planesgestionbeneficios> planesGestionBeneficios) {
        if ( planesGestionBeneficios == null ) {
            return null;
        }

        List<planesgestionbeneficiosDTO> list = new ArrayList<planesgestionbeneficiosDTO>( planesGestionBeneficios.size() );
        for ( planesgestionbeneficios planesgestionbeneficios : planesGestionBeneficios ) {
            list.add( toplanesGestionBeneficiosDTO( planesgestionbeneficios ) );
        }

        return list;
    }

    @Override
    public List<planesgestionbeneficios> toplanesGestionBeneficios(List<planesgestionbeneficiosDTO> planesGestionBeneficiosDTOs) {
        if ( planesGestionBeneficiosDTOs == null ) {
            return null;
        }

        List<planesgestionbeneficios> list = new ArrayList<planesgestionbeneficios>( planesGestionBeneficiosDTOs.size() );
        for ( planesgestionbeneficiosDTO planesgestionbeneficiosDTO : planesGestionBeneficiosDTOs ) {
            list.add( toplanesGestionBeneficios( planesgestionbeneficiosDTO ) );
        }

        return list;
    }
}
