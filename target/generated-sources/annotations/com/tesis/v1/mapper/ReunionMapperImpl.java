package com.tesis.v1.mapper;

import com.tesis.v1.domain.Reunion;
import com.tesis.v1.dto.ReunionesDTO;
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
    public ReunionesDTO toReunionDTO(Reunion reuniones) {
        if ( reuniones == null ) {
            return null;
        }

        ReunionesDTO reunionesDTO = new ReunionesDTO();

        reunionesDTO.setIdreuniones( reuniones.getIdreuniones() );
        reunionesDTO.setNombrereunion( reuniones.getNombrereunion() );
        reunionesDTO.setDescripcionreunion( reuniones.getDescripcionreunion() );

        return reunionesDTO;
    }

    @Override
    public Reunion toReunionDTO(ReunionesDTO reunionesDTO) {
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
    public List<ReunionesDTO> toReunionDTOs(List<Reunion> reunioness) {
        if ( reunioness == null ) {
            return null;
        }

        List<ReunionesDTO> list = new ArrayList<ReunionesDTO>( reunioness.size() );
        for ( Reunion reunion : reunioness ) {
            list.add( toReunionDTO( reunion ) );
        }

        return list;
    }

    @Override
    public List<Reunion> toReunions(List<ReunionesDTO> reunionesDTOs) {
        if ( reunionesDTOs == null ) {
            return null;
        }

        List<Reunion> list = new ArrayList<Reunion>( reunionesDTOs.size() );
        for ( ReunionesDTO reunionesDTO : reunionesDTOs ) {
            list.add( toReunionDTO( reunionesDTO ) );
        }

        return list;
    }
}
