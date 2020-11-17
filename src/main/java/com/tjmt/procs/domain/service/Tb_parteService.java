package com.tjmt.procs.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.tjmt.procs.domain.dto.Tb_parteDTO;
import com.tjmt.procs.domain.model.Tb_parte;
import com.tjmt.procs.domain.repository.Tb_parteRepository;

@Service
public class Tb_parteService {
	
	@Autowired
	private Tb_parteRepository rep;

	public List<Tb_parteDTO> getTb_parte() {

		return rep.findAll().stream().map(Tb_parteDTO::create).collect(Collectors.toList());

	}

	public Optional<Tb_parteDTO> getTb_parteById(Long id) {
		return rep.findById(id).map(Tb_parteDTO::create);
	}

	public List<Tb_parteDTO> getTb_parteByNome(String nome) {
		return rep.findByNome(nome).stream().map(Tb_parteDTO::create).collect(Collectors.toList());
	}

	public Tb_parteDTO insert(Tb_parte tb_parte) {
		Assert.isNull(tb_parte.getId(), "Nao foi possivel inserir o registro");
		
		return Tb_parteDTO.create(rep.save(tb_parte));
	}

	public Tb_parteDTO update(Tb_parte parte, Long id) {
		Assert.notNull(id, "Nao foi possivel atualizar o registro");

		Optional<Tb_parte> optional = rep.findById(id);
		if (optional.isPresent()) {
			Tb_parte db = optional.get();

			db.setNome(parte.getNome());
			db.setCpf(parte.getCpf());
			db.setDatanascimento(parte.getDatanascimento());
			db.setTipoparte(parte.getTipoparte());
			System.out.println("Parte id: " + db.getId());

			rep.save(db);

			return Tb_parteDTO.create(db);
		} else {
			return null;
		}

	}

	public boolean delete(Long id) {
		
		if (getTb_parteById(id).isPresent()) {
			rep.deleteById(id);
			return true;
		}
		return false;
	}

	
}
