package com.tesis.v1.mapper;

import org.mapstruct.Mapper;
import java.util.List;
import com.tesis.v1.domain.RolProyecto;
import com.tesis.v1.dto.RolproyectoDTO;

@Mapper
public interface RolProyectoMapper {

    public RolproyectoDTO torolProyectoDTO(RolProyecto rolProyecto);

    public RolProyecto torolProyecto(RolproyectoDTO rolProyectoDTO);

    public List<RolproyectoDTO> torolProyectoDTOs(List<RolProyecto> rolProyectos);

    public List<RolproyectoDTO> torolProyectos(List<RolproyectoDTO> rolProyectoDTOs);

}
