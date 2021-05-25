package com.tesis.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import com.tesis.v1.domain.Proyecto;
import com.tesis.v1.dto.ProyectoDTO;

@Mapper
public interface ProyectoMapper {

    @Mapping(source = "tipoProyecto.tipo_id", target = "tipo_id")
    public ProyectoDTO toproyectosDTO(Proyecto proyectos);

    @Mapping(source = "tipo_id", target = "tipoProyecto.tipo_id")
    public Proyecto toproyectos(ProyectoDTO proyectosDTO);

    public List<ProyectoDTO> toproyectosDTOs(List<Proyecto> proyectoss);

    public List<Proyecto> toproyectos(List<ProyectoDTO> proyectosDTOs);

}
