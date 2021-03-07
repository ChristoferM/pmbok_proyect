package com.tesis.v1.mapper;

import java.util.List;

import org.mapstruct.Mapper;


import com.tesis.v1.domain.entradacta;
import com.tesis.v1.dto.entradactaDTO;

@Mapper
public interface entradactaMapper {
public entradactaDTO toEntradActaDTO( entradacta entradActa );
	
	public entradacta toEntradActa(entradactaDTO entradActaDTO);
	
	public List<entradactaDTO> toEntradActaDTO(List<entradacta >entradActa );
	
	public List<entradacta> toEntradActa(List<entradactaDTO> entradActaDTOs );
}
