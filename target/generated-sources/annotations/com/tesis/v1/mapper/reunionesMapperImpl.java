package com.tesis.v1.mapper;

import com.tesis.v1.domain.reuniones;
import com.tesis.v1.dto.reunionesDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 14.0.2 (Private Build)"
)
@Component
public class reunionesMapperImpl implements reunionesMapper {

    @Override
    public reunionesDTO toReunionDTO(reuniones reuniones) {
        if ( reuniones == null ) {
            return null;
        }

        reunionesDTO reunionesDTO = new reunionesDTO();

        reunionesDTO.setIdreuniones( reuniones.getIdreuniones() );
        reunionesDTO.setNombrereunion( reuniones.getNombrereunion() );
        reunionesDTO.setDescripcionreunion( reuniones.getDescripcionreunion() );

        return reunionesDTO;
    }

    @Override
    public reuniones toReunionDTO(reunionesDTO reunionesDTO) {
        if ( reunionesDTO == null ) {
            return null;
        }

        reuniones reuniones = new reuniones();

        reuniones.setIdreuniones( reunionesDTO.getIdreuniones() );
        reuniones.setNombrereunion( reunionesDTO.getNombrereunion() );
        reuniones.setDescripcionreunion( reunionesDTO.getDescripcionreunion() );

        return reuniones;
    }

    @Override
    public List<reunionesDTO> toReunionDTOs(List<reuniones> reunioness) {
        if ( reunioness == null ) {
            return null;
        }

        List<reunionesDTO> list = new ArrayList<reunionesDTO>( reunioness.size() );
        for ( reuniones reuniones : reunioness ) {
            list.add( toReunionDTO( reuniones ) );
        }

        return list;
    }

    @Override
    public List<reuniones> toReunions(List<reunionesDTO> reunionesDTOs) {
        if ( reunionesDTOs == null ) {
            return null;
        }

        List<reuniones> list = new ArrayList<reuniones>( reunionesDTOs.size() );
        for ( reunionesDTO reunionesDTO : reunionesDTOs ) {
            list.add( toReunionDTO( reunionesDTO ) );
        }

        return list;
    }
}
