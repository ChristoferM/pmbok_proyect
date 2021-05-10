package com.tesis.v1.mapper;

import com.tesis.v1.domain.pdp.entradas;
import com.tesis.v1.dto.pdp.entradasDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.3.1300.v20210331-0708, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class pdpEntradasMapperImpl implements pdpEntradasMapper {

    @Override
    public entradasDTO toEntradasPdpDTO(entradas entradaPdp) {
        if ( entradaPdp == null ) {
            return null;
        }

        entradasDTO entradasDTO = new entradasDTO();

        entradasDTO.setIdentradapdp( entradaPdp.getIdentradapdp() );
        entradasDTO.setOtrosprocesos( entradaPdp.getOtrosprocesos() );
        entradasDTO.setFactoresambientales( entradaPdp.getFactoresambientales() );
        entradasDTO.setActivosprocesos( entradaPdp.getActivosprocesos() );

        return entradasDTO;
    }

    @Override
    public entradas toEntradaPdp(entradasDTO entradasDTO) {
        if ( entradasDTO == null ) {
            return null;
        }

        entradas entradas = new entradas();

        entradas.setIdentradapdp( entradasDTO.getIdentradapdp() );
        entradas.setOtrosprocesos( entradasDTO.getOtrosprocesos() );
        entradas.setFactoresambientales( entradasDTO.getFactoresambientales() );
        entradas.setActivosprocesos( entradasDTO.getActivosprocesos() );

        return entradas;
    }

    @Override
    public List<entradasDTO> toEntradadpDTO(List<entradas> entradaPdps) {
        if ( entradaPdps == null ) {
            return null;
        }

        List<entradasDTO> list = new ArrayList<entradasDTO>( entradaPdps.size() );
        for ( entradas entradas : entradaPdps ) {
            list.add( toEntradasPdpDTO( entradas ) );
        }

        return list;
    }

    @Override
    public List<entradas> toEntradadp(List<entradasDTO> entradasDTOs) {
        if ( entradasDTOs == null ) {
            return null;
        }

        List<entradas> list = new ArrayList<entradas>( entradasDTOs.size() );
        for ( entradasDTO entradasDTO : entradasDTOs ) {
            list.add( toEntradaPdp( entradasDTO ) );
        }

        return list;
    }
}
