package com.tjmt.procs.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tjmt.procs.api.model.Tb_classe;


@Repository
public interface Tb_classeRepository extends JpaRepository<Tb_classe, Long> {

	 long count();

	 Iterable<Tb_classe> findByTipo(String tipo);	 
	
	
}