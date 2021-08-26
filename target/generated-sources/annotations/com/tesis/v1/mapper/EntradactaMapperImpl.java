package com.tesis.v1.mapper;

import com.tesis.v1.domain.Entradacta;
import com.tesis.v1.dto.EntradactaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 15 (Oracle Corporation)"
)
@Component
public class EntradactaMapperImpl implements EntradactaMapper {

    @Override
    public EntradactaDTO toEntradActaDTO(Entradacta entradActa) {
        if ( entradActa == null ) {
            return null;
        }

        EntradactaDTO entradactaDTO = new EntradactaDTO();

        entradactaDTO.setActivosprocesos( entradActa.getActivosprocesos() );
        entradactaDTO.setAcuerdos( entradActa.getAcuerdos() );
        entradactaDTO.setEstado( entradActa.getEstado() );
        entradactaDTO.setFactores( entradActa.getFactores() );
        entradactaDTO.setIdentrada( entradActa.getIdentrada() );
        entradactaDTO.setParticipa( entradActa.getParticipa() );

        return entradactaDTO;
    }

    @Override
    public Entradacta toEntradActa(EntradactaDTO entradActaDTO) {
        if ( entradActaDTO == null ) {
            return null;
        }

        Entradacta entradacta = new Entradacta();

        entradacta.setActivosprocesos( entradActaDTO.getActivosprocesos() );
        entradacta.setAcuerdos( entradActaDTO.getAcuerdos() );
        entradacta.setEstado( entradActaDTO.getEstado() );
        entradacta.setFactores( entradActaDTO.getFactores() );
        entradacta.setIdentrada( entradActaDTO.getIdentrada() );
        entradacta.setParticipa( entradActaDTO.getParticipa() );

        return entradacta;
    }

    @Override
    public List<EntradactaDTO> toEntradActaDTO(List<Entradacta> entradActa) {
        if ( entradActa == null ) {
            return null;
        }

        List<EntradactaDTO> list = new ArrayList<EntradactaDTO>( entradActa.size() );
        for ( Entradacta entradacta : entradActa ) {
            list.add( toEntradActaDTO( entradacta ) );
        }

        return list;
    }

    @Override
    public List<Entradacta> toEntradActa(List<EntradactaDTO> entradActaDTOs) {
        if ( entradActaDTOs == null ) {
            return null;
        }

        List<Entradacta> list = new ArrayList<Entradacta>( entradActaDTOs.size() );
        for ( EntradactaDTO entradactaDTO : entradActaDTOs ) {
            list.add( toEntradActa( entradactaDTO ) );
        }

        return list;
    }
}
