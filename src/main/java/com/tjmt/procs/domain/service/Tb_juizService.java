package com.tjmt.procs.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.tjmt.procs.domain.dto.Tb_juizDTO;
import com.tjmt.procs.domain.model.Tb_juiz;
import com.tjmt.procs.domain.repository.Tb_juizRepository;

@Service
public class Tb_juizService {

	@Autowired
	private Tb_juizRepository rep;

	public List<Tb_juizDTO> getTb_juiz() {

		return rep.findAll().stream().map(Tb_juizDTO::create).collect(Collectors.toList());

	}

	public Optional<Tb_juizDTO> getTb_juizById(Long id) {
		return rep.findById(id).map(Tb_juizDTO::create);
	}

	public List<Tb_juizDTO> getTb_juizByNome(String nome) {
		return rep.findByNome(nome).stream().map(Tb_juizDTO::create).collect(Collectors.toList());
	}

	public Tb_juizDTO insert(Tb_juiz tb_juiz) {
		Assert.isNull(tb_juiz.getId(), "Nao foi possivel inserir o registro");
		
		return Tb_juizDTO.create(rep.save(tb_juiz));
	}

	public Tb_juizDTO update(Tb_juiz juiz, Long id) {
		Assert.notNull(id, "Nao foi possivel atualizar o registro");

		Optional<Tb_juiz> optional = rep.findById(id);
		if (optional.isPresent()) {
			Tb_juiz db = optional.get();

			db.setNome(juiz.getNome());
			db.setCpf(juiz.getCpf());
			db.setDatanascimento(juiz.getDatanascimento());
			System.out.println("Juiz id: " + db.getId());

			rep.save(db);

			return Tb_juizDTO.create(db);
		} else {
			return null;
		}

	}

	public boolean delete(Long id) {
		
		if (getTb_juizById(id).isPresent()) {
			rep.deleteById(id);
			return true;
		}
		return false;
	}

}
