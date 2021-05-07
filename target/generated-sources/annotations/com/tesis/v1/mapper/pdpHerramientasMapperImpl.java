package com.tesis.v1.mapper;

import com.tesis.v1.domain.pdp.herramientas;
import com.tesis.v1.dto.pdp.herramientasDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.3.1300.v20210331-0708, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class pdpHerramientasMapperImpl implements pdpHerramientasMapper {

    @Override
    public herramientasDTO toherramientaDTO(herramientas herramientasDTO) {
        if ( herramientasDTO == null ) {
            return null;
        }

        herramientasDTO herramientasDTO1 = new herramientasDTO();

        herramientasDTO1.setHabilidades( herramientasDTO.getHabilidades() );
        herramientasDTO1.setHerramientareuniones( herramientasDTO.getHerramientareuniones() );
        herramientasDTO1.setIdherramienta( herramientasDTO.getIdherramienta() );
        herramientasDTO1.setJuicioexpertos( herramientasDTO.getJuicioexpertos() );
        herramientasDTO1.setRecopilaciondatos( herramientasDTO.getRecopilaciondatos() );

        return herramientasDTO1;
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
