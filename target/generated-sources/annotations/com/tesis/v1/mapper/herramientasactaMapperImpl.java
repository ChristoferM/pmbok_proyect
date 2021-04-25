package com.tesis.v1.mapper;

import com.tesis.v1.domain.herramientasacta;
import com.tesis.v1.dto.herramientasactaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 14.0.2 (Private Build)"
)
@Component
public class herramientasactaMapperImpl implements herramientasactaMapper {

    @Override
    public herramientasactaDTO toherramientasActaDTO(herramientasacta herramientasActa) {
        if ( herramientasActa == null ) {
            return null;
        }

        herramientasactaDTO herramientasactaDTO = new herramientasactaDTO();

        herramientasactaDTO.setIdherramienta( herramientasActa.getIdherramienta() );
        herramientasactaDTO.setJuicioexpertos( herramientasActa.getJuicioexpertos() );
        herramientasactaDTO.setRecopilaciondatos( herramientasActa.getRecopilaciondatos() );
        herramientasactaDTO.setHabilidades( herramientasActa.getHabilidades() );
        herramientasactaDTO.setHerramientareuniones( herramientasActa.getHerramientareuniones() );

        return herramientasactaDTO;
    }

    @Override
    public herramientasacta toherramientasActa(herramientasactaDTO herramientasActaDTO) {
        if ( herramientasActaDTO == null ) {
            return null;
        }

        herramientasacta herramientasacta = new herramientasacta();

        herramientasacta.setIdherramienta( herramientasActaDTO.getIdherramienta() );
        herramientasacta.setJuicioexpertos( herramientasActaDTO.getJuicioexpertos() );
        herramientasacta.setRecopilaciondatos( herramientasActaDTO.getRecopilaciondatos() );
        herramientasacta.setHabilidades( herramientasActaDTO.getHabilidades() );
        herramientasacta.setHerramientareuniones( herramientasActaDTO.getHerramientareuniones() );

        return herramientasacta;
    }

    @Override
    public List<herramientasactaDTO> toherramientasActa(List<herramientasacta> herramientasActas) {
        if ( herramientasActas == null ) {
            return null;
        }

        List<herramientasactaDTO> list = new ArrayList<herramientasactaDTO>( herramientasActas.size() );
        for ( herramientasacta herramientasacta : herramientasActas ) {
            list.add( toherramientasActaDTO( herramientasacta ) );
        }

        return list;
    }

    @Override
    public List<herramientasacta> toherramientasActaDTO(List<herramientasactaDTO> herramientasActaDTOs) {
        if ( herramientasActaDTOs == null ) {
            return null;
        }

        List<herramientasacta> list = new ArrayList<herramientasacta>( herramientasActaDTOs.size() );
        for ( herramientasactaDTO herramientasactaDTO : herramientasActaDTOs ) {
            list.add( toherramientasActa( herramientasactaDTO ) );
        }

        return list;
    }
}
