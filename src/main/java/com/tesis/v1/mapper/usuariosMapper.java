package com.tesis.v1.mapper;

import org.mapstruct.Mapper;

import com.tesis.v1.domain.usuarios;
import com.tesis.v1.dto.usuariosDTO;

import java.util.List;
@Mapper
public interface usuariosMapper{
	
	public usuariosDTO toUsuariosDTO(usuarios usuarios );
	
	public usuarios  toUsuarios(usuariosDTO usuariosDTO );
	
	public List<usuariosDTO> toUsuariosDTOs(List<usuarios> usuarioss );
	
	public List<usuarios> toUsuarioss(List<usuariosDTO> usuariosDTOs);

}
