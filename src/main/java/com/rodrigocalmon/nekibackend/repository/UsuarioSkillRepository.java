package com.rodrigocalmon.nekibackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigocalmon.nekibackend.entities.UsuarioSkill;

@Repository
public interface UsuarioSkillRepository extends JpaRepository<UsuarioSkill, Long>{

}
	