package com.rodrigocalmon.nekibackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigocalmon.nekibackend.dto.LoginRequest;
import com.rodrigocalmon.nekibackend.dto.LoginResponse;
import com.rodrigocalmon.nekibackend.service.UsuarioService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/login")
public class LoginController {

	@Autowired
	private UsuarioService servicoUsuario;
	
		
	@PostMapping
	public LoginResponse login (@RequestBody LoginRequest request) {		
		return servicoUsuario.logar(request.getEmail(), request.getSenha());
	}
		
}