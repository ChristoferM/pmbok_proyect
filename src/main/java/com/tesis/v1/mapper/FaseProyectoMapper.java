package com.tesis.v1.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.tesis.v1.domain.FaseProyecto;
import com.tesis.v1.dto.FaseProyectoDTO;

@Mapper
public interface FaseProyectoMapper {

    public FaseProyectoDTO tofaseProyectoDTO(FaseProyecto faseProyecto);

    public FaseProyecto tofaseProyecto(FaseProyectoDTO faseproyectoDTO);

    public List<FaseProyectoDTO> tofaseProyectoDTO(List<FaseProyecto> faseProyectos);

    public List<FaseProyecto> tofaseProyecto(List<FaseProyectoDTO> faseProyectoDTOs);

}
