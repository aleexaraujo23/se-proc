package com.tjmt.procs.domain.service;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.tjmt.procs.domain.dto.Tb_processoDTO;
import com.tjmt.procs.domain.model.Tb_parte;
import com.tjmt.procs.domain.model.Tb_processo;
import com.tjmt.procs.domain.repository.Tb_processoRepository;

@Service
public class Tb_processoService {

	@Autowired
	private Tb_processoRepository rep;

	public List<Tb_processoDTO> getTb_processos() {
		return rep.findAll().stream().map(Tb_processoDTO::create).collect(Collectors.toList());
	}

	public Optional<Tb_processoDTO> getTb_processoById(Long id) {
		return rep.findById(id).map(Tb_processoDTO::create);
	}

	public List<Tb_processoDTO> getTb_processoByNrprocesso(String nrprocesso) {
		return rep.findByNrprocesso(nrprocesso).stream().map(Tb_processoDTO::create).collect(Collectors.toList());
	}

	public List<Tb_processoDTO> getTb_processoByDatacriacao(LocalDate datacriacao) {
		return rep.findByDatacriacao(datacriacao).stream().map(Tb_processoDTO::create).collect(Collectors.toList());
	}

	public Tb_processoDTO insert(Tb_processo tb_processo) {
		Assert.isNull(tb_processo.getId(), "Nao foi possivel inserir o registro");

		tb_processo.setDatacriacao(OffsetDateTime.now());

		return Tb_processoDTO.create(rep.save(tb_processo));
		
		// pegar lista de partes
//		List<Tb_parte> listaProcessoParte2 = tb_processo.getListaProcessoParte();
//
//		System.out.println("-> Tamanho: " + tb_processo.getListaProcessoParte().size());
//		System.out.println("-> nr: " + tb_processo.getNrprocesso());
//		System.out.println("-> dt: " + tb_processo.getDatacriacao());
//		System.out.println("-> classe: " + tb_processo.getTb_classe().getId());
//
//		for (Tb_parte parte : listaProcessoParte2) {
//			System.out.println("-> " + parte.getId());
//		}
//
//		// se partes forem vazias retornar null
//		if (!listaProcessoParte2.isEmpty()) {
//
//		
//
//			// Se Partes nao forem duas (autor/reu) retornar null
//			if (tb_processo.getListaProcessoParte().size() != 2) {
//
//				return null;
//				
//				// se for 2 (autor/réu) salvar processos
//			} else {
//
//				return Tb_processoDTO.create(rep.save(tb_processo));
//
//			}
//
//		} else {
//			return null;
//		}

	}

	// Atualizar nr_processo
	public Tb_processoDTO updateNr(Tb_processo proc, Long id) {
		Assert.notNull(id, "Nao foi possivel atualizar o registro");

		Optional<Tb_processo> optional = rep.findById(id);
		if (optional.isPresent()) {
			Tb_processo db = optional.get();

			db.setNrprocesso(proc.getNrprocesso());

			rep.save(db);

			return Tb_processoDTO.create(db);
		} else {
			return null;
		}

	}

	public boolean delete(Long id) {

		if (getTb_processoById(id).isPresent()) {
			rep.deleteById(id);
			return true;
		}
		return false;
	}

}
