package com.tesis.v1.mapper;

import com.tesis.v1.domain.casonegocio;
import com.tesis.v1.dto.casonegocioDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 15 (Oracle Corporation)"
)
@Component
public class casonegocioMapperImpl implements casonegocioMapper {

    @Override
    public casonegocioDTO tocasoNegocioDTO(casonegocio casoNegocio) {
        if ( casoNegocio == null ) {
            return null;
        }

        casonegocioDTO casonegocioDTO = new casonegocioDTO();

        casonegocioDTO.setId_caso_negocio( casoNegocio.getId_caso_negocio() );
        casonegocioDTO.setMetas( casoNegocio.getMetas() );
        casonegocioDTO.setObjetivos( casoNegocio.getObjetivos() );
        casonegocioDTO.setIncidentes( casoNegocio.getIncidentes() );
        casonegocioDTO.setOportunidades( casoNegocio.getOportunidades() );

        return casonegocioDTO;
    }

    @Override
    public casonegocio tocasoNegocio(casonegocioDTO casoNegocioDTO) {
        if ( casoNegocioDTO == null ) {
            return null;
        }

        casonegocio casonegocio = new casonegocio();

        casonegocio.setId_caso_negocio( casoNegocioDTO.getId_caso_negocio() );
        casonegocio.setMetas( casoNegocioDTO.getMetas() );
        casonegocio.setObjetivos( casoNegocioDTO.getObjetivos() );
        casonegocio.setIncidentes( casoNegocioDTO.getIncidentes() );
        casonegocio.setOportunidades( casoNegocioDTO.getOportunidades() );

        return casonegocio;
    }

    @Override
    public List<casonegocioDTO> tocasoNegocioDTO(List<casonegocio> casoNegocio) {
        if ( casoNegocio == null ) {
            return null;
        }

        List<casonegocioDTO> list = new ArrayList<casonegocioDTO>( casoNegocio.size() );
        for ( casonegocio casonegocio : casoNegocio ) {
            list.add( tocasoNegocioDTO( casonegocio ) );
        }

        return list;
    }

    @Override
    public List<casonegocio> tocasoNegocio(List<casonegocioDTO> casonegocioDTOs) {
        if ( casonegocioDTOs == null ) {
            return null;
        }

        List<casonegocio> list = new ArrayList<casonegocio>( casonegocioDTOs.size() );
        for ( casonegocioDTO casonegocioDTO : casonegocioDTOs ) {
            list.add( tocasoNegocio( casonegocioDTO ) );
        }

        return list;
    }
}
