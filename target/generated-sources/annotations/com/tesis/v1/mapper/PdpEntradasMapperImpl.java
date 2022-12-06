package com.tesis.v1.mapper;

import com.tesis.v1.domain.pdp.Entradas;
import com.tesis.v1.dto.pdp.EntradasDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.2 (Eclipse Adoptium)"
)
@Component
public class PdpEntradasMapperImpl implements PdpEntradasMapper {

    @Override
    public EntradasDTO toEntradasPdpDTO(Entradas entradaPdp) {
        if ( entradaPdp == null ) {
            return null;
        }

        EntradasDTO entradasDTO = new EntradasDTO();

        entradasDTO.setParticipa( entradaPdp.getParticipa() );
        entradasDTO.setEstado( entradaPdp.getEstado() );
        entradasDTO.setIdentradapdp( entradaPdp.getIdentradapdp() );
        entradasDTO.setOtrosprocesos( entradaPdp.getOtrosprocesos() );
        entradasDTO.setFactoresambientales( entradaPdp.getFactoresambientales() );
        entradasDTO.setActivosprocesos( entradaPdp.getActivosprocesos() );

        return entradasDTO;
    }

    @Override
    public Entradas toEntradaPdp(EntradasDTO entradasDTO) {
        if ( entradasDTO == null ) {
            return null;
        }

        Entradas entradas = new Entradas();

        entradas.setIdentradapdp( entradasDTO.getIdentradapdp() );
        entradas.setOtrosprocesos( entradasDTO.getOtrosprocesos() );
        entradas.setFactoresambientales( entradasDTO.getFactoresambientales() );
        entradas.setActivosprocesos( entradasDTO.getActivosprocesos() );
        entradas.setParticipa( entradasDTO.getParticipa() );
        entradas.setEstado( entradasDTO.getEstado() );

        return entradas;
    }

    @Override
    public List<EntradasDTO> toEntradadpDTO(List<Entradas> entradaPdps) {
        if ( entradaPdps == null ) {
            return null;
        }

        List<EntradasDTO> list = new ArrayList<EntradasDTO>( entradaPdps.size() );
        for ( Entradas entradas : entradaPdps ) {
            list.add( toEntradasPdpDTO( entradas ) );
        }

        return list;
    }

    @Override
    public List<Entradas> toEntradadp(List<EntradasDTO> entradasDTOs) {
        if ( entradasDTOs == null ) {
            return null;
        }

        List<Entradas> list = new ArrayList<Entradas>( entradasDTOs.size() );
        for ( EntradasDTO entradasDTO : entradasDTOs ) {
            list.add( toEntradaPdp( entradasDTO ) );
        }

        return list;
    }
}
