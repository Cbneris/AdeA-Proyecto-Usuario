package com.cbns.adea.usuario.service;

import com.cbns.adea.usuario.dto.UsuarioDTO;
import com.cbns.adea.usuario.entity.UsuarioEntity;

public interface MaperUsuarioService {
	UsuarioDTO mapeoUsuarioResponse(UsuarioEntity usrEntity);
}