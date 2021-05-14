package com.tesis.v1.mapper;

import com.tesis.v1.domain.pdp.Herramientas;
import com.tesis.v1.dto.pdp.HerramientasDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class PdpHerramientasMapperImpl implements PdpHerramientasMapper {

    @Override
<<<<<<< HEAD:target/generated-sources/annotations/com/tesis/v1/mapper/PdpHerramientasMapperImpl.java
    public HerramientasDTO toherramientaDTO(Herramientas herramientasDTO) {
        if ( herramientasDTO == null ) {
            return null;
        }

        HerramientasDTO herramientasDTO1 = new HerramientasDTO();

=======
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
>>>>>>> 5e3e6b0e3444878d6173d307f9e7a5793ef6614b:target/generated-sources/annotations/com/tesis/v1/mapper/pdpHerramientasMapperImpl.java
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
