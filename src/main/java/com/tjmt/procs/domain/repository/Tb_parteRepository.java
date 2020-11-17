package com.tjmt.procs.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tjmt.procs.domain.model.Tb_parte;

@Repository
public interface Tb_parteRepository extends JpaRepository<Tb_parte, Long> {

	List<Tb_parte> findByNome(String nome);

}
