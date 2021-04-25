package com.tesis.v1.mapper;

import com.tesis.v1.domain.rolproyecto;
import com.tesis.v1.dto.rolproyectoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 14.0.2 (Private Build)"
)
@Component
public class rolproyectoMapperImpl implements rolproyectoMapper {

    @Override
    public rolproyectoDTO torolProyectoDTO(rolproyecto rolProyecto) {
        if ( rolProyecto == null ) {
            return null;
        }

        rolproyectoDTO rolproyectoDTO = new rolproyectoDTO();

        rolproyectoDTO.setId_rol_proyecto( rolProyecto.getId_rol_proyecto() );

        return rolproyectoDTO;
    }

    @Override
    public rolproyecto torolProyecto(rolproyectoDTO rolProyectoDTO) {
        if ( rolProyectoDTO == null ) {
            return null;
        }

        rolproyecto rolproyecto = new rolproyecto();

        rolproyecto.setId_rol_proyecto( rolProyectoDTO.getId_rol_proyecto() );

        return rolproyecto;
    }

    @Override
    public List<rolproyectoDTO> torolProyectoDTOs(List<rolproyecto> rolProyectos) {
        if ( rolProyectos == null ) {
            return null;
        }

        List<rolproyectoDTO> list = new ArrayList<rolproyectoDTO>( rolProyectos.size() );
        for ( rolproyecto rolproyecto : rolProyectos ) {
            list.add( torolProyectoDTO( rolproyecto ) );
        }

        return list;
    }

    @Override
    public List<rolproyectoDTO> torolProyectos(List<rolproyectoDTO> rolProyectoDTOs) {
        if ( rolProyectoDTOs == null ) {
            return null;
        }

        List<rolproyectoDTO> list = new ArrayList<rolproyectoDTO>( rolProyectoDTOs.size() );
        for ( rolproyectoDTO rolproyectoDTO : rolProyectoDTOs ) {
            list.add( rolproyectoDTO );
        }

        return list;
    }
}
