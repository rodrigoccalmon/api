package com.rodrigocalmon.nekibackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigocalmon.nekibackend.entities.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
	public Optional<Skill> findById(Long id);
	public List<Skill> findByUsuarioId(Long idUsuario);
}
