package com.tesis.v1.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.tesis.v1.domain.planesgestionbeneficios;
import com.tesis.v1.dto.planesgestionbeneficiosDTO;

@Mapper
public interface planesgestionbeneficiosMapper {

public planesgestionbeneficiosDTO toplanesGestionBeneficiosDTO( planesgestionbeneficios planesGestionBeneficios );
	
	public planesgestionbeneficios toplanesGestionBeneficios(planesgestionbeneficiosDTO planesGestionBeneficiosDTO);
	
	public List<planesgestionbeneficiosDTO> toplanesGestionBeneficiosDTO(List<planesgestionbeneficios>  planesGestionBeneficios);
	
	public List<planesgestionbeneficios> toplanesGestionBeneficios(List<planesgestionbeneficiosDTO> planesGestionBeneficiosDTOs);
}
