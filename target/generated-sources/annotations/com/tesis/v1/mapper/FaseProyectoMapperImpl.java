package com.tesis.v1.mapper;

import com.tesis.v1.domain.FaseProyecto;
import com.tesis.v1.dto.faseproyectoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class FaseProyectoMapperImpl implements FaseProyectoMapper {

    @Override
    public faseproyectoDTO tofaseProyectoDTO(FaseProyecto faseProyecto) {
        if ( faseProyecto == null ) {
            return null;
        }

        faseproyectoDTO faseproyectoDTO = new faseproyectoDTO();

        faseproyectoDTO.setIdfase( faseProyecto.getIdfase() );
        faseproyectoDTO.setNombrefase( faseProyecto.getNombrefase() );
        faseproyectoDTO.setDescripcionfase( faseProyecto.getDescripcionfase() );

        return faseproyectoDTO;
    }

    @Override
    public FaseProyecto tofaseProyecto(faseproyectoDTO faseproyectoDTO) {
        if ( faseproyectoDTO == null ) {
            return null;
        }

        FaseProyecto faseProyecto = new FaseProyecto();

        faseProyecto.setIdfase( faseproyectoDTO.getIdfase() );
        faseProyecto.setNombrefase( faseproyectoDTO.getNombrefase() );
        faseProyecto.setDescripcionfase( faseproyectoDTO.getDescripcionfase() );

        return faseProyecto;
    }

    @Override
    public List<faseproyectoDTO> tofaseProyectoDTO(List<FaseProyecto> faseProyectos) {
        if ( faseProyectos == null ) {
            return null;
        }

        List<faseproyectoDTO> list = new ArrayList<faseproyectoDTO>( faseProyectos.size() );
        for ( FaseProyecto faseProyecto : faseProyectos ) {
            list.add( tofaseProyectoDTO( faseProyecto ) );
        }

        return list;
    }

    @Override
    public List<FaseProyecto> tofaseProyecto(List<faseproyectoDTO> faseProyectoDTOs) {
        if ( faseProyectoDTOs == null ) {
            return null;
        }

        List<FaseProyecto> list = new ArrayList<FaseProyecto>( faseProyectoDTOs.size() );
        for ( faseproyectoDTO faseproyectoDTO : faseProyectoDTOs ) {
            list.add( tofaseProyecto( faseproyectoDTO ) );
        }

        return list;
    }
}
