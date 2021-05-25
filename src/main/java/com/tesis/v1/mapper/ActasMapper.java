package com.tesis.v1.mapper;

import org.mapstruct.Mapper;

import java.util.List;
import com.tesis.v1.domain.Acta;
import com.tesis.v1.dto.ActasDTO;

@Mapper
public interface ActasMapper {

    public ActasDTO toActasDTO(Acta actas);

    public Acta toActas(ActasDTO actasDto);

    public List<ActasDTO> toActasDTO(List<Acta> actas);

    public List<Acta> toActas(List<ActasDTO> actasDTOs);

    /*
	public  toDTO( );
	
	public  to( );
	
	public List<> toDTO(List<> );
	
	public List<> to(List<> );
	
     */
}
