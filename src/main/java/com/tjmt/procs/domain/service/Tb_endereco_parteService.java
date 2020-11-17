package com.tjmt.procs.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.tjmt.procs.domain.dto.Tb_endereco_parteDTO;
import com.tjmt.procs.domain.exception.NegocioException;
import com.tjmt.procs.domain.model.Tb_endereco_parte;
import com.tjmt.procs.domain.model.Tb_parte;
import com.tjmt.procs.domain.repository.Tb_endereco_parteRepository;
import com.tjmt.procs.domain.repository.Tb_parteRepository;


@Service
public class Tb_endereco_parteService {

	@Autowired
	private Tb_endereco_parteRepository rep;

	@Autowired
	private Tb_parteRepository repPart;

	public List<Tb_endereco_parteDTO> getTb_endereco_parte() {

		return rep.findAll().stream().map(Tb_endereco_parteDTO::create).collect(Collectors.toList());

	}

	public Optional<Tb_endereco_parteDTO> getTb_endenreco_parteById(Long id) {
		return rep.findById(id).map(Tb_endereco_parteDTO::create);
	}

	public Tb_endereco_parteDTO insert(Tb_endereco_parte tb_end_parte) {
		Assert.isNull(tb_end_parte.getId(), "Nao foi possivel inserir o registro");

		Tb_parte parte = repPart.findById(tb_end_parte.getTb_parte().getId())
				.orElseThrow(() -> new NegocioException("Parte nao encontrada."));

		tb_end_parte.setTb_parte(parte);
		
		return	Tb_endereco_parteDTO.create(rep.save(tb_end_parte));
	
	}

	public Tb_endereco_parteDTO update(Tb_endereco_parte tb_end_parte, Long id) {
		Assert.notNull(id, "Nao foi possivel atualizar o registro");

		Optional<Tb_endereco_parte> optional = rep.findById(id);
		if (optional.isPresent()) {
			Tb_endereco_parte db = optional.get();

			db.setBairro(tb_end_parte.getBairro());
			db.setCidade(tb_end_parte.getCidade());
			db.setEstado(tb_end_parte.getEstado());
			db.setCep(tb_end_parte.getCep());
			db.setLogradouro(tb_end_parte.getLogradouro());
			db.setNumero(tb_end_parte.getNumero());
			System.out.println("Parte id: " + db.getId());

			rep.save(db);

			return Tb_endereco_parteDTO.create(db);
		} else {
			return null;
		}

	}

	public boolean delete(Long id) {

		if (getTb_endenreco_parteById(id).isPresent()) {
			rep.deleteById(id);
			return true;
		}
		return false;
	}

}
