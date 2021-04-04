package com.tesis.v1.mapper;

import com.tesis.v1.domain.planesgestionbeneficios;
import com.tesis.v1.dto.planesgestionbeneficiosDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 15 (Oracle Corporation)"
)
@Component
public class planesgestionbeneficiosMapperImpl implements planesgestionbeneficiosMapper {

    @Override
    public planesgestionbeneficiosDTO toplanesGestionBeneficiosDTO(planesgestionbeneficios planesGestionBeneficios) {
        if ( planesGestionBeneficios == null ) {
            return null;
        }

        planesgestionbeneficiosDTO planesgestionbeneficiosDTO = new planesgestionbeneficiosDTO();

        planesgestionbeneficiosDTO.setAcciones( planesGestionBeneficios.getAcciones() );
        planesgestionbeneficiosDTO.setComponentes( planesGestionBeneficios.getComponentes() );
        planesgestionbeneficiosDTO.setId_plan_gb( planesGestionBeneficios.getId_plan_gb() );
        planesgestionbeneficiosDTO.setProdcutos( planesGestionBeneficios.getProdcutos() );
        planesgestionbeneficiosDTO.setResultado( planesGestionBeneficios.getResultado() );
        planesgestionbeneficiosDTO.setServicios( planesGestionBeneficios.getServicios() );

        return planesgestionbeneficiosDTO;
    }

    @Override
    public planesgestionbeneficios toplanesGestionBeneficios(planesgestionbeneficiosDTO planesGestionBeneficiosDTO) {
        if ( planesGestionBeneficiosDTO == null ) {
            return null;
        }

        planesgestionbeneficios planesgestionbeneficios = new planesgestionbeneficios();

        planesgestionbeneficios.setAcciones( planesGestionBeneficiosDTO.getAcciones() );
        planesgestionbeneficios.setComponentes( planesGestionBeneficiosDTO.getComponentes() );
        planesgestionbeneficios.setId_plan_gb( planesGestionBeneficiosDTO.getId_plan_gb() );
        planesgestionbeneficios.setProdcutos( planesGestionBeneficiosDTO.getProdcutos() );
        planesgestionbeneficios.setResultado( planesGestionBeneficiosDTO.getResultado() );
        planesgestionbeneficios.setServicios( planesGestionBeneficiosDTO.getServicios() );

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
