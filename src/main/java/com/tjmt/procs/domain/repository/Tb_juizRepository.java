package com.tjmt.procs.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tjmt.procs.domain.model.Tb_juiz;

@Repository
public interface Tb_juizRepository extends JpaRepository<Tb_juiz, Long> {

	List<Tb_juiz> findByNome(String nome);

	@Query(value = "SELECT * FROM tb_juiz AS j WHERE j.id NOT IN (SELECT juiz_id FROM tb_processo_juiz) LIMIT 1", nativeQuery = true)
	Tb_juiz findNotExistsprocs();
	
	@Query(value = "SELECT * FROM tb_juiz AS j WHERE j.id = (SELECT juiz_id FROM tb_processo_juiz GROUP BY juiz_id ORDER BY count(*) ASC LIMIT 1)", nativeQuery = true)
	Tb_juiz findExistsprocs();
	
}
