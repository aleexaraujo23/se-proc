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

import com.tjmt.procs.domain.dto.Tb_parteDTO;
import com.tjmt.procs.domain.model.Tb_parte;
import com.tjmt.procs.domain.service.Tb_parteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Test API Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"partes-controller"}, description = "Controller das Partes do Processo.")
@RestController
@RequestMapping("/api/v1/parte")
public class Tb_parteController {
	

	@Autowired
	private Tb_parteService service;

	@ApiOperation(value = "Retorna uma lista de partes.")
	@GetMapping
	public ResponseEntity<List<Tb_parteDTO>> get() {
		return ResponseEntity.ok(service.getTb_parte());
	}

	@ApiOperation(value = "Retorna uma parte pelo ID.")
	@GetMapping("/{id}")
	public ResponseEntity get(@PathVariable("id") Long id) {
		Optional<Tb_parteDTO> juiz = service.getTb_parteById(id);
		return juiz.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@ApiOperation(value = "Retorna uma parte pelo nome.")
	@GetMapping("/nome/{nome}")
	public ResponseEntity getTb_juizByNome(@PathVariable("nome") String nome) {
		List<Tb_parteDTO> juiz = service.getTb_parteByNome(nome);
		return juiz.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(juiz);
	}

	@ApiOperation(value = "Cria uma nova parte.")
	@PostMapping
	public ResponseEntity post(@RequestBody Tb_parte tb_parte) {

		try {

			Tb_parteDTO tb = service.insert(tb_parte);
			URI location = getUri(tb.getId());
			return ResponseEntity.created(location).build();

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}

	@ApiOperation(value = "Altera uma parte pelo ID.")
	@PutMapping("/{id}")
	public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Tb_parte tb_parte) {
		Tb_parteDTO tb = service.update(tb_parte, id);
		return tb != null ? ResponseEntity.ok(tb) : ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Deleta uma parte pelo ID.")
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
