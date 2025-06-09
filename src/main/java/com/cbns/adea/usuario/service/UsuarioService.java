package com.cbns.adea.usuario.service;

import java.util.List;
import java.util.Optional;

import com.cbns.adea.usuario.entity.UsuarioEntity;

public interface UsuarioService{
	
	public List<UsuarioEntity> findAll();
	
	public Optional<UsuarioEntity> findById(String id);
	
	public UsuarioEntity save(UsuarioEntity usuarioEntiy);
	
	public void deleteById(String id);
}
