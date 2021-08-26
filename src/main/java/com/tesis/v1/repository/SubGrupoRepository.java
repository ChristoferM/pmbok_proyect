package com.tesis.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tesis.v1.domain.SubGrupo;

public interface SubGrupoRepository extends JpaRepository<SubGrupo,Integer>{
	
	@Query(value ="select * from subgrupo where subgrupo.idgrupo =  ?1 ;", nativeQuery = true)
	public SubGrupo  obtenerDatosDeParticipaiconSubgrupo(Integer idGrupo);

}
