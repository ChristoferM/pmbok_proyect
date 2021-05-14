package com.tesis.v1.mapper;

import com.tesis.v1.domain.Herramientasacta;
import com.tesis.v1.dto.herramientasactaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class HerramientasactaMapperImpl implements HerramientasactaMapper {

    @Override
    public herramientasactaDTO toherramientasActaDTO(Herramientasacta herramientasActa) {
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
    public Herramientasacta toherramientasActa(herramientasactaDTO herramientasActaDTO) {
        if ( herramientasActaDTO == null ) {
            return null;
        }

        Herramientasacta herramientasacta = new Herramientasacta();

        herramientasacta.setIdherramienta( herramientasActaDTO.getIdherramienta() );
        herramientasacta.setJuicioexpertos( herramientasActaDTO.getJuicioexpertos() );
        herramientasacta.setRecopilaciondatos( herramientasActaDTO.getRecopilaciondatos() );
        herramientasacta.setHabilidades( herramientasActaDTO.getHabilidades() );
        herramientasacta.setHerramientareuniones( herramientasActaDTO.getHerramientareuniones() );

        return herramientasacta;
    }

    @Override
    public List<herramientasactaDTO> toherramientasActa(List<Herramientasacta> herramientasActas) {
        if ( herramientasActas == null ) {
            return null;
        }

        List<herramientasactaDTO> list = new ArrayList<herramientasactaDTO>( herramientasActas.size() );
        for ( Herramientasacta herramientasacta : herramientasActas ) {
            list.add( toherramientasActaDTO( herramientasacta ) );
        }

        return list;
    }

    @Override
    public List<Herramientasacta> toherramientasActaDTO(List<herramientasactaDTO> herramientasActaDTOs) {
        if ( herramientasActaDTOs == null ) {
            return null;
        }

        List<Herramientasacta> list = new ArrayList<Herramientasacta>( herramientasActaDTOs.size() );
        for ( herramientasactaDTO herramientasactaDTO : herramientasActaDTOs ) {
            list.add( toherramientasActa( herramientasactaDTO ) );
        }

        return list;
    }
}
