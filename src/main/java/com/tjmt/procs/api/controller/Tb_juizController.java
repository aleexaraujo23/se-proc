package com.tjmt.procs.api.controller;

import java.net.URI;
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

import com.tjmt.procs.domain.dto.Tb_juizDTO;
import com.tjmt.procs.domain.model.Tb_juiz;
import com.tjmt.procs.domain.service.Tb_juizService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Test API Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"juizes-controller"}, description = "Controller da Classe de Juizes.")
@RestController
@RequestMapping("/api/v1/juiz")
public class Tb_juizController {

	@Autowired
	private Tb_juizService service;

	@ApiOperation(value = "Retorna uma lista de juizes.")
	@GetMapping
	public ResponseEntity<List<Tb_juizDTO>> get() {
		return ResponseEntity.ok(service.getTb_juiz());
	}

	@ApiOperation(value = "Retorna um juiz pelo seu ID.")
	@GetMapping("/{id}")
	public ResponseEntity get(@PathVariable("id") Long id) {
		Optional<Tb_juizDTO> juiz = service.getTb_juizById(id);
		return juiz.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@ApiOperation(value = "Retorna um juiz pelo seu nome.")
	@GetMapping("/{nome}")
	public ResponseEntity getTb_juizByNome(@PathVariable("nome") String nome) {
		List<Tb_juizDTO> juiz = service.getTb_juizByNome(nome);
		return juiz.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(juiz);
	}

	@ApiOperation(value = "Cria um novo juiz.")
	@PostMapping
	public ResponseEntity post(@RequestBody Tb_juiz tb_juiz) {

		try {

			Tb_juizDTO tb = service.insert(tb_juiz);
			URI location = getUri(tb.getId());
			return ResponseEntity.created(location).build();

		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@ApiOperation(value = "Altera um juiz pelo seu ID.")
	@PutMapping("/{id}")
	public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Tb_juiz tb_juiz) {
		Tb_juizDTO tb = service.update(tb_juiz, id);
		return tb != null ? ResponseEntity.ok(tb) : ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Deleta um juiz pelo seu ID.")
	@DeleteMapping
	public ResponseEntity delete(@PathVariable("id") Long id) {
		 boolean ok = service.delete(id);
		
		 return ok ? 
				ResponseEntity.ok().build() :
					ResponseEntity.badRequest().build();
	}

	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}

}
