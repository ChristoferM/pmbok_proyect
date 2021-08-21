package com.tesis.v1.mapper;

import com.tesis.v1.domain.FaseProyecto;
import com.tesis.v1.dto.FaseProyectoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 15 (Oracle Corporation)"
)
@Component
public class FaseProyectoMapperImpl implements FaseProyectoMapper {

    @Override
    public FaseProyectoDTO tofaseProyectoDTO(FaseProyecto faseProyecto) {
        if ( faseProyecto == null ) {
            return null;
        }

        FaseProyectoDTO faseProyectoDTO = new FaseProyectoDTO();

        faseProyectoDTO.setDescripcionfase( faseProyecto.getDescripcionfase() );
        faseProyectoDTO.setIdfase( faseProyecto.getIdfase() );
        faseProyectoDTO.setTiempofin( faseProyecto.getTiempofin() );
        faseProyectoDTO.setTiempoinicio( faseProyecto.getTiempoinicio() );

        return faseProyectoDTO;
    }

    @Override
    public FaseProyecto tofaseProyecto(FaseProyectoDTO faseproyectoDTO) {
        if ( faseproyectoDTO == null ) {
            return null;
        }

        FaseProyecto faseProyecto = new FaseProyecto();

        faseProyecto.setDescripcionfase( faseproyectoDTO.getDescripcionfase() );
        faseProyecto.setIdfase( faseproyectoDTO.getIdfase() );
        faseProyecto.setTiempofin( faseproyectoDTO.getTiempofin() );
        faseProyecto.setTiempoinicio( faseproyectoDTO.getTiempoinicio() );

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
