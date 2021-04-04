package com.tesis.v1.mapper;

import com.tesis.v1.domain.proyectos;
import com.tesis.v1.dto.proyectosDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 15 (Oracle Corporation)"
)
@Component
public class proyectosMapperImpl implements proyectosMapper {

    @Override
    public proyectosDTO toproyectosDTO(proyectos proyectos) {
        if ( proyectos == null ) {
            return null;
        }

        proyectosDTO proyectosDTO = new proyectosDTO();

        proyectosDTO.setAdmin( proyectos.getAdmin() );
        proyectosDTO.setIdproyecto( proyectos.getIdproyecto() );
        proyectosDTO.setNombre( proyectos.getNombre() );
        proyectosDTO.setDescripcion( proyectos.getDescripcion() );

        return proyectosDTO;
    }

    @Override
    public proyectos toproyectos(proyectosDTO proyectosDTO) {
        if ( proyectosDTO == null ) {
            return null;
        }

        proyectos proyectos = new proyectos();

        proyectos.setIdproyecto( proyectosDTO.getIdproyecto() );
        proyectos.setNombre( proyectosDTO.getNombre() );
        proyectos.setDescripcion( proyectosDTO.getDescripcion() );
        proyectos.setAdmin( proyectosDTO.getAdmin() );

        return proyectos;
    }

    @Override
    public List<proyectosDTO> toproyectosDTOs(List<proyectos> proyectoss) {
        if ( proyectoss == null ) {
            return null;
        }

        List<proyectosDTO> list = new ArrayList<proyectosDTO>( proyectoss.size() );
        for ( proyectos proyectos : proyectoss ) {
            list.add( toproyectosDTO( proyectos ) );
        }

        return list;
    }

    @Override
    public List<proyectos> toproyectos(List<proyectosDTO> proyectosDTOs) {
        if ( proyectosDTOs == null ) {
            return null;
        }

        List<proyectos> list = new ArrayList<proyectos>( proyectosDTOs.size() );
        for ( proyectosDTO proyectosDTO : proyectosDTOs ) {
            list.add( toproyectos( proyectosDTO ) );
        }

        return list;
    }
}
