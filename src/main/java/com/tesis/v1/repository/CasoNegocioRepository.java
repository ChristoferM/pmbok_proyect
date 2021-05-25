package com.tesis.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tesis.v1.domain.CasoNegocio;

public interface CasoNegocioRepository  extends JpaRepository<CasoNegocio,Integer>{

@Query(value =  "SELECT  * " + 
        "from  " + 
        "	public.reuniones, public.actas, " + 
        "	public.casonegocio, public.entradacta , public.proyectos " + 
        "WHERE " + 
        "	public.proyectos.idproyecto= ?1 AND " + 
        "	public.proyectos.idproyecto= public.reuniones.idproyecto AND " + 
        "	public.reuniones.idreuniones= public.actas.idreuniones AND " + 
        "	public.actas.idactas = public.entradacta.idactas AND " + 
        "	public.entradacta.identrada =public.casonegocio.identrada; ", nativeQuery = true)

//@Query(value = "SELECT  casonegocio from public.reuniones , public.actas,public.entradacta , public.casonegocio , public.proyectos WHERE public.idproyecto = ?1")    
public List<CasoNegocio> casoNegocioDelActa(Integer idProyecto);

}
