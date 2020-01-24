package com.victormarques.cursomc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.victormarques.cursomc.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>  {
		
	@Query("SELECT cidade FROM Cidade cidade WHERE cidade.estado.id = :id ORDER BY cidade.nome")
	List<Cidade> findCidades(@Param("id")Integer id);
	
}
