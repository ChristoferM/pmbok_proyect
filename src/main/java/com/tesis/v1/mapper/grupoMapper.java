package com.tesis.v1.mapper;


import java.util.List;

import org.mapstruct.Mapper;
import com.tesis.v1.domain.grupo;
import com.tesis.v1.dto.grupoDTO;


@Mapper
public interface grupoMapper {

public grupoDTO togrupoDTO( grupo grupo);
	
	public grupo  togrupo(grupoDTO grupoDTO );
	
	public List<grupoDTO> togrupoDTO(List<grupo> grupo );
	
	public List<grupo> togrupo(List<grupoDTO>  grupoDTOs);
}
