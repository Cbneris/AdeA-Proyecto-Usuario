package com.cbns.adea.usuario.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbns.adea.usuario.dto.UsuarioLoginRequest;
import com.cbns.adea.usuario.entity.UsuarioEntity;
import com.cbns.adea.usuario.service.EncriptacionShaBase64;
import com.cbns.adea.usuario.service.LoginService;
import com.dervmark.commons.response.EntityResponse;
import com.dervmark.commons.response.ResponseBuilder;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	LoginService loginServ;
	
	@Autowired
	EncriptacionShaBase64 encriptacion;
	
	@PostMapping("/usuarioLogin")
	public ResponseEntity<EntityResponse<Object>> loginUser(@RequestBody UsuarioLoginRequest userLogin) {		
		Optional<UsuarioEntity> optionalUsuario = loginServ.buscaUsuarioPorLogin(userLogin.getUsername());

		//Se valida que exista el usuario
	    if (optionalUsuario.isEmpty()) {
	        return ResponseBuilder.notFound("El usuario con el que intenta ingresar no se encuentra registrado");
	    }
	    
	    UsuarioEntity usuario = optionalUsuario.get();
	    String passwordHasheada = encriptacion.hashSha256Base64(userLogin.getPassword());

	    //Se valida que la contraseña sea correcta
	    if (!passwordHasheada.equals(usuario.getPassword())) {
	        return ResponseBuilder.error("La contraseña es incorrecta", HttpStatus.BAD_REQUEST, null);
	    }
	    
	    LocalDate hoy = LocalDate.now();
	    LocalDate fechaVigencia = usuario.getFechaVigencia().toInstant()
	    	    .atZone(ZoneId.systemDefault())
	    	    .toLocalDate();
	    
	    //Se valida que el usuario sea válido
	    if (fechaVigencia.isBefore(hoy)) {
	        return ResponseBuilder.error("El usuario ya no está vigente", HttpStatus.FORBIDDEN, null);
	    }
	    
	    String mensajeBienvenida = "Bienvenido " + usuario.getNombre();
	    usuario.setPassword("");
	    return ResponseBuilder.success(mensajeBienvenida, usuario);
	}
	
}
