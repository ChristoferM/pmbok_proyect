package com.tesis.v1.mapper;

import java.util.List;

import org.mapstruct.Mapper;


import com.tesis.v1.domain.Herramientasacta;
import com.tesis.v1.dto.HerramientasActaDTO;

@Mapper
public interface HerramientasactaMapper {
	
	public HerramientasActaDTO toherramientasActaDTO( Herramientasacta herramientasActa);
	
	public Herramientasacta  toherramientasActa( HerramientasActaDTO herramientasActaDTO );
	
	public List<HerramientasActaDTO> toherramientasActa(List<Herramientasacta > herramientasActas);
	
	public List<Herramientasacta> toherramientasActaDTO(List<HerramientasActaDTO > herramientasActaDTOs);
}
