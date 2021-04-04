package com.tesis.v1.mapper;

import com.tesis.v1.domain.grupo;
import com.tesis.v1.dto.grupoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 15 (Oracle Corporation)"
)
@Component
public class grupoMapperImpl implements grupoMapper {

    @Override
    public grupoDTO togrupoDTO(grupo grupo) {
        if ( grupo == null ) {
            return null;
        }

        grupoDTO grupoDTO = new grupoDTO();

        grupoDTO.setIdgrupo( grupo.getIdgrupo() );

        return grupoDTO;
    }

    @Override
    public grupo togrupo(grupoDTO grupoDTO) {
        if ( grupoDTO == null ) {
            return null;
        }

        grupo grupo = new grupo();

        grupo.setIdgrupo( grupoDTO.getIdgrupo() );

        return grupo;
    }

    @Override
    public List<grupoDTO> togrupoDTO(List<grupo> grupo) {
        if ( grupo == null ) {
            return null;
        }

        List<grupoDTO> list = new ArrayList<grupoDTO>( grupo.size() );
        for ( grupo grupo1 : grupo ) {
            list.add( togrupoDTO( grupo1 ) );
        }

        return list;
    }

    @Override
    public List<grupo> togrupo(List<grupoDTO> grupoDTOs) {
        if ( grupoDTOs == null ) {
            return null;
        }

        List<grupo> list = new ArrayList<grupo>( grupoDTOs.size() );
        for ( grupoDTO grupoDTO : grupoDTOs ) {
            list.add( togrupo( grupoDTO ) );
        }

        return list;
    }
}