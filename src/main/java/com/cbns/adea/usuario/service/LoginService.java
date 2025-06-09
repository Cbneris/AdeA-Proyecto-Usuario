package com.cbns.adea.usuario.service;

import java.util.Optional;

import com.cbns.adea.usuario.entity.UsuarioEntity;

public interface LoginService{
	Optional<UsuarioEntity> buscaUsuarioPorLogin(String login);
}
