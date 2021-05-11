package com.tesis.v1.mapper;

import com.tesis.v1.domain.actas;
import com.tesis.v1.dto.actasDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.3.1300.v20210331-0708, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class actasMapperImpl implements actasMapper {

    @Override
    public actasDTO toActasDTO(actas actas) {
        if ( actas == null ) {
            return null;
        }

        actasDTO actasDTO = new actasDTO();

        actasDTO.setIdactas( actas.getIdactas() );

        return actasDTO;
    }

    @Override
    public actas toActas(actasDTO actasDto) {
        if ( actasDto == null ) {
            return null;
        }

        actas actas = new actas();

        actas.setIdactas( actasDto.getIdactas() );

        return actas;
    }

    @Override
    public List<actasDTO> toActasDTO(List<actas> actas) {
        if ( actas == null ) {
            return null;
        }

        List<actasDTO> list = new ArrayList<actasDTO>( actas.size() );
        for ( actas actas1 : actas ) {
            list.add( toActasDTO( actas1 ) );
        }

        return list;
    }

    @Override
    public List<actas> toActas(List<actasDTO> actasDTOs) {
        if ( actasDTOs == null ) {
            return null;
        }

        List<actas> list = new ArrayList<actas>( actasDTOs.size() );
        for ( actasDTO actasDTO : actasDTOs ) {
            list.add( toActas( actasDTO ) );
        }

        return list;
    }
}
