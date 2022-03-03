package com.rodrigocalmon.nekibackend.dto;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.rodrigocalmon.nekibackend.entities.Skill;
import com.rodrigocalmon.nekibackend.entities.Usuario;

public class SkillDTO {

	private Long id;
	private String nome;
	private String versao;
	private String descricao;
	private String imagemUrl;
	private Integer nivelDeConhecimento;
	private Usuario usuario;

	@CreationTimestamp
	private Date criadaEm;
	@UpdateTimestamp
	private Date atualizadaEm;

	public SkillDTO() {

	}

	public SkillDTO(Skill obj) {
		id = obj.getId();
		nome = obj.getNome();
		versao = obj.getVersao();
		descricao = obj.getDescricao();
		imagemUrl = obj.getImagemUrl();
		nivelDeConhecimento = obj.getNivelDeConhecimento();
		usuario = obj.getUsuario();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagemUrl() {
		return imagemUrl;
	}

	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getCriadaEm() {
		return criadaEm;
	}

	public void setCriadaEm(Date criadaEm) {
		this.criadaEm = criadaEm;
	}

	public Date getAtualizadaEm() {
		return atualizadaEm;
	}

	public void setAtualizadaEm(Date atualizadaEm) {
		this.atualizadaEm = atualizadaEm;
	}

	public Integer getNivelDeConhecimento() {
		return nivelDeConhecimento;
	}

	public void setNivelDeConhecimento(Integer nivelDeConhecimento) {
		this.nivelDeConhecimento = nivelDeConhecimento;
	}

}
