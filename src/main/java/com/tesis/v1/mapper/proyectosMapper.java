package com.tesis.v1.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import com.tesis.v1.domain.proyectos;
import com.tesis.v1.dto.proyectosDTO;

@Mapper
public interface proyectosMapper {

	@Mapping(source = "tipoProyecto.tipo_id", target = "tipo_id")
	public proyectosDTO toproyectosDTO(proyectos  proyectos );
	
	@Mapping(source = "tipo_id", target = "tipoProyecto.tipo_id")
	public  proyectos toproyectos(proyectosDTO proyectosDTO );
	
	public List<proyectosDTO> toproyectosDTOs(List<proyectos> proyectoss );
	
	public List<proyectos> toproyectos(List<proyectosDTO >  proyectosDTOs);
	
}
