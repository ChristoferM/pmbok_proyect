package com.tesis.v1.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.tesis.v1.domain.pdp.Herramientas;
import com.tesis.v1.dto.pdp.HerramientasDTO;

@Mapper
public interface pdpHerramientasMapper {

	public  HerramientasDTO toherramienta(Herramientas herramientas );
	
	public Herramientas  toHerramientaDTO( HerramientasDTO herramientasPdpDTO);
	
	public List<Herramientas> toHerramientasDTO(List<Herramientas> herramientasPdp );
	
	public List<Herramientas> toHerramientas(List<HerramientasDTO>  herramientasDTOs);
}
