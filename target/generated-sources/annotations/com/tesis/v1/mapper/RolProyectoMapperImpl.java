package com.tesis.v1.mapper;

import com.tesis.v1.domain.RolProyecto;
import com.tesis.v1.dto.rolproyectoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class RolProyectoMapperImpl implements RolProyectoMapper {

    @Override
    public rolproyectoDTO torolProyectoDTO(RolProyecto rolProyecto) {
        if ( rolProyecto == null ) {
            return null;
        }

        rolproyectoDTO rolproyectoDTO = new rolproyectoDTO();

        rolproyectoDTO.setId_rol_proyecto( rolProyecto.getId_rol_proyecto() );

        return rolproyectoDTO;
    }

    @Override
    public RolProyecto torolProyecto(rolproyectoDTO rolProyectoDTO) {
        if ( rolProyectoDTO == null ) {
            return null;
        }

        RolProyecto rolProyecto = new RolProyecto();

        rolProyecto.setId_rol_proyecto( rolProyectoDTO.getId_rol_proyecto() );

        return rolProyecto;
    }

    @Override
    public List<rolproyectoDTO> torolProyectoDTOs(List<RolProyecto> rolProyectos) {
        if ( rolProyectos == null ) {
            return null;
        }

        List<rolproyectoDTO> list = new ArrayList<rolproyectoDTO>( rolProyectos.size() );
        for ( RolProyecto rolProyecto : rolProyectos ) {
            list.add( torolProyectoDTO( rolProyecto ) );
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
