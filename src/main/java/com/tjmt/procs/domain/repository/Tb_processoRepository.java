package com.tjmt.procs.domain.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tjmt.procs.domain.model.Tb_processo;

@Repository
public interface Tb_processoRepository extends JpaRepository<Tb_processo, Long> {

	List<Tb_processo> findByNrprocesso(String nrprocesso);

	List<Tb_processo> findByDatacriacao(LocalDate datacriacao);
	
	@Query(value = "SELECT * FROM tb_processo AS p WHERE p.data_distribuicao is NULL;", nativeQuery = true)
	List<Tb_processo> findNotExistsDistribuicao();
	
}
