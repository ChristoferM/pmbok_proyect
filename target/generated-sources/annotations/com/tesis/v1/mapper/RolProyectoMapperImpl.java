package com.tesis.v1.mapper;

import com.tesis.v1.domain.RolProyecto;
import com.tesis.v1.dto.RolproyectoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.2 (Eclipse Adoptium)"
)
@Component
public class RolProyectoMapperImpl implements RolProyectoMapper {

    @Override
    public RolproyectoDTO torolProyectoDTO(RolProyecto rolProyecto) {
        if ( rolProyecto == null ) {
            return null;
        }

        RolproyectoDTO rolproyectoDTO = new RolproyectoDTO();

        rolproyectoDTO.setId_rol_proyecto( rolProyecto.getId_rol_proyecto() );

        return rolproyectoDTO;
    }

    @Override
    public RolProyecto torolProyecto(RolproyectoDTO rolProyectoDTO) {
        if ( rolProyectoDTO == null ) {
            return null;
        }

        RolProyecto rolProyecto = new RolProyecto();

        rolProyecto.setId_rol_proyecto( rolProyectoDTO.getId_rol_proyecto() );

        return rolProyecto;
    }

    @Override
    public List<RolproyectoDTO> torolProyectoDTOs(List<RolProyecto> rolProyectos) {
        if ( rolProyectos == null ) {
            return null;
        }

        List<RolproyectoDTO> list = new ArrayList<RolproyectoDTO>( rolProyectos.size() );
        for ( RolProyecto rolProyecto : rolProyectos ) {
            list.add( torolProyectoDTO( rolProyecto ) );
        }

        return list;
    }

    @Override
    public List<RolproyectoDTO> torolProyectos(List<RolproyectoDTO> rolProyectoDTOs) {
        if ( rolProyectoDTOs == null ) {
            return null;
        }

        List<RolproyectoDTO> list = new ArrayList<RolproyectoDTO>( rolProyectoDTOs.size() );
        for ( RolproyectoDTO rolproyectoDTO : rolProyectoDTOs ) {
            list.add( rolproyectoDTO );
        }

        return list;
    }
}
