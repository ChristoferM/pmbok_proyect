package com.tesis.v1.mapper;

import com.tesis.v1.domain.Roles;
import com.tesis.v1.dto.rolesDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class RolesMapperImpl implements RolesMapper {

    @Override
    public rolesDTO toRolesDTO(Roles roles) {
        if ( roles == null ) {
            return null;
        }

        rolesDTO rolesDTO = new rolesDTO();

        rolesDTO.setIdrol( roles.getIdrol() );
        rolesDTO.setNombrerol( roles.getNombrerol() );

        return rolesDTO;
    }

    @Override
    public Roles toRoles(rolesDTO rolesDTO) {
        if ( rolesDTO == null ) {
            return null;
        }

        Roles roles = new Roles();

        roles.setIdrol( rolesDTO.getIdrol() );
        roles.setNombrerol( rolesDTO.getNombrerol() );

        return roles;
    }

    @Override
    public List<rolesDTO> toRolesDTO(List<Roles> roless) {
        if ( roless == null ) {
            return null;
        }

        List<rolesDTO> list = new ArrayList<rolesDTO>( roless.size() );
        for ( Roles roles : roless ) {
            list.add( toRolesDTO( roles ) );
        }

        return list;
    }

    @Override
    public List<Roles> toRoles(List<rolesDTO> rolesDTOs) {
        if ( rolesDTOs == null ) {
            return null;
        }

        List<Roles> list = new ArrayList<Roles>( rolesDTOs.size() );
        for ( rolesDTO rolesDTO : rolesDTOs ) {
            list.add( toRoles( rolesDTO ) );
        }

        return list;
    }
}
