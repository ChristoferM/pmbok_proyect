package com.tesis.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tesis.v1.domain.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {

    @Query(value = "SELECT * FROM public.proyectos WHERE  public.proyectos.admin = ?1 ", nativeQuery = true)
    public List<Proyecto> finByEmail(String email);

    @Query(value = "select proyectos.idproyecto,proyectos.nombre,proyectos.descripcion, proyectos.admin, " + 
    		"proyectos.tipo_id from proyectos, grupo, usuarios " + 
    		"WHERE  usuarios.email = ?1 AND " + 
    		"proyectos.idproyecto = grupo.idproyecto AND " + 
    		"grupo.email  = usuarios.email ", nativeQuery = true)
    public List<Proyecto> BuscarParticipaciones(String email);

    /*
	@Query("SELECT pro FROM public.Proyecto  pro WHERE  pro.admin= :id") 
	public Optional<proyectos>finByEmail(@Param("id") String email);*/
}
