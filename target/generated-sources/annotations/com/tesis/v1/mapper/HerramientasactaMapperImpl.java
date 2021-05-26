package com.tesis.v1.mapper;

import com.tesis.v1.domain.Herramientasacta;
import com.tesis.v1.dto.HerramientasActaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.3.1300.v20210331-0708, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class HerramientasactaMapperImpl implements HerramientasactaMapper {

    @Override
    public HerramientasActaDTO toherramientasActaDTO(Herramientasacta herramientasActa) {
        if ( herramientasActa == null ) {
            return null;
        }

        HerramientasActaDTO herramientasActaDTO = new HerramientasActaDTO();

        herramientasActaDTO.setIdherramienta( herramientasActa.getIdherramienta() );
        herramientasActaDTO.setJuicioexpertos( herramientasActa.getJuicioexpertos() );
        herramientasActaDTO.setRecopilaciondatos( herramientasActa.getRecopilaciondatos() );
        herramientasActaDTO.setHabilidades( herramientasActa.getHabilidades() );
        herramientasActaDTO.setHerramientareuniones( herramientasActa.getHerramientareuniones() );

        return herramientasActaDTO;
    }

    @Override
    public Herramientasacta toherramientasActa(HerramientasActaDTO herramientasActaDTO) {
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
