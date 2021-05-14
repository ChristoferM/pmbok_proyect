package com.tesis.v1.mapper;

import com.tesis.v1.domain.Reunion;
import com.tesis.v1.dto.reunionesDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class ReunionMapperImpl implements ReunionMapper {

    @Override
    public reunionesDTO toReunionDTO(Reunion reuniones) {
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
    public Reunion toReunionDTO(reunionesDTO reunionesDTO) {
        if ( reunionesDTO == null ) {
            return null;
        }

        Reunion reunion = new Reunion();

        reunion.setIdreuniones( reunionesDTO.getIdreuniones() );
        reunion.setNombrereunion( reunionesDTO.getNombrereunion() );
        reunion.setDescripcionreunion( reunionesDTO.getDescripcionreunion() );

        return reunion;
    }

    @Override
    public List<reunionesDTO> toReunionDTOs(List<Reunion> reunioness) {
        if ( reunioness == null ) {
            return null;
        }

        List<reunionesDTO> list = new ArrayList<reunionesDTO>( reunioness.size() );
        for ( Reunion reunion : reunioness ) {
            list.add( toReunionDTO( reunion ) );
        }

        return list;
    }

    @Override
    public List<Reunion> toReunions(List<reunionesDTO> reunionesDTOs) {
        if ( reunionesDTOs == null ) {
            return null;
        }

        List<Reunion> list = new ArrayList<Reunion>( reunionesDTOs.size() );
        for ( reunionesDTO reunionesDTO : reunionesDTOs ) {
            list.add( toReunionDTO( reunionesDTO ) );
        }

        return list;
    }
}
