package com.tesis.v1.repository.pdp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tesis.v1.domain.Entradacta;
import com.tesis.v1.domain.pdp.Entradas;
import com.tesis.v1.domain.pdp.Pdp;

public interface entradaPdpRepository extends JpaRepository<Entradas,Integer> {


    @Query(value ="SELECT entradapdp.* "+
			"FROM " + 
			"	proyectos, reuniones, pdp, entradapdp" + 
			"	where " + 
			"	proyectos.idproyecto = reuniones.idproyecto AND " + 
			"	reuniones.idreuniones = pdp.idreuniones AND  " + 
			"	 pdp.idpdp = entradapdp.idpdp  AND " + 
			"	proyectos.idproyecto = ?1  "
			, nativeQuery = true)
	public List<Entradas> BuscarEntradasPdpPorIdDelProyecto(Integer idProyecto);
 
	// -------------------- NUEVOS METODOS DE REPOSITORIO
    
	@Query(value ="select actas.idreuniones from actas where actas.idreuniones in ("
			+ "SELECT reuniones.idreuniones FROM reuniones WHERE  reuniones.idproyecto = ?1 "
			+ ");", nativeQuery = true)
	public Integer buscarIdReunion( Integer idproyecto);
	
	@Query(value ="select * from pdp where pdp.idreuniones = ?1 ; ", nativeQuery = true)
	public Pdp buscarPorIdReunion(Integer idreuniones);
	


	@Query(value ="SELECT * FROM entradapdp WHERE entradapdp.idpdp IN  ( \r\n" + 
			"				SELECT pdp.idpdp FROM pdp WHERE pdp.idreuniones IN (   \r\n" + 
			"					SELECT reuniones.idreuniones FROM reuniones, proyectos    \r\n" + 
			"						WHERE reuniones.idproyecto = proyectos.idproyecto     \r\n" + 
			"						AND proyectos.idproyecto= ?1 ) );", nativeQuery = true)
	public List<Entradas> BuscarDatosDeEntradasPdp( Integer idproyecto);
}
