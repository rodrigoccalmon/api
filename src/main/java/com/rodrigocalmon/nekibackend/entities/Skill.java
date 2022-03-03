package com.rodrigocalmon.nekibackend.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_skill")
	private Long id;
	private String nome;
	private String versao;
	private String descricao;
	private String imagemUrl;
	private Integer nivelDeConhecimento;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@JsonIgnore
	private Date criadaEm;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@JsonIgnore
	private Date atualizadaEm;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public Skill() {

	}

	public Skill(Long id, String nome, String versao, String descricao, String imagemUrl, Date criadaEm,
			Date atualizadaEm, Integer nivelDeConhecimento, Usuario usuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.versao = versao;
		this.descricao = descricao;
		this.imagemUrl = imagemUrl;
		this.usuario = usuario;
		this.criadaEm = criadaEm;
		this.atualizadaEm = atualizadaEm;
		this.nivelDeConhecimento = nivelDeConhecimento;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skill other = (Skill) obj;
		return Objects.equals(id, other.id);
	}

}
