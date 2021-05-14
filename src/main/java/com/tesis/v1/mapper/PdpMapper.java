package com.tesis.v1.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.tesis.v1.domain.pdp.Pdp;
import com.tesis.v1.dto.pdp.PdpDTO;

@Mapper
public interface PdpMapper {
	
	public PdpDTO toPdpDTO(Pdp pdps );
	
	public Pdp  toPdp(PdpDTO pdpDTO );
	
	public List<PdpDTO> toPdpDTOs(List<Pdp> pdps);
	
	public List<Pdp> toPdps(List<PdpDTO> pdpDTOs );
	

}
