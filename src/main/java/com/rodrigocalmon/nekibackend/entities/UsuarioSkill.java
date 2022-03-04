package com.rodrigocalmon.nekibackend.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class UsuarioSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "skill_id")
	private Skill skill;

	private Integer nivelConhecimento;

	@CreationTimestamp
	private Date criadoEm;

	@UpdateTimestamp
	private Date atualizadoEm;

	public UsuarioSkill() {
		
	}

	public UsuarioSkill(Long id, Usuario usuario, Skill skill, Integer nivelConhecimento) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.skill = skill;
		this.nivelConhecimento = nivelConhecimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
