package com.tesis.v1.mapper;

import java.util.List;
import org.mapstruct.Mapper;

import com.tesis.v1.domain.reuniones;
import com.tesis.v1.dto.reunionesDTO;

@Mapper
public interface  reunionesMapper {
	
	public reunionesDTO toReunionDTO(reuniones  reuniones);
	
	public  reuniones toReunionDTO(reunionesDTO reunionesDTO );
	
	public List<reunionesDTO> toReunionDTOs(List<reuniones> reunioness );
	
	public List<reuniones> toReunions(List<reunionesDTO> reunionesDTOs);
}
