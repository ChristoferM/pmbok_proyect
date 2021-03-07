package com.tesis.v1.mapper;

import java.util.List;
import org.mapstruct.Mapper;

import com.tesis.v1.domain.roles;
import com.tesis.v1.dto.rolesDTO;

@Mapper
public interface rolesMapper {
	
	public rolesDTO toRolesDTO(roles  roles);
	
	public  roles toRoles(rolesDTO rolesDTO );
	
	public List<rolesDTO> toRolesDTO(List<roles>  roless);
	
	public List<roles> toRoles(List<rolesDTO> rolesDTOs );
}
