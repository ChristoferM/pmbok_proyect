package com.tesis.v1.mapper;

import com.tesis.v1.domain.Herramientasacta;
import com.tesis.v1.dto.HerramientasActaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 15 (Oracle Corporation)"
)
@Component
public class HerramientasactaMapperImpl implements HerramientasactaMapper {

    @Override
    public HerramientasActaDTO toherramientasActaDTO(Herramientasacta herramientasActa) {
        if ( herramientasActa == null ) {
            return null;
        }

        HerramientasActaDTO herramientasActaDTO = new HerramientasActaDTO();

        herramientasActaDTO.setEstado( herramientasActa.getEstado() );
        herramientasActaDTO.setHabilidades( herramientasActa.getHabilidades() );
        herramientasActaDTO.setHerramientareuniones( herramientasActa.getHerramientareuniones() );
        herramientasActaDTO.setIdherramienta( herramientasActa.getIdherramienta() );
        herramientasActaDTO.setJuicioexpertos( herramientasActa.getJuicioexpertos() );
        herramientasActaDTO.setParticipa( herramientasActa.getParticipa() );
        herramientasActaDTO.setRecopilaciondatos( herramientasActa.getRecopilaciondatos() );

        return herramientasActaDTO;
    }

    @Override
    public Herramientasacta toherramientasActa(HerramientasActaDTO herramientasActaDTO) {
        if ( herramientasActaDTO == null ) {
            return null;
        }

        Herramientasacta herramientasacta = new Herramientasacta();

        herramientasacta.setEstado( herramientasActaDTO.getEstado() );
        herramientasacta.setHabilidades( herramientasActaDTO.getHabilidades() );
        herramientasacta.setHerramientareuniones( herramientasActaDTO.getHerramientareuniones() );
        herramientasacta.setIdherramienta( herramientasActaDTO.getIdherramienta() );
        herramientasacta.setJuicioexpertos( herramientasActaDTO.getJuicioexpertos() );
        herramientasacta.setParticipa( herramientasActaDTO.getParticipa() );
        herramientasacta.setRecopilaciondatos( herramientasActaDTO.getRecopilaciondatos() );

        return herramientasacta;
    }

    @Override
    public List<HerramientasActaDTO> toherramientasActa(List<Herramientasacta> herramientasActas) {
        if ( herramientasActas == null ) {
            return null;
        }

        List<HerramientasActaDTO> list = new ArrayList<HerramientasActaDTO>( herramientasActas.size() );
        for ( Herramientasacta herramientasacta : herramientasActas ) {
            list.add( toherramientasActaDTO( herramientasacta ) );
        }

        return list;
    }

    @Override
    public List<Herramientasacta> toherramientasActaDTO(List<HerramientasActaDTO> herramientasActaDTOs) {
        if ( herramientasActaDTOs == null ) {
            return null;
        }

        List<Herramientasacta> list = new ArrayList<Herramientasacta>( herramientasActaDTOs.size() );
        for ( HerramientasActaDTO herramientasActaDTO : herramientasActaDTOs ) {
            list.add( toherramientasActa( herramientasActaDTO ) );
        }

        return list;
    }
}
