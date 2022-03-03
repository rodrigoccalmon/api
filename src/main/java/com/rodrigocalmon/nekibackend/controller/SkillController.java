package com.rodrigocalmon.nekibackend.controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rodrigocalmon.nekibackend.dto.SkillDTO;
import com.rodrigocalmon.nekibackend.entities.Skill;
import com.rodrigocalmon.nekibackend.service.SkillService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/skills")
public class SkillController {

	@Autowired
	private SkillService skillService;

	@ApiOperation(value = "postar skill")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Skill obj) throws IOException {
		obj = skillService.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@ApiOperation(value = "pesquisar skill via id")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Skill> find(@PathVariable Long id) {
		Skill obj = skillService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

	@ApiOperation(value = "atualizar skill via id, " + "não precisa preencher todos os campos, "
			+ "apenas o que deseje alterar")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody SkillDTO skill, @PathVariable Long id) {
		Skill obj = skillService.fromDTO(skill);
		obj.setId(id);
		obj = skillService.update(obj);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "filtro de skills postadas por Id do usuário")
	@GetMapping("/filtrar/{idUsuario}")
	public List<SkillDTO> listarPorUsuario(@PathVariable Long idUsuario) {
		return skillService.listarPorUsuario(idUsuario);
	}

	@ApiOperation(value = "listagem de todas skills")
	@GetMapping("/todas")
	public List<Skill> listar() {
		return skillService.listar();
	}

	@ApiOperation(value = "deletar skill por Id")
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!skillService.idExisteSkill(id)) {
			return ResponseEntity.notFound().build();
		}
		skillService.removerSkill(id);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "atualizar APENAS o nivel de conhecimento")
	@PutMapping("/atualizarskill/{id}")
	public ResponseEntity<Void> updateSkillNivelConhecimento(@Valid @RequestBody SkillDTO skill, @PathVariable Long id) {
		Skill obj = skillService.fromDTO(skill);
		obj.setId(id);
		obj = skillService.update(obj);
		return ResponseEntity.noContent().build();
	}


}