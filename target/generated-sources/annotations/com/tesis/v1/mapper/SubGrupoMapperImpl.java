package com.tesis.v1.mapper;

import com.tesis.v1.domain.SubGrupo;
import com.tesis.v1.dto.SubGrupoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.2 (Eclipse Adoptium)"
)
@Component
public class SubGrupoMapperImpl implements SubGrupoMapper {

    @Override
    public SubGrupoDTO tosubGrupoDTO(SubGrupo subGrupo) {
        if ( subGrupo == null ) {
            return null;
        }

        SubGrupoDTO subGrupoDTO = new SubGrupoDTO();

        subGrupoDTO.setId_sub_grupo( subGrupo.getId_sub_grupo() );
        subGrupoDTO.setEstado( subGrupo.getEstado() );

        return subGrupoDTO;
    }

    @Override
    public SubGrupo tosubGrupo(SubGrupoDTO subGrupoDTO) {
        if ( subGrupoDTO == null ) {
            return null;
        }

        SubGrupo subGrupo = new SubGrupo();

        subGrupo.setId_sub_grupo( subGrupoDTO.getId_sub_grupo() );
        subGrupo.setEstado( subGrupoDTO.getEstado() );

        return subGrupo;
    }

    @Override
    public List<SubGrupoDTO> tosubGrupoDTOs(List<SubGrupo> subGrupos) {
        if ( subGrupos == null ) {
            return null;
        }

        List<SubGrupoDTO> list = new ArrayList<SubGrupoDTO>( subGrupos.size() );
        for ( SubGrupo subGrupo : subGrupos ) {
            list.add( tosubGrupoDTO( subGrupo ) );
        }

        return list;
    }

    @Override
    public List<SubGrupo> tosubGrupos(List<SubGrupoDTO> subGrupoDTOs) {
        if ( subGrupoDTOs == null ) {
            return null;
        }

        List<SubGrupo> list = new ArrayList<SubGrupo>( subGrupoDTOs.size() );
        for ( SubGrupoDTO subGrupoDTO : subGrupoDTOs ) {
            list.add( tosubGrupo( subGrupoDTO ) );
        }

        return list;
    }
}
