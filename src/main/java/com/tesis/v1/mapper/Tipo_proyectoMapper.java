package com.tesis.v1.mapper;

import com.tesis.v1.domain.Tipo_proyecto;
import com.tesis.v1.dto.tipo_proyectoDTO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author david
 */

@Mapper
public interface Tipo_proyectoMapper {
    
    
    public tipo_proyectoDTO toTipo_proyectoDTO(Tipo_proyecto tipo_proyecto);

    public Tipo_proyecto  toTipo_proyecto(tipo_proyectoDTO tipo_proyectoDTO);

    public List<tipo_proyectoDTO> toTipo_proyectosDTOs(List<Tipo_proyecto> tipo_proyectos );

    public List<Tipo_proyecto> toTipo_proyectos(List<tipo_proyectoDTO> tipo_proyectoDTOs);
        
    
}
