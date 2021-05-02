package com.tesis.v1.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.tesis.v1.domain.pdp.pdp;
import com.tesis.v1.dto.pdp.pdpDTO;

@Mapper
public interface pdpMapper {
	
	public pdpDTO toPdpDTO(pdp pdps );
	
	public pdp  toPdp(pdpDTO pdpDTO );
	
	public List<pdpDTO> toPdpDTOs(List<pdp> pdps);
	
	public List<pdp> toPdps(List<pdpDTO> pdpDTOs );
	

}
