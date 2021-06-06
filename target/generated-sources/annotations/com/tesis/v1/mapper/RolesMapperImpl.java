package com.tesis.v1.mapper;

import com.tesis.v1.domain.Roles;
import com.tesis.v1.dto.RolesDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 15 (Oracle Corporation)"
)
@Component
public class RolesMapperImpl implements RolesMapper {

    @Override
    public RolesDTO toRolesDTO(Roles roles) {
        if ( roles == null ) {
            return null;
        }

        RolesDTO rolesDTO = new RolesDTO();

        rolesDTO.setIdrol( roles.getIdrol() );
        rolesDTO.setNombrerol( roles.getNombrerol() );

        return rolesDTO;
    }

    @Override
    public Roles toRoles(RolesDTO rolesDTO) {
        if ( rolesDTO == null ) {
            return null;
        }

        Roles roles = new Roles();

        roles.setIdrol( rolesDTO.getIdrol() );
        roles.setNombrerol( rolesDTO.getNombrerol() );

        return roles;
    }

    @Override
    public List<RolesDTO> toRolesDTO(List<Roles> roless) {
        if ( roless == null ) {
            return null;
        }

        List<RolesDTO> list = new ArrayList<RolesDTO>( roless.size() );
        for ( Roles roles : roless ) {
            list.add( toRolesDTO( roles ) );
        }

        return list;
    }

    @Override
    public List<Roles> toRoles(List<RolesDTO> rolesDTOs) {
        if ( rolesDTOs == null ) {
            return null;
        }

        List<Roles> list = new ArrayList<Roles>( rolesDTOs.size() );
        for ( RolesDTO rolesDTO : rolesDTOs ) {
            list.add( toRoles( rolesDTO ) );
        }

        return list;
    }
}
