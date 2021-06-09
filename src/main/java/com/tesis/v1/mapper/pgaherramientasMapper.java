package com.tesis.v1.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.tesis.v1.domain.pga.herramientaspga;
import com.tesis.v1.dto.pga.*;


@Mapper
public interface pgaherramientasMapper {
	
	public herramientaspgaDTO toHerramientaPGADTO(herramientaspga herramientaspga);
	
	public  herramientaspga toHerramientaPGA(herramientaspgaDTO herramientaspga );
	
	public List<herramientaspgaDTO> toHerramientasPGADTOs(List<herramientaspga> herramientaspgas );
	
	public List<herramientaspga> toHeramientasPGA(List<herramientaspgaDTO> herramientaspgaDTOs);
	
	

}
 
