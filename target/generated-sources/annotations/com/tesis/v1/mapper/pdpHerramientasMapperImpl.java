package com.tesis.v1.mapper;

import com.tesis.v1.domain.pdp.herramientas;
import com.tesis.v1.dto.pdp.herramientasDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 15 (Oracle Corporation)"
)
@Component
public class pdpHerramientasMapperImpl implements pdpHerramientasMapper {

    @Override
    public herramientasDTO toherramienta(herramientas herramientas) {
        if ( herramientas == null ) {
            return null;
        }

        herramientasDTO herramientasDTO = new herramientasDTO();

        herramientasDTO.setHabilidades( herramientas.getHabilidades() );
        herramientasDTO.setHerramientareuniones( herramientas.getHerramientareuniones() );
        herramientasDTO.setIdherramienta( herramientas.getIdherramienta() );
        herramientasDTO.setJuicioexpertos( herramientas.getJuicioexpertos() );
        herramientasDTO.setRecopilaciondatos( herramientas.getRecopilaciondatos() );

        return herramientasDTO;
    }

    @Override
    public herramientas toHerramientaDTO(herramientasDTO herramientasPdpDTO) {
        if ( herramientasPdpDTO == null ) {
            return null;
        }

        herramientas herramientas = new herramientas();

        herramientas.setHabilidades( herramientasPdpDTO.getHabilidades() );
        herramientas.setHerramientareuniones( herramientasPdpDTO.getHerramientareuniones() );
        herramientas.setIdherramienta( herramientasPdpDTO.getIdherramienta() );
        herramientas.setJuicioexpertos( herramientasPdpDTO.getJuicioexpertos() );
        herramientas.setRecopilaciondatos( herramientasPdpDTO.getRecopilaciondatos() );

        return herramientas;
    }

    @Override
    public List<herramientas> toHerramientasDTO(List<herramientas> herramientasPdp) {
        if ( herramientasPdp == null ) {
            return null;
        }

        List<herramientas> list = new ArrayList<herramientas>( herramientasPdp.size() );
        for ( herramientas herramientas : herramientasPdp ) {
            list.add( herramientas );
        }

        return list;
    }

    @Override
    public List<herramientas> toHerramientas(List<herramientasDTO> herramientasDTOs) {
        if ( herramientasDTOs == null ) {
            return null;
        }

        List<herramientas> list = new ArrayList<herramientas>( herramientasDTOs.size() );
        for ( herramientasDTO herramientasDTO : herramientasDTOs ) {
            list.add( toHerramientaDTO( herramientasDTO ) );
        }

        return list;
    }
}
