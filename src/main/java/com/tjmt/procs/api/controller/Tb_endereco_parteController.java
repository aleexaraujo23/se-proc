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

import com.tjmt.procs.domain.dto.Tb_endereco_parteDTO;
import com.tjmt.procs.domain.model.Tb_endereco_parte;
import com.tjmt.procs.domain.service.Tb_endereco_parteService;
import com.tjmt.procs.domain.validacep.Endereco;
import com.tjmt.procs.domain.validacep.Util;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Test API Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"endereco-parte-controller"}, description = "Controller da Classe de Endereco das Partes.")
@RestController
@RequestMapping("/api/v1/parte/endereco")
public class Tb_endereco_parteController {

	@Autowired
	private Tb_endereco_parteService service;
	
	@Autowired
	private ViaCepController viacep;
	
	@ApiOperation(value = "Retorna uma lista de enderecos.")
	@GetMapping
	public ResponseEntity<List<Tb_endereco_parteDTO>> get() {
		return ResponseEntity.ok(service.getTb_endereco_parte());

	}

	@ApiOperation(value = "Retorna uma endereco pelo seu ID.")
	@GetMapping("/{id}")
	public ResponseEntity get(@PathVariable("id") Long id) {
		Optional<Tb_endereco_parteDTO> juiz = service.getTb_endenreco_parteById(id);
		return juiz.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@ApiOperation(value = "Cria um novo endereco.")
	@PostMapping
	public ResponseEntity post(@RequestBody Tb_endereco_parte tb_end_parte) {
		
		try {

			// verifica CEP
			Endereco endereco = viacep.doObterCep(tb_end_parte.getCep());
								
			
			if (Util.verifcaEnds(tb_end_parte, endereco) == true) {
				Tb_endereco_parteDTO tb = service.insert(tb_end_parte);
				URI location = getUri(tb.getId());
				return ResponseEntity.created(location).build();
			} else {
				System.out.println("Endereco Nao bate.");
				return ResponseEntity.badRequest().build();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}

	@ApiOperation(value = "Atualiza um endereco pelo seu ID.")
	@PutMapping("/{id}")
	public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Tb_endereco_parte tb_end_parte) {
		Tb_endereco_parteDTO tb = service.update(tb_end_parte, id);
		return tb != null ? ResponseEntity.ok(tb) : ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Deleta um endereco pelo seu ID.")
	@DeleteMapping
	public ResponseEntity delete(@PathVariable("id") Long id) {
		boolean ok = service.delete(id);

		return ok ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
	}

	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}
}
