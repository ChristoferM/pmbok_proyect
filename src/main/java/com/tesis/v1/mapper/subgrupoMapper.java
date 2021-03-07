package com.tesis.v1.mapper;

import org.mapstruct.Mapper;

import com.tesis.v1.domain.subgrupo;
import com.tesis.v1.dto.subgrupoDTO;

import java.util.List;
@Mapper
public interface subgrupoMapper {
	
	public subgrupoDTO tosubGrupoDTO(subgrupo  subGrupo);
	
	public  subgrupo tosubGrupo(subgrupoDTO subGrupoDTO );
	
	public List<subgrupoDTO> tosubGrupoDTOs(List<subgrupo> subGrupos );
	
	public List<subgrupo> tosubGrupos(List<subgrupoDTO> subGrupoDTOs );

}
