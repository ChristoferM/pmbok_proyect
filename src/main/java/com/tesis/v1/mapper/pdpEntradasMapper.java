package com.tesis.v1.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.tesis.v1.domain.pdp.entradas;
import com.tesis.v1.dto.pdp.entradasDTO;

@Mapper
public interface pdpEntradasMapper {
	public entradasDTO toEntradasPdpDTO(entradas entradaPdp );
	
	public entradas toEntradaPdp(entradasDTO entradasDTO );
	
	public List<entradasDTO> toEntradadpDTO(List<entradas>  entradaPdps);
	
	public List<entradas> toEntradadp(List<entradasDTO> entradasDTOs );
}
