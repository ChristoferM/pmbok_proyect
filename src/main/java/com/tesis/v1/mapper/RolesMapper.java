package com.tesis.v1.mapper;

import java.util.List;
import org.mapstruct.Mapper;

import com.tesis.v1.domain.Roles;
import com.tesis.v1.dto.RolesDTO;

@Mapper
public interface RolesMapper {
	
	public RolesDTO toRolesDTO(Roles  roles);
	
	public  Roles toRoles(RolesDTO rolesDTO );
	
	public List<RolesDTO> toRolesDTO(List<Roles>  roless);
	
	public List<Roles> toRoles(List<RolesDTO> rolesDTOs );
}
