package com.tesis.v1.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.tesis.v1.domain.CasoNegocio;
import com.tesis.v1.dto.CasoNegocioDTO;

@Mapper
public interface CasoNegocioMapper {

    public CasoNegocioDTO tocasoNegocioDTO(CasoNegocio casoNegocio);

    public CasoNegocio tocasoNegocio(CasoNegocioDTO casoNegocioDTO);

    public List<CasoNegocioDTO> tocasoNegocioDTO(List<CasoNegocio> casoNegocio);

    public List<CasoNegocio> tocasoNegocio(List<CasoNegocioDTO> casonegocioDTOs);
}
