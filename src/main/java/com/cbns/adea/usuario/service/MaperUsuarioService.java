package com.cbns.adea.usuario.service;

import com.cbns.adea.usuario.dto.UsuarioResponse;
import com.cbns.adea.usuario.entity.UsuarioEntity;

public interface MaperUsuarioService {
	UsuarioResponse mapeoUsuarioResponse(UsuarioEntity usrEntity);
}