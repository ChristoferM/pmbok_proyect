package com.tesis.v1.mapper;

import com.tesis.v1.domain.entradacta;
import com.tesis.v1.dto.entradactaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.3.1300.v20210331-0708, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class entradactaMapperImpl implements entradactaMapper {

    @Override
    public entradactaDTO toEntradActaDTO(entradacta entradActa) {
        if ( entradActa == null ) {
            return null;
        }

        entradactaDTO entradactaDTO = new entradactaDTO();

        entradactaDTO.setIdentrada( entradActa.getIdentrada() );
        entradactaDTO.setAcuerdos( entradActa.getAcuerdos() );
        entradactaDTO.setFactores( entradActa.getFactores() );
        entradactaDTO.setActivosprocesos( entradActa.getActivosprocesos() );

        return entradactaDTO;
    }

    @Override
    public entradacta toEntradActa(entradactaDTO entradActaDTO) {
        if ( entradActaDTO == null ) {
            return null;
        }

        entradacta entradacta = new entradacta();

        entradacta.setIdentrada( entradActaDTO.getIdentrada() );
        entradacta.setAcuerdos( entradActaDTO.getAcuerdos() );
        entradacta.setFactores( entradActaDTO.getFactores() );
        entradacta.setActivosprocesos( entradActaDTO.getActivosprocesos() );

        return entradacta;
    }

    @Override
    public List<entradactaDTO> toEntradActaDTO(List<entradacta> entradActa) {
        if ( entradActa == null ) {
            return null;
        }

        List<entradactaDTO> list = new ArrayList<entradactaDTO>( entradActa.size() );
        for ( entradacta entradacta : entradActa ) {
            list.add( toEntradActaDTO( entradacta ) );
        }

        return list;
    }

    @Override
    public List<entradacta> toEntradActa(List<entradactaDTO> entradActaDTOs) {
        if ( entradActaDTOs == null ) {
            return null;
        }

        List<entradacta> list = new ArrayList<entradacta>( entradActaDTOs.size() );
        for ( entradactaDTO entradactaDTO : entradActaDTOs ) {
            list.add( toEntradActa( entradactaDTO ) );
        }

        return list;
    }
}
