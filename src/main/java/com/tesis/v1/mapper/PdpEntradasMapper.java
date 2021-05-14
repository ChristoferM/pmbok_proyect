package com.tesis.v1.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.tesis.v1.domain.pdp.Entradas;
import com.tesis.v1.dto.pdp.EntradasDTO;

@Mapper
public interface PdpEntradasMapper {
	public EntradasDTO toEntradasPdpDTO(Entradas entradaPdp );
	
	public Entradas toEntradaPdp(EntradasDTO entradasDTO );
	
	public List<EntradasDTO> toEntradadpDTO(List<Entradas>  entradaPdps);
	
	public List<Entradas> toEntradadp(List<EntradasDTO> entradasDTOs );
}
