package com.cbns.adea.usuario.service;

import java.util.Optional;

import com.cbns.adea.usuario.entity.UsuarioEntity;
import com.dervmark.commons.service.CommonService;

public interface LoginService extends CommonService<UsuarioEntity>{
	Optional<UsuarioEntity> buscaUsuarioPorLogin(String login);
}
