package com.rodrigocalmon.nekibackend.dto;

import com.rodrigocalmon.nekibackend.entities.Usuario;

public class UsuarioDTO {
	
	private Long id;
	private String nome;
	private String email;
	
	public UsuarioDTO() {
		super();
	}
	
	
	public UsuarioDTO(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}