package com.tesis.v1.mapper;

import com.tesis.v1.domain.Tipo_proyecto;
import com.tesis.v1.dto.tipo_proyectoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.2 (Eclipse Adoptium)"
)
@Component
public class Tipo_proyectoMapperImpl implements Tipo_proyectoMapper {

    @Override
    public tipo_proyectoDTO toTipo_proyectoDTO(Tipo_proyecto tipo_proyecto) {
        if ( tipo_proyecto == null ) {
            return null;
        }

        tipo_proyectoDTO tipo_proyectoDTO = new tipo_proyectoDTO();

        tipo_proyectoDTO.setTipo_id( tipo_proyecto.getTipo_id() );
        tipo_proyectoDTO.setClasificacion( tipo_proyecto.getClasificacion() );

        return tipo_proyectoDTO;
    }

    @Override
    public Tipo_proyecto toTipo_proyecto(tipo_proyectoDTO tipo_proyectoDTO) {
        if ( tipo_proyectoDTO == null ) {
            return null;
        }

        Tipo_proyecto tipo_proyecto = new Tipo_proyecto();

        tipo_proyecto.setTipo_id( tipo_proyectoDTO.getTipo_id() );
        tipo_proyecto.setClasificacion( tipo_proyectoDTO.getClasificacion() );

        return tipo_proyecto;
    }

    @Override
    public List<tipo_proyectoDTO> toTipo_proyectosDTOs(List<Tipo_proyecto> tipo_proyectos) {
        if ( tipo_proyectos == null ) {
            return null;
        }

        List<tipo_proyectoDTO> list = new ArrayList<tipo_proyectoDTO>( tipo_proyectos.size() );
        for ( Tipo_proyecto tipo_proyecto : tipo_proyectos ) {
            list.add( toTipo_proyectoDTO( tipo_proyecto ) );
        }

        return list;
    }

    @Override
    public List<Tipo_proyecto> toTipo_proyectos(List<tipo_proyectoDTO> tipo_proyectoDTOs) {
        if ( tipo_proyectoDTOs == null ) {
            return null;
        }

        List<Tipo_proyecto> list = new ArrayList<Tipo_proyecto>( tipo_proyectoDTOs.size() );
        for ( tipo_proyectoDTO tipo_proyectoDTO : tipo_proyectoDTOs ) {
            list.add( toTipo_proyecto( tipo_proyectoDTO ) );
        }

        return list;
    }
}
