package com.tesis.v1.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.tesis.v1.domain.pdp.herramientas;
import com.tesis.v1.dto.pdp.herramientasDTO;

@Mapper
public interface pdpHerramientasMapper {

	public  herramientasDTO toherramientaDTO(herramientas herramientasDTO );
	
	public herramientas  toHerramientaDTO( herramientasDTO herramientasPdpDTO);
	
	public List<herramientas> toHerramientasDTO(List<herramientas> herramientasPdp );
	
	public List<herramientas> toHerramientas(List<herramientasDTO>  herramientasDTOs);
}
