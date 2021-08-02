package com.tesis.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tesis.v1.domain.RolProyecto;

public interface RolProyectoRepository extends JpaRepository<RolProyecto, Integer> {
	
	@Query(value ="SELECT * FROM rolproyecto WHERE rolproyecto.idgrupo = ?1 ;", nativeQuery = true)
	public RolProyecto  rolGrupoDeTrabajo(Integer idGrupo);

}
