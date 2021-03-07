package com.tesis.v1.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.tesis.v1.domain.faseproyecto;
import com.tesis.v1.dto.faseproyectoDTO;

@Mapper
public interface faseproyectoMapper {
	
public faseproyectoDTO tofaseProyectoDTO( faseproyecto faseProyecto);
	
	public faseproyecto tofaseProyecto(faseproyectoDTO faseproyectoDTO);
	
	public List<faseproyectoDTO> tofaseProyectoDTO(List<faseproyecto> faseProyectos );
	
	public List<faseproyecto> tofaseProyecto(List<faseproyectoDTO> faseProyectoDTOs );


}
