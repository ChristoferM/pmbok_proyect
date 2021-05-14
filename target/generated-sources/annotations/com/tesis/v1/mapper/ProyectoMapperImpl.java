package com.tesis.v1.mapper;

import com.tesis.v1.domain.Proyecto;
import com.tesis.v1.domain.Tipo_proyecto;
import com.tesis.v1.dto.ProyectoDTO;
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
    public ProyectoDTO toproyectosDTO(Proyecto proyectos) {
        if ( proyectos == null ) {
            return null;
        }

        ProyectoDTO proyectoDTO = new ProyectoDTO();

        proyectoDTO.setTipo_id( proyectosTipoProyectoTipo_id( proyectos ) );
        proyectoDTO.setAdmin( proyectos.getAdmin() );
        proyectoDTO.setIdproyecto( proyectos.getIdproyecto() );
        proyectoDTO.setNombre( proyectos.getNombre() );
        proyectoDTO.setDescripcion( proyectos.getDescripcion() );

        return proyectoDTO;
    }

    @Override
    public Proyecto toproyectos(ProyectoDTO proyectosDTO) {
        if ( proyectosDTO == null ) {
            return null;
        }

        Proyecto proyecto = new Proyecto();

        proyecto.setTipoProyecto( proyectoDTOToTipo_proyecto( proyectosDTO ) );
        proyecto.setIdproyecto( proyectosDTO.getIdproyecto() );
        proyecto.setNombre( proyectosDTO.getNombre() );
        proyecto.setDescripcion( proyectosDTO.getDescripcion() );
        proyecto.setAdmin( proyectosDTO.getAdmin() );

        return proyecto;
    }

    @Override
    public List<ProyectoDTO> toproyectosDTOs(List<Proyecto> proyectoss) {
        if ( proyectoss == null ) {
            return null;
        }

        List<ProyectoDTO> list = new ArrayList<ProyectoDTO>( proyectoss.size() );
        for ( Proyecto proyecto : proyectoss ) {
            list.add( toproyectosDTO( proyecto ) );
        }

        return list;
    }

    @Override
    public List<Proyecto> toproyectos(List<ProyectoDTO> proyectosDTOs) {
        if ( proyectosDTOs == null ) {
            return null;
        }

        List<Proyecto> list = new ArrayList<Proyecto>( proyectosDTOs.size() );
        for ( ProyectoDTO proyectoDTO : proyectosDTOs ) {
            list.add( toproyectos( proyectoDTO ) );
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

    protected Tipo_proyecto proyectoDTOToTipo_proyecto(ProyectoDTO proyectoDTO) {
        if ( proyectoDTO == null ) {
            return null;
        }

        Tipo_proyecto tipo_proyecto = new Tipo_proyecto();

        tipo_proyecto.setTipo_id( proyectoDTO.getTipo_id() );

        return tipo_proyecto;
    }
}
