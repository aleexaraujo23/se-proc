package com.tjmt.procs.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tjmt.procs.domain.model.Tb_endereco_parte;

@Repository
public interface Tb_endereco_parteRepository extends JpaRepository<Tb_endereco_parte, Long> {

}
