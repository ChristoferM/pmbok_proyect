package com.tesis.v1.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.tesis.v1.domain.pga.herramientaspga;
import com.tesis.v1.dto.pga.*;

@Mapper
public interface pgaherramientasMapper {
	
	public herramientaspga toHerramientaPGADTO(com.tesis.v1.dto.pga.herramientaspga herramientaspgaDTO);
	
	public com.tesis.v1.dto.pga.herramientaspga toHerramientaPGA(herramientaspga herramientaspga );
	
	public List<com.tesis.v1.dto.pga.herramientaspga> toHerramientasPGADTOs(List<herramientaspga> herramientaspgas );
	
	public List<herramientaspga> toHeramientasPGA(List<com.tesis.v1.dto.pga.herramientaspga> herramientaspgaDTOs);
	
	

}
