package com.cbns.adea.usuario.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbns.adea.usuario.dto.UsuarioLoginRequest;
import com.cbns.adea.usuario.dto.UsuarioResponse;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@PostMapping("/usuarioLogin")
	public UsuarioResponse loginUser(@RequestBody UsuarioLoginRequest userLogin) {		
		System.out.println(userLogin);
		return null;
	}
	
}
