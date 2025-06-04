package com.cbns.adea.usuario.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cbns.adea.usuario.entity.UsuarioEntity;
import com.cbns.adea.usuario.repository.UsuarioRepository;
import com.cbns.adea.usuario.service.LoginService;
import com.dervmark.commons.service.impl.CommonServiceImpl;

@Service
public class LoginServiceImpl extends CommonServiceImpl<UsuarioEntity, UsuarioRepository> implements LoginService {

	@Override
	public Optional<UsuarioEntity> buscaUsuarioPorLogin(String login) {
		return repository.findByLogin(login);
	}
	
}