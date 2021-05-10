package com.tesis.v1.mapper;

import com.tesis.v1.domain.proyectos;
import com.tesis.v1.domain.tipo_proyecto;
import com.tesis.v1.dto.proyectosDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.3.1300.v20210331-0708, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class proyectosMapperImpl implements proyectosMapper {

    @Override
    public proyectosDTO toproyectosDTO(proyectos proyectos) {
        if ( proyectos == null ) {
            return null;
        }

        proyectosDTO proyectosDTO = new proyectosDTO();

        proyectosDTO.setTipo_id( proyectosTipoProyectoTipo_id( proyectos ) );
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

        proyectos.setTipoProyecto( proyectosDTOTotipo_proyecto( proyectosDTO ) );
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

    private String proyectosTipoProyectoTipo_id(proyectos proyectos) {
        if ( proyectos == null ) {
            return null;
        }
        tipo_proyecto tipoProyecto = proyectos.getTipoProyecto();
        if ( tipoProyecto == null ) {
            return null;
        }
        String tipo_id = tipoProyecto.getTipo_id();
        if ( tipo_id == null ) {
            return null;
        }
        return tipo_id;
    }

    protected tipo_proyecto proyectosDTOTotipo_proyecto(proyectosDTO proyectosDTO) {
        if ( proyectosDTO == null ) {
            return null;
        }

        tipo_proyecto tipo_proyecto = new tipo_proyecto();

        tipo_proyecto.setTipo_id( proyectosDTO.getTipo_id() );

        return tipo_proyecto;
    }
}
