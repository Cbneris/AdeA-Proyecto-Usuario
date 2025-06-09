package com.cbns.adea.usuario.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbns.adea.usuario.entity.UsuarioEntity;
import com.cbns.adea.usuario.repository.UsuarioRepository;
import com.cbns.adea.usuario.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	UsuarioRepository usrRepo;

	@Override
	public Optional<UsuarioEntity> buscaUsuarioPorLogin(String login) {
		return usrRepo.findByLogin(login);
	}
	
}