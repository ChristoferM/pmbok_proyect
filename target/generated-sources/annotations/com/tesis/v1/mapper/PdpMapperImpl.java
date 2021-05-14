package com.tesis.v1.mapper;

import com.tesis.v1.domain.pdp.pdp;
import com.tesis.v1.dto.pdp.PdpDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class PdpMapperImpl implements PdpMapper {

    @Override
    public PdpDTO toPdpDTO(pdp pdps) {
        if ( pdps == null ) {
            return null;
        }

        PdpDTO pdpDTO = new PdpDTO();

        pdpDTO.setIdpdp( pdps.getIdpdp() );

        return pdpDTO;
    }

    @Override
    public pdp toPdp(PdpDTO pdpDTO) {
        if ( pdpDTO == null ) {
            return null;
        }

        pdp pdp = new pdp();

        pdp.setIdpdp( pdpDTO.getIdpdp() );

        return pdp;
    }

    @Override
    public List<PdpDTO> toPdpDTOs(List<pdp> pdps) {
        if ( pdps == null ) {
            return null;
        }

        List<PdpDTO> list = new ArrayList<PdpDTO>( pdps.size() );
        for ( pdp pdp : pdps ) {
            list.add( toPdpDTO( pdp ) );
        }

        return list;
    }

    @Override
    public List<pdp> toPdps(List<PdpDTO> pdpDTOs) {
        if ( pdpDTOs == null ) {
            return null;
        }

        List<pdp> list = new ArrayList<pdp>( pdpDTOs.size() );
        for ( PdpDTO pdpDTO : pdpDTOs ) {
            list.add( toPdp( pdpDTO ) );
        }

        return list;
    }
}
