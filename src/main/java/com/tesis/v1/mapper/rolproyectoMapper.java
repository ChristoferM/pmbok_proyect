package com.tesis.v1.mapper;

import org.mapstruct.Mapper;
import java.util.List;
import com.tesis.v1.domain.rolproyecto;
import com.tesis.v1.dto.rolproyectoDTO;

@Mapper
public interface rolproyectoMapper {
	
	public  rolproyectoDTO torolProyectoDTO(rolproyecto  rolProyecto);
	
	public  rolproyecto torolProyecto( rolproyectoDTO rolProyectoDTO);
	
	public  List<rolproyectoDTO> torolProyectoDTOs(List<rolproyecto> rolProyectos);
	
	public List<rolproyectoDTO> torolProyectos(List<rolproyectoDTO>  rolProyectoDTOs);
	
}
