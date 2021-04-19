package com.tesis.v1.mapper;

import com.tesis.v1.domain.usuarios;
import com.tesis.v1.dto.usuariosDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 14.0.2 (Private Build)"
)
@Component
public class usuariosMapperImpl implements usuariosMapper {

    @Override
    public usuariosDTO toUsuariosDTO(usuarios usuarios) {
        if ( usuarios == null ) {
            return null;
        }

        usuariosDTO usuariosDTO = new usuariosDTO();

        usuariosDTO.setEmail( usuarios.getEmail() );
        usuariosDTO.setNombre( usuarios.getNombre() );
        usuariosDTO.setPassword( usuarios.getPassword() );
        usuariosDTO.setToken( usuarios.getToken() );
        usuariosDTO.setActivo( usuarios.getActivo() );

        return usuariosDTO;
    }

    @Override
    public usuarios toUsuarios(usuariosDTO usuariosDTO) {
        if ( usuariosDTO == null ) {
            return null;
        }

        usuarios usuarios = new usuarios();

        usuarios.setEmail( usuariosDTO.getEmail() );
        usuarios.setNombre( usuariosDTO.getNombre() );
        usuarios.setPassword( usuariosDTO.getPassword() );
        usuarios.setToken( usuariosDTO.getToken() );
        usuarios.setActivo( usuariosDTO.getActivo() );

        return usuarios;
    }

    @Override
    public List<usuariosDTO> toUsuariosDTOs(List<usuarios> usuarioss) {
        if ( usuarioss == null ) {
            return null;
        }

        List<usuariosDTO> list = new ArrayList<usuariosDTO>( usuarioss.size() );
        for ( usuarios usuarios : usuarioss ) {
            list.add( toUsuariosDTO( usuarios ) );
        }

        return list;
    }

    @Override
    public List<usuarios> toUsuarioss(List<usuariosDTO> usuariosDTOs) {
        if ( usuariosDTOs == null ) {
            return null;
        }

        List<usuarios> list = new ArrayList<usuarios>( usuariosDTOs.size() );
        for ( usuariosDTO usuariosDTO : usuariosDTOs ) {
            list.add( toUsuarios( usuariosDTO ) );
        }

        return list;
    }
}
