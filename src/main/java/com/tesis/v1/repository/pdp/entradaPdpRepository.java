package com.tesis.v1.repository.pdp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tesis.v1.domain.pdp.Entradas;

public interface entradaPdpRepository extends JpaRepository<Entradas,Integer> {


    @Query(value ="SELECT  " + 
			"entradapdp.identradapdp , " + 
			"entradapdp.otrosprocesos , " + 
			"entradapdp.factoresambientales, " + 
			"entradapdp.activosprocesos, " + 
			"entradapdp.idpdp " + 
			"FROM " + 
			"	proyectos, reuniones, pdp, entradapdp" + 
			"	where " + 
			"	proyectos.idproyecto = reuniones.idproyecto AND " + 
			"	reuniones.idreuniones = pdp.idreuniones AND  " + 
			"	 pdp.idpdp = entradapdp.idpdp  AND " + 
			"	proyectos.idproyecto = ?1  "
			, nativeQuery = true)
	public Entradas BuscarEntradasPdpPorIdDelProyecto(Integer idProyecto);
    
}
