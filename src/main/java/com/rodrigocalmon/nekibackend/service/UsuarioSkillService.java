package com.rodrigocalmon.nekibackend.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigocalmon.nekibackend.entities.UsuarioSkill;
import com.rodrigocalmon.nekibackend.repository.SkillRepository;
import com.rodrigocalmon.nekibackend.repository.UsuarioRepository;
import com.rodrigocalmon.nekibackend.repository.UsuarioSkillRepository;

@Service
public class UsuarioSkillService {
	@Autowired
	private SkillRepository skillRepo;
	@Autowired
	private UsuarioRepository usuarioRepo;
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
	
}
