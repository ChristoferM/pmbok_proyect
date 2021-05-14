package com.tesis.v1.mapper;

import com.tesis.v1.domain.Proyecto;
import com.tesis.v1.domain.Tipo_proyecto;
import com.tesis.v1.dto.proyectosDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class ProyectoMapperImpl implements ProyectoMapper {

    @Override
    public proyectosDTO toproyectosDTO(Proyecto proyectos) {
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
    public Proyecto toproyectos(proyectosDTO proyectosDTO) {
        if ( proyectosDTO == null ) {
            return null;
        }

        Proyecto proyecto = new Proyecto();

        proyecto.setTipoProyecto( proyectosDTOToTipo_proyecto( proyectosDTO ) );
        proyecto.setIdproyecto( proyectosDTO.getIdproyecto() );
        proyecto.setNombre( proyectosDTO.getNombre() );
        proyecto.setDescripcion( proyectosDTO.getDescripcion() );
        proyecto.setAdmin( proyectosDTO.getAdmin() );

        return proyecto;
    }

    @Override
    public List<proyectosDTO> toproyectosDTOs(List<Proyecto> proyectoss) {
        if ( proyectoss == null ) {
            return null;
        }

        List<proyectosDTO> list = new ArrayList<proyectosDTO>( proyectoss.size() );
        for ( Proyecto proyecto : proyectoss ) {
            list.add( toproyectosDTO( proyecto ) );
        }

        return list;
    }

    @Override
    public List<Proyecto> toproyectos(List<proyectosDTO> proyectosDTOs) {
        if ( proyectosDTOs == null ) {
            return null;
        }

        List<Proyecto> list = new ArrayList<Proyecto>( proyectosDTOs.size() );
        for ( proyectosDTO proyectosDTO : proyectosDTOs ) {
            list.add( toproyectos( proyectosDTO ) );
        }

        return list;
    }

    private String proyectosTipoProyectoTipo_id(Proyecto proyecto) {
        if ( proyecto == null ) {
            return null;
        }
        Tipo_proyecto tipoProyecto = proyecto.getTipoProyecto();
        if ( tipoProyecto == null ) {
            return null;
        }
        String tipo_id = tipoProyecto.getTipo_id();
        if ( tipo_id == null ) {
            return null;
        }
        return tipo_id;
    }

    protected Tipo_proyecto proyectosDTOToTipo_proyecto(proyectosDTO proyectosDTO) {
        if ( proyectosDTO == null ) {
            return null;
        }

        Tipo_proyecto tipo_proyecto = new Tipo_proyecto();

        tipo_proyecto.setTipo_id( proyectosDTO.getTipo_id() );

        return tipo_proyecto;
    }
}
