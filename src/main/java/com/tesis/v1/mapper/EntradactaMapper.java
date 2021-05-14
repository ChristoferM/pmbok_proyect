package com.tesis.v1.mapper;

import java.util.List;

import org.mapstruct.Mapper;


import com.tesis.v1.domain.Entradacta;
import com.tesis.v1.dto.EntradactaDTO;

@Mapper
public interface EntradactaMapper {
public EntradactaDTO toEntradActaDTO( Entradacta entradActa );
	
	public Entradacta toEntradActa(EntradactaDTO entradActaDTO);
	
	public List<EntradactaDTO> toEntradActaDTO(List<Entradacta >entradActa );
	
	public List<Entradacta> toEntradActa(List<EntradactaDTO> entradActaDTOs );
}
