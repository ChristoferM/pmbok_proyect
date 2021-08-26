package com.tesis.v1.	repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tesis.v1.dto.ControlFasesDTO;
import com.tesis.v1.dto.GrupoDTO;
import com.tesis.v1.dto.ResponsablesDTO;
import com.tesis.v1.dto.RolproyectoDTO;
import com.tesis.v1.domain.Grupo;
import com.tesis.v1.domain.RolProyecto;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo,Integer>{
	
	@Query(value ="SELECT CASE WHEN "+ 
			"    EXISTS ( " + 
			"      	select * from roles " + 
			"		where lower(roles.nombrerol) = lower(?1) " + 
			"		) " + 
			" THEN " + 
			"    TRUE " + 
			" ELSE " + 
			"    FALSE " + 
			" END;", nativeQuery = true)
	public Boolean validarRol(String nombre);
	
	@Modifying
	@Query(value =" DELETE FROM rolproyecto WHERE rolproyecto.idgrupo In ( " + 
			" SELECT grupo.idgrupo FROM grupo where grupo.idproyecto = ?2 AND grupo.email  = ?1 );", nativeQuery = true)
	public  void elimiarUsuarioRol(String  usuario,Integer idProyecto);
	
	
	@Modifying
	@Query(value ="DELETE FROM subgrupo where subgrupo.idgrupo IN ( " + 
			"SELECT grupo.idgrupo FROM grupo where grupo.idproyecto = ?2 AND grupo.email  = ?1 );", nativeQuery = true)
	public  void elimiarUsuarioSubGrupo(String  usuario,Integer idProyecto);
	
	
	@Modifying
	@Query(value =" DELETE FROM grupo where grupo.idproyecto = ?2 AND grupo.email  = ?1 ;", nativeQuery = true)
	public  void elimiarUsuarioMatriculado(String  usuario,Integer idProyecto);
	
	
	
	@Query(value ="SELECT  * FROM grupo WHERE  grupo.idproyecto = ?1 ;", nativeQuery = true)
	public List<Grupo>  grupoDeTrabajo(Integer idProyecto);
	
	@Query(value ="select * from  grupo where grupo.idproyecto = ?1  AND grupo.email = ?2 ;", nativeQuery = true)
	public List<Grupo>  obtenerDatosDeParticipaicon(Integer idProyecto,String email);
	
	
	
	@Query(value ="SELECT   " + 
			"		grupo.idgrupo, " + 
			"        grupo.id_sub_grupo, " + 
			"		grupo.idproyecto, " + 
			"		grupo.email, " + 
			"		grupo.estado" + 
			"			FROM  " + 
			"			faseproyecto , subgrupo, grupo  " + 
			"			WHERE faseproyecto.idfase = ?1 " + 
			"			AND faseproyecto.idfase = subgrupo.idfase  " + 
			"			AND grupo.idgrupo = subgrupo.idgrupo ", nativeQuery = true)
	public List<Grupo>  responsablesEnFaseoReunion(Integer idProyecto);
	
	
	
	
	@Query(value =	"SELECT * FROM grupo WHERE grupo.email = ?1 ORDER BY  grupo.idproyecto;", nativeQuery = true)
	public List<Grupo>  buscarParticipaciones(String Usuario);
	

	/*@Query(value ="SELECT   " + 
			"			faseproyecto.idfase as idfase, " + 
			"			subgrupo.id_sub_grupo as id_sub_grupo,  " + 
			"			subgrupo.idgrupo as idgrupo, " + 
			"			grupo.email as email " + 
			"			FROM  " + 
			"			faseproyecto , subgrupo, grupo  " + 
			"			WHERE faseproyecto.idfase = 12  " + 
			"			AND faseproyecto.idfase = subgrupo.idfase  " + 
			"			AND grupo.idgrupo = subgrupo.idgrupo ", nativeQuery = true)
	public List<ResponsablesDTO>  responsablesEnFaseoReunion(Integer idProyecto);*/
	
	/*@Query(value ="SELECT " + 
			"proyectos.nombre as nombreProyecto, " + 
			"proyectos.descripcion as descripcionProyecto, " + 
			"reuniones.nombrereunion as nombreReunion, " + 
			"reuniones.descripcionreunion as descripcionReunion, " + 
			"faseproyecto.descripcionfase as descripcionFase, " + 
			"faseproyecto.tiempoinicio as inicio, " + 
			"faseproyecto.tiempofin as fin, " + 
			"(CASE WHEN faseproyecto.tiempofin < CURRENT_DATE THEN 'Finalizado' ELSE 'En Proceso' END) as estado," + 
			"tipofases.nombrefase as nombre" + 
			"FROM " + 
			"proyectos, reuniones,faseproyecto,tipofases " + 
			"WHERE " + 
			"proyectos.idproyecto=  reuniones.idproyecto AND " + 
			"reuniones.idfase = faseproyecto.idfase AND " + 
			"faseproyecto.idtipofase  = tipofases.idtipofase AND " + 
			"proyectos.admin = ?1 ; ", nativeQuery = false)
	List<Map<String, Object>> ControlFasesQuery(String usuario);
	//public ControlFasesDTO ControlFasesQuery(String usuario);
	*/
	
	
}
