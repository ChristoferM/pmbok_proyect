package com.tesis.v1.mapper;

import java.util.List;

import org.mapstruct.Mapper;


import com.tesis.v1.domain.herramientasacta;
import com.tesis.v1.dto.herramientasactaDTO;

@Mapper
public interface herramientasactaMapper {
	
	public herramientasactaDTO toherramientasActaDTO( herramientasacta herramientasActa);
	
	public herramientasacta  toherramientasActa( herramientasactaDTO herramientasActaDTO );
	
	public List<herramientasactaDTO> toherramientasActa(List<herramientasacta > herramientasActas);
	
	public List<herramientasacta> toherramientasActaDTO(List<herramientasactaDTO > herramientasActaDTOs);
}
