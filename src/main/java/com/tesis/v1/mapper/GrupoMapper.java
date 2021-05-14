package com.tesis.v1.mapper;


import java.util.List;

import org.mapstruct.Mapper;
import com.tesis.v1.domain.Grupo;
import com.tesis.v1.dto.GrupoDTO;


@Mapper
public interface GrupoMapper {

public GrupoDTO togrupoDTO( Grupo grupo);
	
	public Grupo  togrupo(GrupoDTO grupoDTO );
	
	public List<GrupoDTO> togrupoDTO(List<Grupo> grupo );
	
	public List<Grupo> togrupo(List<GrupoDTO>  grupoDTOs);
}
