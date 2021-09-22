package com.tesis.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tesis.v1.domain.PlanGestionbeneficio;

public interface PlanGestionBeneficioRepository extends JpaRepository<PlanGestionbeneficio, Integer> {

	
        @Query(value = "SELECT  *" + 
                        "	 " + 
                        "from  " + 
                        "	public.reuniones, public.actas, " + 
                        "	public.entradacta, public.planesgestionbeneficios, " + 
                        "	public.proyectos " + 
                        "WHERE " + 
                        "	public.proyectos.idproyecto= ?1 AND " + 
                        "	public.proyectos.idproyecto= public.reuniones.idproyecto AND " + 
                        "	public.reuniones.idreuniones= public.actas.idreuniones AND " + 
                        "	public.actas.idactas = public.entradacta.idactas and " + 
                        "	public.entradacta.identrada= public.planesgestionbeneficios.identrada; " , nativeQuery = true)
	public List<PlanGestionbeneficio> planGestionDelActa(Integer idProyecto);
        
        

    	@Query(value = "	SELECT entradacta.identrada FROM entradacta WHERE entradacta.idactas IN  ( "
    			+ "	SELECT actas.idactas FROM actas WHERE actas.idreuniones IN ( "
    			+ "		SELECT reuniones.idreuniones FROM reuniones, proyectos "
    			+ "			WHERE reuniones.idproyecto = proyectos.idproyecto  "
    			+ "			AND proyectos.idproyecto= ?1)) limit 1;", nativeQuery = true)
    	public Integer BuscarIdDeEntradaParaPlanDeBeneficios(Integer idproyecto);
}
