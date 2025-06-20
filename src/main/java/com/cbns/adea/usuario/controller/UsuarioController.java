package com.cbns.adea.usuario.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbns.adea.usuario.commons.ResponseBuilder;
import com.cbns.adea.usuario.dto.UsuarioDTO;
import com.cbns.adea.usuario.entity.UsuarioEntity;
import com.cbns.adea.usuario.mapper.UsuarioMapper;
import com.cbns.adea.usuario.service.EncriptacionShaBase64;
import com.cbns.adea.usuario.service.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	EncriptacionShaBase64 shaBase64;
	
	@Autowired
	UsuarioService service;
	
	@GetMapping("/buscaAllUsers")
	public ResponseEntity<?> buscarUsuarios() {
		List<UsuarioDTO> listUsers = new ArrayList<>();
		
		for(UsuarioEntity usuario : service.findAll()) {
			listUsers.add(UsuarioMapper.toDTO(usuario));
		}		
		
		return ResponseBuilder.success("Lista obtenida correctamente", listUsers);
	}
	
	
	@PostMapping("/encriptionSave")
	public ResponseEntity<?> guarda(@RequestBody UsuarioEntity entity){
		
		try {		
			entity.setPassword(shaBase64.hashSha256Base64(entity.getPassword()));
			entity.setStatus('A');
		}catch (Exception e) {
			return ResponseBuilder.error("ENCRP-001: Ocurrio un error al guardar la informacion", HttpStatus.BAD_REQUEST, null);
		}
		
		UsuarioEntity saved = service.save(entity);		
        return ResponseBuilder.created("Se ha guardado exitosamente el usuario ", UsuarioMapper.toDTO(saved));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateUsuario(@RequestBody UsuarioDTO usuarioUpdate) {
		UsuarioEntity updated = new UsuarioEntity();
		try {
			UsuarioEntity usrUpdateEntity = UsuarioMapper.fromDTO(usuarioUpdate);
			usrUpdateEntity.setFechaModificacion(new Date());
			updated = service.save(usrUpdateEntity);
		} catch (Exception e) {
			return ResponseBuilder.error("Ocurrio un error al actualizar la informacion del usuario", HttpStatus.BAD_REQUEST, null);
		}	
		
		return ResponseBuilder.created("Usuario actualizado exitosamente", updated);
	}
	
	@PutMapping("/bajausuario")
	public ResponseEntity<?> putMethodName(@RequestBody UsuarioDTO usuarioUpdate) {
		UsuarioEntity usuarioBaja = new UsuarioEntity();
		try {
			UsuarioEntity usrBajaEntity = UsuarioMapper.fromDTO(usuarioUpdate);
			usrBajaEntity.setFechaModificacion(new Date());
			usrBajaEntity.setStatus('B');
			usuarioBaja = service.save(usrBajaEntity);
		} catch (Exception e) {
			return ResponseBuilder.error("Ocurrio un error al actualizar la informacion del usuario", HttpStatus.BAD_REQUEST, null);
		}
		return ResponseBuilder.created("Usuario actualizado exitosamente", usuarioBaja);
	}
	
}
