package com.tesis.v1.mapper;

import com.tesis.v1.domain.pdp.Herramientas;
import com.tesis.v1.dto.pdp.HerramientasDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.3.1300.v20210331-0708, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class PdpHerramientasMapperImpl implements PdpHerramientasMapper {

    @Override
    public HerramientasDTO toherramientaDTO(Herramientas herramientas) {
        if ( herramientas == null ) {
            return null;
        }

        HerramientasDTO herramientasDTO = new HerramientasDTO();

        herramientasDTO.setIdherramienta( herramientas.getIdherramienta() );
        herramientasDTO.setJuicioexpertos( herramientas.getJuicioexpertos() );
        herramientasDTO.setRecopilaciondatos( herramientas.getRecopilaciondatos() );
        herramientasDTO.setHabilidades( herramientas.getHabilidades() );
        herramientasDTO.setHerramientareuniones( herramientas.getHerramientareuniones() );

        return herramientasDTO;
    }

    @Override
    public Herramientas toHerramientaDTO(HerramientasDTO herramientasPdpDTO) {
        if ( herramientasPdpDTO == null ) {
            return null;
        }

        Herramientas herramientas = new Herramientas();

        herramientas.setIdherramienta( herramientasPdpDTO.getIdherramienta() );
        herramientas.setJuicioexpertos( herramientasPdpDTO.getJuicioexpertos() );
        herramientas.setRecopilaciondatos( herramientasPdpDTO.getRecopilaciondatos() );
        herramientas.setHabilidades( herramientasPdpDTO.getHabilidades() );
        herramientas.setHerramientareuniones( herramientasPdpDTO.getHerramientareuniones() );

        return herramientas;
    }

    @Override
    public List<Herramientas> toHerramientasDTO(List<Herramientas> herramientasPdp) {
        if ( herramientasPdp == null ) {
            return null;
        }

        List<Herramientas> list = new ArrayList<Herramientas>( herramientasPdp.size() );
        for ( Herramientas herramientas : herramientasPdp ) {
            list.add( herramientas );
        }

        return list;
    }

    @Override
    public List<Herramientas> toHerramientas(List<HerramientasDTO> herramientasDTOs) {
        if ( herramientasDTOs == null ) {
            return null;
        }

        List<Herramientas> list = new ArrayList<Herramientas>( herramientasDTOs.size() );
        for ( HerramientasDTO herramientasDTO : herramientasDTOs ) {
            list.add( toHerramientaDTO( herramientasDTO ) );
        }

        return list;
    }
}
