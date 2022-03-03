package com.rodrigocalmon.nekibackend.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class UsuarioSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuarioSkillPK id = new UsuarioSkillPK();

	private Integer nivelConhecimento;

	@CreationTimestamp
	private Date criadoEm;

	@UpdateTimestamp
	private Date atualizadoEm;

	public UsuarioSkill(Usuario usuario, Skill skill, Integer nivelConhecimento) {
		super();
		id.setUsuario(usuario);
		id.setSkill(skill);		
		this.nivelConhecimento = nivelConhecimento;
	}

	public void setUsuario(Usuario usuario) {
		id.setUsuario(usuario);
	}

	public void setSkill(Skill skill) {
		id.setSkill(skill);
	}

	public Usuario getUsuario() {
		return id.getUsuario();
	}

	public Skill getSkill() {
		return id.getSkill();
	}

	public UsuarioSkillPK getId() {
		return id;
	}

	public void setId(UsuarioSkillPK id) {
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

}
