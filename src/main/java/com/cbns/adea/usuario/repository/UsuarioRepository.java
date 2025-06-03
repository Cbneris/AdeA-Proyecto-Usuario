package com.cbns.adea.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbns.adea.usuario.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String>{
	UsuarioEntity findByLogin(String login);
}