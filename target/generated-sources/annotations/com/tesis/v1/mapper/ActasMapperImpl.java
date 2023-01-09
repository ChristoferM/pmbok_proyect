package com.tesis.v1.mapper;

import com.tesis.v1.domain.Acta;
import com.tesis.v1.dto.ActasDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.4.300.v20221108-0856, environment: Java 17.0.5 (Eclipse Adoptium)"
)
@Component
public class ActasMapperImpl implements ActasMapper {

    @Override
    public ActasDTO toActasDTO(Acta actas) {
        if ( actas == null ) {
            return null;
        }

        ActasDTO actasDTO = new ActasDTO();

        actasDTO.setIdactas( actas.getIdactas() );

        return actasDTO;
    }

    @Override
    public Acta toActas(ActasDTO actasDto) {
        if ( actasDto == null ) {
            return null;
        }

        Acta acta = new Acta();

        acta.setIdactas( actasDto.getIdactas() );

        return acta;
    }

    @Override
    public List<ActasDTO> toActasDTO(List<Acta> actas) {
        if ( actas == null ) {
            return null;
        }

        List<ActasDTO> list = new ArrayList<ActasDTO>( actas.size() );
        for ( Acta acta : actas ) {
            list.add( toActasDTO( acta ) );
        }

        return list;
    }

    @Override
    public List<Acta> toActas(List<ActasDTO> actasDTOs) {
        if ( actasDTOs == null ) {
            return null;
        }

        List<Acta> list = new ArrayList<Acta>( actasDTOs.size() );
        for ( ActasDTO actasDTO : actasDTOs ) {
            list.add( toActas( actasDTO ) );
        }

        return list;
    }
}
