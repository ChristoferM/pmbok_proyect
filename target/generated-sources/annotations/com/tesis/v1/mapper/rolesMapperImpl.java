package com.tesis.v1.mapper;

import com.tesis.v1.domain.roles;
import com.tesis.v1.dto.rolesDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 14.0.2 (Private Build)"
)
@Component
public class rolesMapperImpl implements rolesMapper {

    @Override
    public rolesDTO toRolesDTO(roles roles) {
        if ( roles == null ) {
            return null;
        }

        rolesDTO rolesDTO = new rolesDTO();

        rolesDTO.setIdrol( roles.getIdrol() );
        rolesDTO.setNombrerol( roles.getNombrerol() );

        return rolesDTO;
    }

    @Override
    public roles toRoles(rolesDTO rolesDTO) {
        if ( rolesDTO == null ) {
            return null;
        }

        roles roles = new roles();

        roles.setIdrol( rolesDTO.getIdrol() );
        roles.setNombrerol( rolesDTO.getNombrerol() );

        return roles;
    }

    @Override
    public List<rolesDTO> toRolesDTO(List<roles> roless) {
        if ( roless == null ) {
            return null;
        }

        List<rolesDTO> list = new ArrayList<rolesDTO>( roless.size() );
        for ( roles roles : roless ) {
            list.add( toRolesDTO( roles ) );
        }

        return list;
    }

    @Override
    public List<roles> toRoles(List<rolesDTO> rolesDTOs) {
        if ( rolesDTOs == null ) {
            return null;
        }

        List<roles> list = new ArrayList<roles>( rolesDTOs.size() );
        for ( rolesDTO rolesDTO : rolesDTOs ) {
            list.add( toRoles( rolesDTO ) );
        }

        return list;
    }
}
