package com.tjmt.procs.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tjmt.procs.domain.model.Tb_ProcessoJuiz;

@Repository
public interface Tb_ProcessoJuizRepository extends JpaRepository<Tb_ProcessoJuiz, Long> {

	
}
