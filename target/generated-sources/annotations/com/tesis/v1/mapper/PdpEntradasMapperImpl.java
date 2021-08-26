package com.tesis.v1.mapper;

import com.tesis.v1.domain.pdp.Entradas;
import com.tesis.v1.dto.pdp.EntradasDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 15 (Oracle Corporation)"
)
@Component
public class PdpEntradasMapperImpl implements PdpEntradasMapper {

    @Override
    public EntradasDTO toEntradasPdpDTO(Entradas entradaPdp) {
        if ( entradaPdp == null ) {
            return null;
        }

        EntradasDTO entradasDTO = new EntradasDTO();

        entradasDTO.setActivosprocesos( entradaPdp.getActivosprocesos() );
        entradasDTO.setEstado( entradaPdp.getEstado() );
        entradasDTO.setFactoresambientales( entradaPdp.getFactoresambientales() );
        entradasDTO.setIdentradapdp( entradaPdp.getIdentradapdp() );
        entradasDTO.setOtrosprocesos( entradaPdp.getOtrosprocesos() );
        entradasDTO.setParticipa( entradaPdp.getParticipa() );

        return entradasDTO;
    }

    @Override
    public Entradas toEntradaPdp(EntradasDTO entradasDTO) {
        if ( entradasDTO == null ) {
            return null;
        }

        Entradas entradas = new Entradas();

        entradas.setActivosprocesos( entradasDTO.getActivosprocesos() );
        entradas.setEstado( entradasDTO.getEstado() );
        entradas.setFactoresambientales( entradasDTO.getFactoresambientales() );
        entradas.setIdentradapdp( entradasDTO.getIdentradapdp() );
        entradas.setOtrosprocesos( entradasDTO.getOtrosprocesos() );
        entradas.setParticipa( entradasDTO.getParticipa() );

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
