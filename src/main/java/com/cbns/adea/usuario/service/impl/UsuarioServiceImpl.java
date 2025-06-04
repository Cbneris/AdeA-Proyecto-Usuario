package com.cbns.adea.usuario.service.impl;

import org.springframework.stereotype.Service;

import com.cbns.adea.usuario.entity.UsuarioEntity;
import com.cbns.adea.usuario.repository.UsuarioRepository;
import com.cbns.adea.usuario.service.UsuarioService;
import com.dervmark.commons.service.impl.CommonServiceImpl;

@Service
public class UsuarioServiceImpl extends CommonServiceImpl<UsuarioEntity, UsuarioRepository> implements UsuarioService{
	
}