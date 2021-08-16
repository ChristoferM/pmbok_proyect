package com.tesis.v1.mapper;

import com.tesis.v1.domain.Grupo;
import com.tesis.v1.dto.GrupoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 15 (Oracle Corporation)"
)
@Component
public class GrupoMapperImpl implements GrupoMapper {

    @Override
    public GrupoDTO togrupoDTO(Grupo grupo) {
        if ( grupo == null ) {
            return null;
        }

        GrupoDTO grupoDTO = new GrupoDTO();

        grupoDTO.setEstado( grupo.getEstado() );
        grupoDTO.setIdgrupo( grupo.getIdgrupo() );

        return grupoDTO;
    }

    @Override
    public Grupo togrupo(GrupoDTO grupoDTO) {
        if ( grupoDTO == null ) {
            return null;
        }

        Grupo grupo = new Grupo();

        grupo.setEstado( grupoDTO.getEstado() );
        grupo.setIdgrupo( grupoDTO.getIdgrupo() );

        return grupo;
    }

    @Override
    public List<GrupoDTO> togrupoDTO(List<Grupo> grupo) {
        if ( grupo == null ) {
            return null;
        }

        List<GrupoDTO> list = new ArrayList<GrupoDTO>( grupo.size() );
        for ( Grupo grupo1 : grupo ) {
            list.add( togrupoDTO( grupo1 ) );
        }

        return list;
    }

    @Override
    public List<Grupo> togrupo(List<GrupoDTO> grupoDTOs) {
        if ( grupoDTOs == null ) {
            return null;
        }

        List<Grupo> list = new ArrayList<Grupo>( grupoDTOs.size() );
        for ( GrupoDTO grupoDTO : grupoDTOs ) {
            list.add( togrupo( grupoDTO ) );
        }

        return list;
    }
}
