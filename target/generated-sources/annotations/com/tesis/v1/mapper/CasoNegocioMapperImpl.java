package com.tesis.v1.mapper;

import com.tesis.v1.domain.CasoNegocio;
import com.tesis.v1.dto.CasoNegocioDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.4.300.v20221108-0856, environment: Java 17.0.5 (Eclipse Adoptium)"
)
@Component
public class CasoNegocioMapperImpl implements CasoNegocioMapper {

    @Override
    public CasoNegocioDTO tocasoNegocioDTO(CasoNegocio casoNegocio) {
        if ( casoNegocio == null ) {
            return null;
        }

        CasoNegocioDTO casoNegocioDTO = new CasoNegocioDTO();

        casoNegocioDTO.setParticipa( casoNegocio.getParticipa() );
        casoNegocioDTO.setId_caso_negocio( casoNegocio.getId_caso_negocio() );
        casoNegocioDTO.setMetas( casoNegocio.getMetas() );
        casoNegocioDTO.setObjetivos( casoNegocio.getObjetivos() );
        casoNegocioDTO.setIncidentes( casoNegocio.getIncidentes() );
        casoNegocioDTO.setOportunidades( casoNegocio.getOportunidades() );
        casoNegocioDTO.setEstado( casoNegocio.getEstado() );

        return casoNegocioDTO;
    }

    @Override
    public CasoNegocio tocasoNegocio(CasoNegocioDTO casoNegocioDTO) {
        if ( casoNegocioDTO == null ) {
            return null;
        }

        CasoNegocio casoNegocio = new CasoNegocio();

        casoNegocio.setId_caso_negocio( casoNegocioDTO.getId_caso_negocio() );
        casoNegocio.setMetas( casoNegocioDTO.getMetas() );
        casoNegocio.setObjetivos( casoNegocioDTO.getObjetivos() );
        casoNegocio.setIncidentes( casoNegocioDTO.getIncidentes() );
        casoNegocio.setOportunidades( casoNegocioDTO.getOportunidades() );
        casoNegocio.setEstado( casoNegocioDTO.getEstado() );
        casoNegocio.setParticipa( casoNegocioDTO.getParticipa() );

        return casoNegocio;
    }

    @Override
    public List<CasoNegocioDTO> tocasoNegocioDTO(List<CasoNegocio> casoNegocio) {
        if ( casoNegocio == null ) {
            return null;
        }

        List<CasoNegocioDTO> list = new ArrayList<CasoNegocioDTO>( casoNegocio.size() );
        for ( CasoNegocio casoNegocio1 : casoNegocio ) {
            list.add( tocasoNegocioDTO( casoNegocio1 ) );
        }

        return list;
    }

    @Override
    public List<CasoNegocio> tocasoNegocio(List<CasoNegocioDTO> casonegocioDTOs) {
        if ( casonegocioDTOs == null ) {
            return null;
        }

        List<CasoNegocio> list = new ArrayList<CasoNegocio>( casonegocioDTOs.size() );
        for ( CasoNegocioDTO casoNegocioDTO : casonegocioDTOs ) {
            list.add( tocasoNegocio( casoNegocioDTO ) );
        }

        return list;
    }
}
