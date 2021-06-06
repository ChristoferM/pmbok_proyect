package com.tesis.v1.mapper;

import com.tesis.v1.domain.pdp.Pdp;
import com.tesis.v1.dto.pdp.PdpDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 15 (Oracle Corporation)"
)
@Component
public class PdpMapperImpl implements PdpMapper {

    @Override
    public PdpDTO toPdpDTO(Pdp pdps) {
        if ( pdps == null ) {
            return null;
        }

        PdpDTO pdpDTO = new PdpDTO();

        pdpDTO.setIdpdp( pdps.getIdpdp() );

        return pdpDTO;
    }

    @Override
    public Pdp toPdp(PdpDTO pdpDTO) {
        if ( pdpDTO == null ) {
            return null;
        }

        Pdp pdp = new Pdp();

        pdp.setIdpdp( pdpDTO.getIdpdp() );

        return pdp;
    }

    @Override
    public List<PdpDTO> toPdpDTOs(List<Pdp> pdps) {
        if ( pdps == null ) {
            return null;
        }

        List<PdpDTO> list = new ArrayList<PdpDTO>( pdps.size() );
        for ( Pdp pdp : pdps ) {
            list.add( toPdpDTO( pdp ) );
        }

        return list;
    }

    @Override
    public List<Pdp> toPdps(List<PdpDTO> pdpDTOs) {
        if ( pdpDTOs == null ) {
            return null;
        }

        List<Pdp> list = new ArrayList<Pdp>( pdpDTOs.size() );
        for ( PdpDTO pdpDTO : pdpDTOs ) {
            list.add( toPdp( pdpDTO ) );
        }

        return list;
    }
}
