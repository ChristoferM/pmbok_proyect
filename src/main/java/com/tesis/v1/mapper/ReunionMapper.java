package com.tesis.v1.mapper;

import java.util.List;
import org.mapstruct.Mapper;

import com.tesis.v1.domain.Reunion;
import com.tesis.v1.dto.ReunionesDTO;

@Mapper
public interface  ReunionMapper {
	
	public ReunionesDTO toReunionDTO(Reunion  reuniones);
	
	public  Reunion toReunionDTO(ReunionesDTO reunionesDTO );
	
	public List<ReunionesDTO> toReunionDTOs(List<Reunion> reunioness );
	
	public List<Reunion> toReunions(List<ReunionesDTO> reunionesDTOs);
}
