package com.tjmt.procs.api.controller;

import java.net.URI;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tjmt.procs.domain.dto.Tb_endereco_parteDTO;
import com.tjmt.procs.domain.dto.Tb_juizDTO;
import com.tjmt.procs.domain.dto.Tb_processoDTO;
import com.tjmt.procs.domain.model.Tb_juiz;
import com.tjmt.procs.domain.model.Tb_processo;
import com.tjmt.procs.domain.service.Tb_processoService;
import com.tjmt.procs.domain.validacep.Util;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Test API Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {
		"processos-controller" }, description = "Controller da Classe de Tipos de Processos.")
@RestController
@RequestMapping("/api/v1/processos")
public class Tb_processoController {

	@Autowired
	private Tb_processoService service;

	@ApiOperation(value = "Retorna uma lista de processos.")
	@GetMapping
	public ResponseEntity<List<Tb_processoDTO>> get() {
		return ResponseEntity.ok(service.getTb_processos());
	}

	@ApiOperation(value = "Busca processo pelo ID.")
	@GetMapping("/nrprocesso/{id}")
	public ResponseEntity get(@PathVariable("id") Long id) {
		Optional<Tb_processoDTO> proc = service.getTb_processoById(id);
		return proc.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@ApiOperation(value = "Busca processo pela data de criacao.")
	@GetMapping("/datacricao/{data_criacao}")
	public ResponseEntity getTb_processoByDatacriacao(@PathVariable("data_criacao") LocalDate datacriacao) {
		List<Tb_processoDTO> proc = service.getTb_processoByDatacriacao(datacriacao);
		return proc.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(proc);
	}

	@ApiOperation(value = "Cria um novo processo.")
	@PostMapping
	public ResponseEntity post(@RequestBody Tb_processo tb_proc) {

		try {

			Tb_processoDTO tb = service.insert(tb_proc);
			URI location = getUri(tb.getId());
			// Update Numero processo
			Tb_processo up = new Tb_processo();
			// Recebendo o Numero do Processo gerado pelo metodo na classe Util
			up.setNrprocesso(Util.geraNrProcesso(tb.getId()));
			tb = service.updateNr(up, tb.getId());

			return ResponseEntity.created(location).build();

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}

	@ApiOperation(value = "Deleta processo pelo ID.")
	@DeleteMapping
	public ResponseEntity delete(@PathVariable("id") Long id) {
		boolean ok = service.delete(id);

		return ok ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
	}

	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}

}
