package com.tesis.v1.mapper;
import org.mapstruct.Mapper;

import java.util.List;
import com.tesis.v1.domain.proyectos;
import com.tesis.v1.dto.proyectosDTO;

@Mapper
public interface proyectosMapper {

	
	public proyectosDTO toproyectosDTO(proyectos  proyectos );
	
	public  proyectos toproyectos(proyectosDTO proyectosDTO );
	
	public List<proyectosDTO> toproyectosDTOs(List<proyectos> proyectoss );
	
	public List<proyectos> toproyectos(List<proyectosDTO >  proyectosDTOs);
	
}
