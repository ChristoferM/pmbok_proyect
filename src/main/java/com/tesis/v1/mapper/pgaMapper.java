package com.tesis.v1.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.tesis.v1.domain.pga.pga;
import com.tesis.v1.dto.pga.pgaDTO;

@Mapper
public interface  pgaMapper {

	public pgaDTO toPgaDTO( pga pga);
	
	public  pga toPga(pgaDTO pgaDTO );
	
	public List<pgaDTO> toPaDTOs(List<pga> pgas );
	
	public List	<pga> toPgas(List<pgaDTO> pgaDTOs );
	
	

}
