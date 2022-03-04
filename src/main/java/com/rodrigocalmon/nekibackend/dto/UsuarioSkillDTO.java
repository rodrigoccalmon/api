package com.rodrigocalmon.nekibackend.dto;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.rodrigocalmon.nekibackend.entities.Skill;
import com.rodrigocalmon.nekibackend.entities.Usuario;
import com.rodrigocalmon.nekibackend.entities.UsuarioSkill;

public class UsuarioSkillDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer nivelConhecimento;

	@CreationTimestamp
	private Date criadoEm;
	@UpdateTimestamp
	private Date atualizadoEm;

	private Usuario usuario;
	private Skill skill;

	public UsuarioSkillDTO() {

	}

	public UsuarioSkillDTO(UsuarioSkill obj) {
		id = obj.getId();
		nivelConhecimento = obj.getNivelConhecimento();
		criadoEm = obj.getCriadoEm();
		atualizadoEm = obj.getAtualizadoEm();
		usuario = obj.getUsuario();
		skill = obj.getSkill();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNivelConhecimento() {
		return nivelConhecimento;
	}

	public void setNivelConhecimento(Integer nivelConhecimento) {
		this.nivelConhecimento = nivelConhecimento;
	}

	public Date getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(Date criadoEm) {
		this.criadoEm = criadoEm;
	}

	public Date getAtualizadoEm() {
		return atualizadoEm;
	}

	public void setAtualizadoEm(Date atualizadoEm) {
		this.atualizadoEm = atualizadoEm;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

}
