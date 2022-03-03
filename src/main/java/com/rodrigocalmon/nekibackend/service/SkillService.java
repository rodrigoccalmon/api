package com.rodrigocalmon.nekibackend.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigocalmon.nekibackend.dto.SkillDTO;
import com.rodrigocalmon.nekibackend.entities.Skill;
import com.rodrigocalmon.nekibackend.entities.Usuario;
import com.rodrigocalmon.nekibackend.repository.SkillRepository;
import com.rodrigocalmon.nekibackend.repository.UsuarioRepository;

@Service
public class SkillService {
	@Autowired
	private SkillRepository SkillRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Skill inserirSkill(Skill Skill) {
		return SkillRepository.save(Skill);
	}

	public List<Skill> listar() {
		return SkillRepository.findAll();
	}

	public void removerSkill(Long id) {
		SkillRepository.deleteById(id);
	}

	public Optional<Skill> pesquisarSkillPorId(Long id) {
		return SkillRepository.findById(id);
	}

	public Skill buscar(Long id) {
		Optional<Skill> Skill = SkillRepository.findById(id);
		if (Skill.isPresent()) {
			return Skill.get();
		}
		throw new IllegalArgumentException("ID não encontrado. ");
	}

	public Skill inserir(Skill Skill) throws IOException {
		Optional<Usuario> user = usuarioRepository.findById(Skill.getUsuario().getId());
		if (user.isPresent()) {
			Skill.setUsuario(user.get());
			return SkillRepository.save(Skill);
		}
		throw new IllegalArgumentException("ID não encontrado. ");
	}

	public Skill updateSkill(Skill Skill) {
		Optional<Skill> t = SkillRepository.findById(Skill.getId());
		if (t.isPresent()) {
			t.get().setDescricao(Skill.getDescricao());
			t.get().setImagemUrl(Skill.getImagemUrl());
			t.get().setUsuario(Skill.getUsuario());
			t.get().setVersao(Skill.getVersao());
			t.get().setNome(Skill.getNome());
			t.get().setNivelDeConhecimento(Skill.getNivelDeConhecimento());
			return SkillRepository.save(t.get());
		}
		throw new IllegalArgumentException("ID não encontrado. ");
	}

	public boolean idExisteSkill(Long id) {
		return SkillRepository.existsById(id);
	}

	public List<SkillDTO> listarPorUsuario(Long idUsuario) {
		List<Skill> Skills = SkillRepository.findByUsuarioId(idUsuario);
		List<SkillDTO> SkillsDTO = new ArrayList<>();
		for (Skill Skill : Skills) {
			SkillsDTO.add(addDTO(Skill));
		}
		return SkillsDTO;
	}

	public SkillDTO addDTO(Skill Skill) {
		SkillDTO dto = new SkillDTO();
		dto.setId(Skill.getId());
		dto.setDescricao(Skill.getDescricao());
		dto.setUsuario(Skill.getUsuario());
		dto.setImagemUrl(Skill.getImagemUrl());
		dto.setVersao(Skill.getVersao());
		dto.setNome(Skill.getNome());
		dto.setNivelDeConhecimento(Skill.getNivelDeConhecimento());
		dto.setCriadaEm(Skill.getCriadaEm());
		dto.setAtualizadaEm(Skill.getAtualizadaEm());
		return dto;
	}

	public Skill update(Skill obj) {
		Skill newObj = buscar(obj.getId());
		updateData(newObj, obj);
		return SkillRepository.save(newObj);
	}

	private void updateData(Skill newObj, Skill obj) {
		newObj.setNivelDeConhecimento(obj.getNivelDeConhecimento());
	}

	public Skill fromDTO(SkillDTO objDto) {
		return new Skill(objDto.getId(), objDto.getDescricao(), objDto.getImagemUrl(), objDto.getNome(),
				objDto.getVersao(), objDto.getCriadaEm(), objDto.getAtualizadaEm(), objDto.getNivelDeConhecimento(),
				objDto.getUsuario());
	}
}