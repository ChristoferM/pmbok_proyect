package com.tesis.v1.mapper;

import com.tesis.v1.domain.faseproyecto;
import com.tesis.v1.dto.faseproyectoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.3.1300.v20210331-0708, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class faseproyectoMapperImpl implements faseproyectoMapper {

    @Override
    public faseproyectoDTO tofaseProyectoDTO(faseproyecto faseProyecto) {
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
    public faseproyecto tofaseProyecto(faseproyectoDTO faseproyectoDTO) {
        if ( faseproyectoDTO == null ) {
            return null;
        }

        faseproyecto faseproyecto = new faseproyecto();

        faseproyecto.setIdfase( faseproyectoDTO.getIdfase() );
        faseproyecto.setNombrefase( faseproyectoDTO.getNombrefase() );
        faseproyecto.setDescripcionfase( faseproyectoDTO.getDescripcionfase() );

        return faseproyecto;
    }

    @Override
    public List<faseproyectoDTO> tofaseProyectoDTO(List<faseproyecto> faseProyectos) {
        if ( faseProyectos == null ) {
            return null;
        }

        List<faseproyectoDTO> list = new ArrayList<faseproyectoDTO>( faseProyectos.size() );
        for ( faseproyecto faseproyecto : faseProyectos ) {
            list.add( tofaseProyectoDTO( faseproyecto ) );
        }

        return list;
    }

    @Override
    public List<faseproyecto> tofaseProyecto(List<faseproyectoDTO> faseProyectoDTOs) {
        if ( faseProyectoDTOs == null ) {
            return null;
        }

        List<faseproyecto> list = new ArrayList<faseproyecto>( faseProyectoDTOs.size() );
        for ( faseproyectoDTO faseproyectoDTO : faseProyectoDTOs ) {
            list.add( tofaseProyecto( faseproyectoDTO ) );
        }

        return list;
    }
}
