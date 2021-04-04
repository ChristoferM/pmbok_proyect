package com.tesis.v1.mapper;

import com.tesis.v1.domain.subgrupo;
import com.tesis.v1.dto.subgrupoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 15 (Oracle Corporation)"
)
@Component
public class subgrupoMapperImpl implements subgrupoMapper {

    @Override
    public subgrupoDTO tosubGrupoDTO(subgrupo subGrupo) {
        if ( subGrupo == null ) {
            return null;
        }

        subgrupoDTO subgrupoDTO = new subgrupoDTO();

        subgrupoDTO.setId_sub_grupo( subGrupo.getId_sub_grupo() );

        return subgrupoDTO;
    }

    @Override
    public subgrupo tosubGrupo(subgrupoDTO subGrupoDTO) {
        if ( subGrupoDTO == null ) {
            return null;
        }

        subgrupo subgrupo = new subgrupo();

        subgrupo.setId_sub_grupo( subGrupoDTO.getId_sub_grupo() );

        return subgrupo;
    }

    @Override
    public List<subgrupoDTO> tosubGrupoDTOs(List<subgrupo> subGrupos) {
        if ( subGrupos == null ) {
            return null;
        }

        List<subgrupoDTO> list = new ArrayList<subgrupoDTO>( subGrupos.size() );
        for ( subgrupo subgrupo : subGrupos ) {
            list.add( tosubGrupoDTO( subgrupo ) );
        }

        return list;
    }

    @Override
    public List<subgrupo> tosubGrupos(List<subgrupoDTO> subGrupoDTOs) {
        if ( subGrupoDTOs == null ) {
            return null;
        }

        List<subgrupo> list = new ArrayList<subgrupo>( subGrupoDTOs.size() );
        for ( subgrupoDTO subgrupoDTO : subGrupoDTOs ) {
            list.add( tosubGrupo( subgrupoDTO ) );
        }

        return list;
    }
}
