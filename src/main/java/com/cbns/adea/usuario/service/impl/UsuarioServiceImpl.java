package com.cbns.adea.usuario.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbns.adea.usuario.entity.UsuarioEntity;
import com.cbns.adea.usuario.repository.UsuarioRepository;
import com.cbns.adea.usuario.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	protected UsuarioRepository repository;

	@Override
	public List<UsuarioEntity> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<UsuarioEntity> findById(String id) {
		return repository.findById(id);
	}

	@Override
	public UsuarioEntity save(UsuarioEntity usuarioEntiy) {
		return repository.save(usuarioEntiy);
	}

	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
		
	}
	
}