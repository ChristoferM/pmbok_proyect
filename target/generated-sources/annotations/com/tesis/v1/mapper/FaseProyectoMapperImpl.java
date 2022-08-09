package com.tesis.v1.mapper;

import com.tesis.v1.domain.FaseProyecto;
import com.tesis.v1.dto.FaseProyectoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.2 (Eclipse Adoptium)"
)
@Component
public class FaseProyectoMapperImpl implements FaseProyectoMapper {

    @Override
    public FaseProyectoDTO tofaseProyectoDTO(FaseProyecto faseProyecto) {
        if ( faseProyecto == null ) {
            return null;
        }

        FaseProyectoDTO faseProyectoDTO = new FaseProyectoDTO();

        faseProyectoDTO.setIdfase( faseProyecto.getIdfase() );
        faseProyectoDTO.setDescripcionfase( faseProyecto.getDescripcionfase() );
        faseProyectoDTO.setTiempoinicio( faseProyecto.getTiempoinicio() );
        faseProyectoDTO.setTiempofin( faseProyecto.getTiempofin() );

        return faseProyectoDTO;
    }

    @Override
    public FaseProyecto tofaseProyecto(FaseProyectoDTO faseproyectoDTO) {
        if ( faseproyectoDTO == null ) {
            return null;
        }

        FaseProyecto faseProyecto = new FaseProyecto();

        faseProyecto.setIdfase( faseproyectoDTO.getIdfase() );
        faseProyecto.setDescripcionfase( faseproyectoDTO.getDescripcionfase() );
        faseProyecto.setTiempoinicio( faseproyectoDTO.getTiempoinicio() );
        faseProyecto.setTiempofin( faseproyectoDTO.getTiempofin() );

        return faseProyecto;
    }

    @Override
    public List<FaseProyectoDTO> tofaseProyectoDTO(List<FaseProyecto> faseProyectos) {
        if ( faseProyectos == null ) {
            return null;
        }

        List<FaseProyectoDTO> list = new ArrayList<FaseProyectoDTO>( faseProyectos.size() );
        for ( FaseProyecto faseProyecto : faseProyectos ) {
            list.add( tofaseProyectoDTO( faseProyecto ) );
        }

        return list;
    }

    @Override
    public List<FaseProyecto> tofaseProyecto(List<FaseProyectoDTO> faseProyectoDTOs) {
        if ( faseProyectoDTOs == null ) {
            return null;
        }

        List<FaseProyecto> list = new ArrayList<FaseProyecto>( faseProyectoDTOs.size() );
        for ( FaseProyectoDTO faseProyectoDTO : faseProyectoDTOs ) {
            list.add( tofaseProyecto( faseProyectoDTO ) );
        }

        return list;
    }
}
