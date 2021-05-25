package com.tesis.v1.mapper;

import org.mapstruct.Mapper;

import com.tesis.v1.domain.SubGrupo;
import com.tesis.v1.dto.SubGrupoDTO;

import java.util.List;

@Mapper
public interface SubGrupoMapper {

    public SubGrupoDTO tosubGrupoDTO(SubGrupo subGrupo);

    public SubGrupo tosubGrupo(SubGrupoDTO subGrupoDTO);

    public List<SubGrupoDTO> tosubGrupoDTOs(List<SubGrupo> subGrupos);

    public List<SubGrupo> tosubGrupos(List<SubGrupoDTO> subGrupoDTOs);

}
