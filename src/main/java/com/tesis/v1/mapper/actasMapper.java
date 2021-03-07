package com.tesis.v1.mapper;

import org.mapstruct.Mapper;

import java.util.List;
import com.tesis.v1.domain.actas;
import com.tesis.v1.dto.actasDTO;

@Mapper
public interface actasMapper {
	
	public actasDTO toActasDTO(actas actas);
	
	public actas toActas(actasDTO actasDto);
	
	public List<actasDTO> toActasDTO(List<actas> actas);
	
	public List<actas> toActas(List<actasDTO> actasDTOs);

	/*
	public  toDTO( );
	
	public  to( );
	
	public List<> toDTO(List<> );
	
	public List<> to(List<> );
	
	*/

}
