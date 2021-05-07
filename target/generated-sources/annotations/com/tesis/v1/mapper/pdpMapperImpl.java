package com.tesis.v1.mapper;

import com.tesis.v1.domain.pdp.pdp;
import com.tesis.v1.dto.pdp.pdpDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.3.1300.v20210331-0708, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class pdpMapperImpl implements pdpMapper {

    @Override
    public pdpDTO toPdpDTO(pdp pdps) {
        if ( pdps == null ) {
            return null;
        }

        pdpDTO pdpDTO = new pdpDTO();

        pdpDTO.setIdpdp( pdps.getIdpdp() );

        return pdpDTO;
    }

    @Override
    public pdp toPdp(pdpDTO pdpDTO) {
        if ( pdpDTO == null ) {
            return null;
        }

        pdp pdp = new pdp();

        pdp.setIdpdp( pdpDTO.getIdpdp() );

        return pdp;
    }

    @Override
    public List<pdpDTO> toPdpDTOs(List<pdp> pdps) {
        if ( pdps == null ) {
            return null;
        }

        List<pdpDTO> list = new ArrayList<pdpDTO>( pdps.size() );
        for ( pdp pdp : pdps ) {
            list.add( toPdpDTO( pdp ) );
        }

        return list;
    }

    @Override
    public List<pdp> toPdps(List<pdpDTO> pdpDTOs) {
        if ( pdpDTOs == null ) {
            return null;
        }

        List<pdp> list = new ArrayList<pdp>( pdpDTOs.size() );
        for ( pdpDTO pdpDTO : pdpDTOs ) {
            list.add( toPdp( pdpDTO ) );
        }

        return list;
    }
}
