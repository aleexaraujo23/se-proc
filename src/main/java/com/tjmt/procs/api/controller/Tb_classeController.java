package com.tjmt.procs.api.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tjmt.procs.api.model.Tb_classe;
import com.tjmt.procs.api.service.Tb_classeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Test API Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"classe-controller"}, description = "Controller da Classe de Tipos de Processos.")
@RestController
@RequestMapping("/api/v1/classes")
public class Tb_classeController {
	
	@Autowired
	private Tb_classeService service;
	
	@ApiOperation(value = "Retorna uma lista de classes.")
	@GetMapping
	public Iterable<Tb_classe> get() {
		return service.getTb_classes();
	}
	
	@ApiOperation(value = "Retorna uma classe pelo seu id.")
	@GetMapping("/{id}")
	public Optional<Tb_classe> get(@PathVariable("id") Long id) {
		return service.getTb_classeById(id);
	}
	
	@ApiOperation(value = "Retorna uma classe pelo seu tipo.")
	@GetMapping("/tipo/{tipo}")
	public Iterable<Tb_classe> getTb_classesByTipo(@PathVariable("tipo") String tipo) {
		return service.getTb_classesByTipo(tipo);
	}

}
