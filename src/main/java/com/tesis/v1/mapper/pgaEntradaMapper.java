package com.tesis.v1.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.tesis.v1.domain.pga.pga;
import com.tesis.v1.dto.pga.entradapgaDTO;
import com.tesis.v1.dto.pga.pgaDTO;
import com.tesis.v1.domain.pga.entradapga;

@Mapper
public interface pgaEntradaMapper {
	
	public entradapgaDTO toHerramientasPGADTO(entradapga entradapga );
	
	public  entradapga toHerramientasPGA(entradapgaDTO entradapgaDTO );
	
	public List<entradapgaDTO> toHerramientasPGADTOs(List<entradapga > entradapgas);
	
	public List<entradapga> toHerramientasPGA(List<entradapgaDTO> entradapgaDTOs );
	
	

}
