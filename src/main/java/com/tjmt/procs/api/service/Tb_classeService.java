package com.tjmt.procs.api.service;
 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjmt.procs.api.model.Tb_classe;
import com.tjmt.procs.api.repository.Tb_classeRepository;

@Service
public class Tb_classeService {

	@Autowired
	private Tb_classeRepository rep;

	public Iterable<Tb_classe> getTb_classes() {
		return rep.findAll();	
	}

	public Optional<Tb_classe> getTb_classeById(Long id) {
		return rep.findById(id);
	}

	public Iterable<Tb_classe> getTb_classesByTipo(String tipo) {
		return rep.findByTipo(tipo);
	}
}