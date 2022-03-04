package com.rodrigocalmon.nekibackend.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigocalmon.nekibackend.dto.UsuarioSkillDTO;
import com.rodrigocalmon.nekibackend.entities.Skill;
import com.rodrigocalmon.nekibackend.entities.Usuario;
import com.rodrigocalmon.nekibackend.entities.UsuarioSkill;
import com.rodrigocalmon.nekibackend.repository.SkillRepository;
import com.rodrigocalmon.nekibackend.repository.UsuarioRepository;
import com.rodrigocalmon.nekibackend.repository.UsuarioSkillRepository;

@Service
public class UsuarioSkillService {
	@Autowired
	private SkillRepository skillRepo;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private UsuarioSkillRepository usuarioSkillRepo;

	public UsuarioSkill find(Long id) {
		Optional<UsuarioSkill> obj = usuarioSkillRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(id, UsuarioSkill.class.getName()));
	}

	public List<UsuarioSkill> findAll() {
		return usuarioSkillRepo.findAll();
	}

	public UsuarioSkill update(UsuarioSkill obj) {
		UsuarioSkill newObj = find(obj.getId());
		updateData(newObj, obj);
		return usuarioSkillRepo.save(newObj);
	}

	private void updateData(UsuarioSkill newObj, UsuarioSkill obj) {
		newObj.setNivelConhecimento(obj.getNivelConhecimento());
	}

	public void delete(Long id) {
		find(id);
		usuarioSkillRepo.deleteById(id);
	}

	public UsuarioSkill fromDTO(UsuarioSkillDTO objDto) {
		return new UsuarioSkill(objDto.getId(), objDto.getUsuario(), objDto.getSkill(), objDto.getNivelConhecimento());
	}

	public UsuarioSkill inserir(UsuarioSkill obj) throws IOException {
		Optional<Usuario> user = usuarioRepository.findById(obj.getUsuario().getId());
		Optional<Skill> skill = skillRepo.findById(obj.getSkill().getId());
		if (user.isPresent() && skill.isPresent()) {
			return usuarioSkillRepo.save(obj);
		}
		throw new IllegalArgumentException("ID não encontrado.");
	}
}
