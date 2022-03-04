package com.rodrigocalmon.nekibackend.controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rodrigocalmon.nekibackend.dto.UsuarioSkillDTO;
import com.rodrigocalmon.nekibackend.entities.UsuarioSkill;
import com.rodrigocalmon.nekibackend.service.UsuarioSkillService;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "/api/clienteskill")
public class ClienteSkillController {

	@Autowired
	private UsuarioSkillService us;

	@ApiOperation(value = "pesquisar clienteskill via id")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id) {
		UsuarioSkill obj = us.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@ApiOperation(value = "listagem de todas skills")
	@GetMapping("/todas")
	public List<UsuarioSkill> listar() {
		return us.findAll();
	}

	@ApiOperation(value = "atualizar APENAS o nivel de conhecimento")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody UsuarioSkillDTO objDto, @PathVariable Long id) {
		UsuarioSkill obj = us.fromDTO(objDto);
		obj.setId(id);
		obj = us.update(obj);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "postar clienteskill")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioSkill obj) throws IOException {
		obj = us.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@ApiOperation(value = "deletar clienteskill por Id")
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!us.idExisteSkill(id)) {
			return ResponseEntity.notFound().build();
		}
		us.delete(id);
		return ResponseEntity.noContent().build();
	}

}
