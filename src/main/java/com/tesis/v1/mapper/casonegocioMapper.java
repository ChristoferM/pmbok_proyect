package com.tesis.v1.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.tesis.v1.domain.casonegocio;
import com.tesis.v1.dto.casonegocioDTO;

@Mapper
public interface casonegocioMapper {
public  casonegocioDTO tocasoNegocioDTO( casonegocio casoNegocio );
	
	public casonegocio tocasoNegocio(casonegocioDTO casoNegocioDTO );
	
	public List<casonegocioDTO> tocasoNegocioDTO(List<casonegocio > casoNegocio );
	
	public List<casonegocio> tocasoNegocio(List<casonegocioDTO> casonegocioDTOs );
}
