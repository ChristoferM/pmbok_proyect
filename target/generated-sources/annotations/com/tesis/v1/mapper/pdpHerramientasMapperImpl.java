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
    public herramientasDTO toherramienta(herramientas herramientas) {
        if ( herramientas == null ) {
            return null;
        }

        herramientasDTO herramientasDTO = new herramientasDTO();

<<<<<<< HEAD
<<<<<<< HEAD
        herramientasDTO.setHabilidades( herramientas.getHabilidades() );
        herramientasDTO.setHerramientareuniones( herramientas.getHerramientareuniones() );
        herramientasDTO.setIdherramienta( herramientas.getIdherramienta() );
        herramientasDTO.setJuicioexpertos( herramientas.getJuicioexpertos() );
        herramientasDTO.setRecopilaciondatos( herramientas.getRecopilaciondatos() );
=======
=======
>>>>>>> 8355755ed4d8c95213239d015f4ed2fbb090e292
        herramientasDTO1.setIdherramienta( herramientasDTO.getIdherramienta() );
        herramientasDTO1.setJuicioexpertos( herramientasDTO.getJuicioexpertos() );
        herramientasDTO1.setRecopilaciondatos( herramientasDTO.getRecopilaciondatos() );
        herramientasDTO1.setHabilidades( herramientasDTO.getHabilidades() );
        herramientasDTO1.setHerramientareuniones( herramientasDTO.getHerramientareuniones() );
<<<<<<< HEAD
>>>>>>> security
=======
>>>>>>> 8355755ed4d8c95213239d015f4ed2fbb090e292

        return herramientasDTO;
    }

    @Override
    public herramientas toHerramientaDTO(herramientasDTO herramientasPdpDTO) {
        if ( herramientasPdpDTO == null ) {
            return null;
        }

        herramientas herramientas = new herramientas();

        herramientas.setIdherramienta( herramientasPdpDTO.getIdherramienta() );
        herramientas.setJuicioexpertos( herramientasPdpDTO.getJuicioexpertos() );
        herramientas.setRecopilaciondatos( herramientasPdpDTO.getRecopilaciondatos() );
        herramientas.setHabilidades( herramientasPdpDTO.getHabilidades() );
        herramientas.setHerramientareuniones( herramientasPdpDTO.getHerramientareuniones() );

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
