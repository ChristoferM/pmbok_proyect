package com.tesis.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tesis.v1.domain.SubGrupo;
import com.tesis.v1.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,String>{
		
	@Query(value ="SELECT CASE when EXISTS (  select * from usuarios "
			+ "	where usuarios.documento = ?1 )  THEN  TRUE  ELSE  FALSE   END;", nativeQuery = true)
	public boolean  existsByDocument(String documento);
}
	