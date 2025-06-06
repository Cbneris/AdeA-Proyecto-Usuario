package com.cbns.adea.usuario.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbns.adea.usuario.entity.UsuarioEntity;
import com.cbns.adea.usuario.service.UsuarioService;
import com.dervmark.commons.controller.CommonController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends CommonController<UsuarioEntity, UsuarioService>{
	
}
